package com.example.board.entity;

import com.example.board.entity.pk.FavoritePK;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
@Entity(name="favorite")
@Table(name="favorite")

@IdClass(FavoritePK.class)
public class FavoriteEntity {
    @Id
    private Integer boardNumber;
    @Id
    private String userEmail;
}
