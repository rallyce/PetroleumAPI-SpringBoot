package com.rallyce.Petroleum_Inventario.services;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    // Defining secret key to point the signature.
    private static final String secret_key = "4162cf1a919508be4abf2f44e8f2cfc84db121e36fe605f7a29fe0239fc9456b";
    public String getToken(UserDetails empleado) {
        return getToken(new HashMap<>(), empleado);
    }

    // Defining the method to get the token.
    private String getToken(Map<String, Object> extraClaims, UserDetails empleado){
        return Jwts .builder()
                .setClaims(extraClaims)
                .setSubject(empleado.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date (System.currentTimeMillis()+1000*60*24))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Decoding password with the base64 method.

    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret_key);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Subject is the username.
    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    // Getting all claims from the token.

    private Claims getAllClaims(String token){
        // Using Jwts library to get the thing.
        return Jwts
                .parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Using a function to resolve the claims.
    public <T> T getClaim(String token, Function<Claims, T> claimResolver){
        final Claims claims = getAllClaims(token);
        return claimResolver.apply(claims);
    }

    // Getting the date of expiration of the token.
    private Date getExpiration(String token){
        return getClaim(token, Claims::getExpiration);
    }

    // Checking whether the token expired.
    private boolean isTokenExpired(String token){
        return getExpiration(token).before(new Date());
    }
}
