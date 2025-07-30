package com.devs.blogdevs.Controller;

import com.devs.blogdevs.Model.PostModel;
import com.devs.blogdevs.Model.UserModel;
import com.devs.blogdevs.Repository.PostRepository;
import com.devs.blogdevs.Repository.UserRepository;
import com.devs.blogdevs.dto.PostResponse;
import com.devs.blogdevs.Service.PostService;
import com.devs.blogdevs.dto.PostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController { //RECEBE LÓGICA HTTP E DELEGA

    @Autowired
    private final PostRepository connectionRepository;

    private PostService service;

    @Autowired
    private UserRepository userRepository;

    public PostController(PostRepository connectionRepository, PostService service) {
        this.connectionRepository = connectionRepository;
        this.service = service;
    }

    @PostMapping("/posts") //criar novas postagens
    public ResponseEntity<PostResponse> createdPost(@RequestBody PostRequest postRequest){
        UserModel userModel = userRepository.findById(postRequest.getUserID())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

            PostModel postModel = new PostModel();
            postModel.setTitle(postRequest.getTitle());
            postModel.setContent(postRequest.getContent());
            postModel.setCreatedDate(postRequest.getCreatedDate());
            postModel.setUser(userModel);

            PostModel save = connectionRepository.save(postModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(new PostResponse(save));
    }

    @GetMapping //listar novas postagens
    public ResponseEntity<List<PostModel>> listPost() {
        List<PostModel> post = service.listPost();
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void>deletedPost(@PathVariable Long id){
        service.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<PostModel> editPost(@RequestBody PostModel post, @PathVariable Long id){
        PostModel newPost = service.editPost(post, id);
        return ResponseEntity.ok(newPost);
    }

}

