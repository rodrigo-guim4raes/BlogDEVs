package com.devs.blogdevs.Service;

import com.devs.blogdevs.Model.CommentModel;
import com.devs.blogdevs.Model.PostModel;
import com.devs.blogdevs.Model.UserModel;
import com.devs.blogdevs.Repository.CommentRepository;
import com.devs.blogdevs.Repository.PostRepository;
import com.devs.blogdevs.Repository.UserRepository;
import com.devs.blogdevs.dto.CommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    public CommentModel createdComment(CommentRequest request) {
        UserModel user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        PostModel post = postRepository.findById(request.getPostId())
                .orElseThrow(() -> new RuntimeException("Post não encontrado"));

        CommentModel comment = new CommentModel();
        comment.setContent(request.getContent()); // ESSENCIAL
        comment.setUser(user);
        comment.setPost(post);
        comment.setDateComent(LocalDate.now());

        return commentRepository.save(comment);
    }


    public void deletePost(Long id){
        commentRepository.deleteById(id);
    }

    public List<CommentModel> listComment(){
        return commentRepository.findAll();
    }

    public CommentModel editComment(CommentModel edit, Long id){
        CommentModel newComment = commentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Comentário não encontrada"));

       newComment.setContent(edit.getContent());

        return commentRepository.save(newComment);
    }
}
