package com.devs.blogdevs.Service;

import com.devs.blogdevs.Model.CommentModel;
import com.devs.blogdevs.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repository;

    public CommentModel createdComment(CommentModel comment){
                return repository.save(comment);
    }

    public void deletePost(Long id){
        repository.deleteById(id);
    }

    public List<CommentModel> listComment(){
        return repository.findAll();
    }

    public CommentModel editComment(CommentModel edit, Long id){
        CommentModel newComment = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Comentário não encontrada"));

       newComment.setContent(edit.getContent());

        return repository.save(newComment);
    }
}
