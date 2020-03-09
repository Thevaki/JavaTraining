package com.libraryManagementSystem.User.Service;

import com.libraryManagementSystem.User.Model.User;

import java.util.List;

public interface UserService {

    User createUser(User book);

    User editUserDetails(User book);

    User deleteUser(Integer id);

    User findUserById(Integer id);

    List<User> fetchAllUsers();
}
