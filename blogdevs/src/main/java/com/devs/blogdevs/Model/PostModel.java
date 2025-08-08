package com.devs.blogdevs.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "postagens")
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "titulo")
    @JsonProperty("titulo")
    private String title;


    @Column(name = "conteudo")
    @JsonProperty("conteudo")
    private String content;


    @Column(name = "data_criacao", updatable = false )
    @JsonProperty("data_criacao")
    private LocalDate createdDate;


    @ManyToOne
    @JsonIgnoreProperties({"posts", "password"})
    @JoinColumn(name = "usuario_id", nullable = false)
    private UserModel user;


    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<CommentModel> comment = new ArrayList<>();

    public PostModel() {
    }

    public PostModel(Long id, String title, String content, LocalDate createdDate, UserModel user, List<CommentModel> comment) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.user = user;
        this.comment = comment;
    }
}
