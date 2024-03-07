package com.rallyce.Petroleum_Inventario.domain.dto;

import com.rallyce.Petroleum_Inventario.domain.entities.UserSecurityEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthoritySecurityDto {

    private UserSecurityEntity username;

    private String authority;
}
