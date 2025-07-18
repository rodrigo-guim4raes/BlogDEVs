package com.devs.blogdevs.Controller;

import com.devs.blogdevs.Model.PostModel;
import com.devs.blogdevs.Repository.PostRepository;
import com.devs.blogdevs.Service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inicio")
public class PostController { //RECEBE LÓGICA HTTP E DELEGA

    private final PostRepository connectionRepository;
    private PostService service;

    public PostController(PostRepository connectionRepository, PostService service) {
        this.connectionRepository = connectionRepository;
        this.service = service;
    }

    @PostMapping("/postagem") //criar novas postagens
    public ResponseEntity<PostModel> createdPost(@RequestBody PostModel postModel){
            PostModel save = service.createdPost(postModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(save);

    }

    @GetMapping //listar novas postagens
    public ResponseEntity<List<PostModel>> listPost() {
        List<PostModel> post = service.listPost();
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/postagem/{id}")
    public ResponseEntity<Void>deletedPost(@PathVariable Long id){
        service.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/postagem/{id}")
    public ResponseEntity<PostModel> editPost(@RequestBody PostModel post, @PathVariable Long id){
        PostModel newPost = service.editPost(post, id);
        return ResponseEntity.ok(newPost);
    }

}

