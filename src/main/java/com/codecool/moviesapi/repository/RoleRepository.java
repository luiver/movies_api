package com.codecool.moviesapi.repository;

import com.codecool.moviesapi.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends
        FilterActiveCrudRepository<Role>,
        FindableByName<Role> {

    Iterable<Role> findAllByIsActiveTrue();

    Role findByNameIgnoreCase(String name);
}
