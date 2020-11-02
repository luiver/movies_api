package com.codecool.moviesapi.controller;

import com.codecool.moviesapi.entity.Role;
import com.codecool.moviesapi.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController extends GenericController<Role> {

    @Autowired
    RoleController(@Qualifier("roleService") GenericService<Role> service) {
        super(service);
    }
}