package com.example.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.board.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{

    Boolean existsByEmail(String email);
    Boolean existsByNickname(String nickname);
    Boolean existsByTelNumber(String telNumber);
    UserEntity findByEmail(String email);

}
