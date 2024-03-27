package com.rallyce.Petroleum_Inventario.repositories;

import com.rallyce.Petroleum_Inventario.domain.entities.UserSecurityEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSecurityRepository extends CrudRepository<UserSecurityEntity, Long> {

    @Query("SELECT i FROM UserSecurityEntity i WHERE i.nombre = ?1")
    Optional<UserSecurityEntity> findByNombre(String nombre);
}
