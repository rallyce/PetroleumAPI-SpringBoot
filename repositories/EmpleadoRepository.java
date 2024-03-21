package com.rallyce.Petroleum_Inventario.repositories;

import com.rallyce.Petroleum_Inventario.domain.entities.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpleadoRepository extends CrudRepository<EmpleadoEntity, Long>, JpaRepository<EmpleadoEntity, Long> {

    Optional<EmpleadoEntity> findByUsername(String username);
}
