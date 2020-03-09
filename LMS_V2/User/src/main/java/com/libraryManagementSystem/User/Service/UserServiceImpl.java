package com.libraryManagementSystem.User.Service;

import com.libraryManagementSystem.User.Model.User;
import com.libraryManagementSystem.User.Repository.UserRepository;
import com.libraryManagementSystem.User.SecurityConfig.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user){
        return userRepository.save(user);
    }

    public User editUserDetails(User user){return userRepository.save(user);}

    public User deleteUser(Integer id){
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()) {
            userRepository.deleteById(id);
            return user.get();
        }
        return null;

    }

    public User findUserById(Integer id){
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()) {
            return user.get();
        }
        return null;
    }

    public List<User> fetchAllUsers(){
        List<User> users = userRepository.findAll();

        if(users.isEmpty()){
            return null;
        }
        return  users;
    }

}
