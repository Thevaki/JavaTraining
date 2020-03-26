package com.libraryManagementSystem.User.Repository;

import com.libraryManagementSystem.User.Model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser,Integer> {
}
