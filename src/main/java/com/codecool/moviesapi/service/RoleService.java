package com.codecool.moviesapi.service;

import com.codecool.moviesapi.repository.RoleRepository;
import com.codecool.moviesapi.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends GenericService<Role> {

    @Autowired
    RoleService(CrudRepository<Role, Long> repository) {
        super(repository);
    }

    public Role getByName(String name) {
        return ((RoleRepository) repository).findByNameIgnoreCase(name);
    }
}
