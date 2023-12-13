package com.baches.User_dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baches.User.User;

public interface User_Dao extends JpaRepository<User, Long> {

}
