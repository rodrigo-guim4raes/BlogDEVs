package com.devs.blogdevs.Repository;

import com.devs.blogdevs.Model.CommentModel;
import com.devs.blogdevs.Model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentModel, Long> {
    List<CommentModel> findByPostId(Long postId);
}
