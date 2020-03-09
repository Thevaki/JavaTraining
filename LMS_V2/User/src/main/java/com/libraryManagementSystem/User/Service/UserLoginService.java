package com.libraryManagementSystem.User.Service;

import com.libraryManagementSystem.User.Model.User;
import com.libraryManagementSystem.User.Repository.UserRepository;
import com.libraryManagementSystem.User.SecurityConfig.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if(user==null) {
            throw new UsernameNotFoundException("User 404");
        }

        return new UserPrincipal(user);
    }
}
