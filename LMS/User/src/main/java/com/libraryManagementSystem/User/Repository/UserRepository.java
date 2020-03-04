package com.libraryManagementSystem.User.Repository;

import com.libraryManagementSystem.User.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
