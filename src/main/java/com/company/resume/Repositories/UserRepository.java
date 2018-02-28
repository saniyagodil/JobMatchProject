package com.company.resume.Repositories;

import com.company.resume.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{

    User findByUsername(String username);
    Long countByUsername(String username);




}