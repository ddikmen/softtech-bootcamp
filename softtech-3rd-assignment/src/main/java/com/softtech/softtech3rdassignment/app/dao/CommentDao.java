package com.softtech.softtech3rdassignment.app.dao;

import com.softtech.softtech3rdassignment.app.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentDao extends JpaRepository<Comment, Long> {

    List<Comment> findAllByProductId(Long id);
    List<Comment> findAllByAccountId(Long id);



}
