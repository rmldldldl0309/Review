package com.example.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.board.entity.FavoriteEntity;
import com.example.board.entity.pk.FavoritePK;

@Repository
public interface FavoriteRepository extends JpaRepository<FavoriteEntity, FavoritePK>{

}
