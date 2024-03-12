package com.rallyce.Petroleum_Inventario.repositories;

import com.rallyce.Petroleum_Inventario.domain.entities.UserSecurityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSecurityRepository extends CrudRepository<UserSecurityEntity, Long> {
}
