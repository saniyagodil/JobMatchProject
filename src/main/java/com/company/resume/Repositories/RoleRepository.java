package com.company.resume.Repositories;

import com.company.resume.Models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long>{

    Role findRoleByRoleName(String name);
}