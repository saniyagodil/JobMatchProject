package com.company.resume.Security;

import com.company.resume.Models.Role;
import com.company.resume.Models.User;
import com.company.resume.Repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Service
public class SSUserDetailsService implements UserDetailsService{

    private UserRepository userRepository;

    public SSUserDetailsService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User myUser = userRepository.findByUsername(username);
            if(myUser == null){
                return null;
            }
            return new org.springframework.security.core.userdetails.User(myUser.getUsername(), myUser.getPassword(), getAuthorities(myUser));
        } catch (Exception e){
            throw new UsernameNotFoundException("User not found");
        }
    }

    private Set<GrantedAuthority> getAuthorities(User user){
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for(Role role: user.getRoles()){
            GrantedAuthority grantedAuthority=new SimpleGrantedAuthority(role.getRoleName());
            authorities.add(grantedAuthority);

        }
        return authorities;

    }



}