package com.rallyce.Petroleum_Inventario.repositories;

import com.rallyce.Petroleum_Inventario.domain.entities.EmpleadoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends CrudRepository<EmpleadoEntity, Long> {
}
