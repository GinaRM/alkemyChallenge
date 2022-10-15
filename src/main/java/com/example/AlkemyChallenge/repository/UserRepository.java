package com.example.AlkemyChallenge.repository;


import com.example.AlkemyChallenge.entity.Role;
import com.example.AlkemyChallenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
@Modifying
@Query("update User set role = :role where email= :email")
    void updateUserRole(@Param("email") String email, @Param("role") Role role);
}
