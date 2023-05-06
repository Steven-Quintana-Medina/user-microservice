package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IRolRepository extends JpaRepository<RoleEntity,Long> {
    @Query("SELECT r.name FROM RoleEntity r INNER JOIN UserEntity u ON r.id = u.idRol WHERE u.id = :idRol")
    String findUserRoleById(@Param("idRol") String idRol);
}
