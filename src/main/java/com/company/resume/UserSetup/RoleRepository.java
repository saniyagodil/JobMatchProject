package com.company.resume.UserSetup;

import com.company.resume.UserSetup.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long>{

    Role findByRole(String role);
}