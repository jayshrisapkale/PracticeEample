package com.user.repository;


import com.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRpository extends JpaRepository<User,Integer> {
}
