package com.codecool.moviesapi.dao;

import com.codecool.moviesapi.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends
        FilterActive<Role>,
        CrudRepository<Role, Long>,
        FindableByName<Role> {

    Iterable<Role> findAllByIsActiveTrue();

    Role findByNameIgnoreCase(String name);
}
