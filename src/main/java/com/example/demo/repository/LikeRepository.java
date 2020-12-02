package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Like;

public interface LikeRepository extends JpaRepository<Like, Integer> {
    @Query(value = "SELECT * FROM post_like WHERE user_id = ?1 and post_id = ?2", nativeQuery = true)
    Like findByUserIdPostId(int user_id, int post_id);

    @Query(value = "SELECT COUNT(*) FROM post_like WHERE post_id = ?1", nativeQuery = true)
    int getLikeCountByPostId(int post_id);
}
