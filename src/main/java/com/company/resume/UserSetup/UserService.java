package com.company.resume.UserSetup;

import com.company.resume.ResumeModels.Resume;
import com.company.resume.UserSetup.RoleRepository;
import com.company.resume.UserSetup.User;
import com.company.resume.UserSetup.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;



    @Autowired
    public UserService(UserRepository userRepository){

        this.userRepository= userRepository;
    }

    public UserService() {
    }

    public User findByUsername(String username){   return userRepository.findByUsername(username); }

    public void saveApplicant(User user){
        user.setRoles(Arrays.asList(roleRepository.findByRole("APPLICANT")));
        user.setResume(new Resume());
        userRepository.save(user);
    }


    public void saveEmployer(User user){
        user.setRoles(Arrays.asList(roleRepository.findByRole("EMPLOYER")));
        userRepository.save(user);
    }

//    public <User> findApplicants(UserRepository){
//
//    }


    public Long countByUsername(String username){
        return userRepository.countByUsername(username);
    }

}