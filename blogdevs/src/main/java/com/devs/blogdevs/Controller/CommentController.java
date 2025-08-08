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

    @PostMapping("/post/create")
    public ResponseEntity<CommentResponse> createdComment(@RequestBody CommentRequest commentRequest){
        CommentModel save = service.createdComment(commentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CommentResponse(save));
    }

    @GetMapping("/post/{postId}/comments")
    public ResponseEntity<List<CommentModel>> listComment (@PathVariable Long postId) {
        List<CommentModel> comments = service.listComment(postId);
        return ResponseEntity.ok(comments);
    }

    @DeleteMapping("/post/delete/{id}")
    public ResponseEntity<Void>deletedComment(@PathVariable Long id){
        service.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/post/edit/{id}")
    public ResponseEntity<CommentResponse> editComment(@RequestBody CommentRequest comment, @PathVariable Long id){
        CommentModel newComment = service.editComment(comment, id);
        return ResponseEntity.ok(new CommentResponse(newComment));
    }


















}
