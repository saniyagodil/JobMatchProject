package com.company.resume.Security;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long>{

    Role findByRole(String role);
}