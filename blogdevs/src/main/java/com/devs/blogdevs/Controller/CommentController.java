package com.devs.blogdevs.Controller;

import com.devs.blogdevs.Model.CommentModel;
import com.devs.blogdevs.Repository.CommentRepository;
import com.devs.blogdevs.Service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentário")
public class CommentController {

    private final CommentRepository commentRepository;
    private CommentService service;

    public CommentController(CommentRepository commentRepository, CommentService service) {
        this.commentRepository = commentRepository;
        this.service = service;
    }

    @PostMapping("/postagem/criar/{id}") //criar novas postagens
    public ResponseEntity<CommentModel> createdComment(@RequestBody CommentModel commentModel){
        CommentModel save = service.createdComment(commentModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @GetMapping //listar novas postagens
    public ResponseEntity<List<CommentModel>> listComment() {
        List<CommentModel> post = service.listComment();
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/postagem/deletar/{id}")
    public ResponseEntity<Void>deletedComment(@PathVariable Long id){
        service.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/postagem/editar/{id}")
    public ResponseEntity<CommentModel> editComment(@RequestBody CommentModel comment, @PathVariable Long id){
        CommentModel newComment = service.editComment(comment, id);
        return ResponseEntity.ok(newComment);
    }

















}
