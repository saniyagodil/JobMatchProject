package com.company.resume.Security;

import com.company.resume.Models.Role;
import com.company.resume.Repositories.RoleRepository;
import com.company.resume.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {


    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Loading Data... ");

        roleRepository.save(new Role("APPLICANT"));
        roleRepository.save(new Role("RECRUITER"));
        roleRepository.save(new Role("EMPLOYER"));

        Role adminRole = roleRepository.findByRole("APPLICANT");
        Role userRole = roleRepository.findByRole("EMPLOYER");
        Role recruiterRole = roleRepository.findByRole("RECRUITER");

//        user.setRoles(Arrays.asList(userRole, adminRole));
//        userRepository.save(user);
    }

}


