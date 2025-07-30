package com.devs.blogdevs.Controller;

import com.devs.blogdevs.Model.CommentModel;
import com.devs.blogdevs.Repository.CommentRepository;
import com.devs.blogdevs.Service.CommentService;
import com.devs.blogdevs.dto.CommentRequest;
import com.devs.blogdevs.dto.CommentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coment")
public class CommentController {

    private final CommentRepository commentRepository;
    private CommentService service;

    public CommentController(CommentRepository commentRepository, CommentService service) {
        this.commentRepository = commentRepository;
        this.service = service;
    }

    @PostMapping("/posts/create")
    public ResponseEntity<CommentResponse> createdComment(@RequestBody CommentRequest commentRequest){
        CommentModel save = service.createdComment(commentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CommentResponse(save));
    }

    @GetMapping
    public ResponseEntity<List<CommentModel>> listComment() {
        List<CommentModel> post = service.listComment();
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/posts/delete/{id}")
    public ResponseEntity<Void>deletedComment(@PathVariable Long id){
        service.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/posts/edit/{id}")
    public ResponseEntity<CommentModel> editComment(@RequestBody CommentModel comment, @PathVariable Long id){
        CommentModel newComment = service.editComment(comment, id);
        return ResponseEntity.ok(newComment);
    }

















}
