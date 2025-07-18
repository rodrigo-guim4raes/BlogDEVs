package com.devs.blogdevs.Repository;

import com.devs.blogdevs.Model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostModel, Long> {
}
