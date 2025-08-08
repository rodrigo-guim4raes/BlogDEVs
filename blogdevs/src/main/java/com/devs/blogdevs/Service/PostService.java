package com.devs.blogdevs.Service;

import com.devs.blogdevs.Model.PostModel;
import com.devs.blogdevs.Repository.PostRepository;
import com.devs.blogdevs.dto.PostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostService {

    // SERVICE = PROCESSA LÓGICA DE NEGOCIO
    // REPOSITORY = ACESSA DADOS NO BANCO(VIA JPA)

    @Autowired
    private PostRepository repository;

    public PostModel createdPost(PostModel post){
        return repository.save(post);
    }

    public void deletePost(Long id){
        PostModel post = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post não encontrado"));

        repository.deleteById(id);
    }

    public List<PostModel> listPost(){
        return repository.findAll();
    }

    public PostModel editPost(PostRequest postRequest, Long id){
        PostModel newPost = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Postagem não encontrada"));

        if (postRequest.getTitle() != null) {
            newPost.setTitle(postRequest.getTitle());
        }
        if (postRequest.getContent() != null){
            newPost.setContent(postRequest.getContent());
        }

        return repository.save(newPost);
    }
}
