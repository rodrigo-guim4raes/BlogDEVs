package com.devs.blogdevs.Service;

import com.devs.blogdevs.Model.PostModel;
import com.devs.blogdevs.Repository.PostRepository;
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
        repository.deleteById(id);
    }

    public List<PostModel> listPost(){
        return repository.findAll();
    }

    public PostModel editPost(PostModel edit, Long id){
        PostModel newPost = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Postagem não encontrada"));

        newPost.setTitle(edit.getTitle());
        newPost.setContent(edit.getContent());

        return repository.save(newPost);
    }
}
