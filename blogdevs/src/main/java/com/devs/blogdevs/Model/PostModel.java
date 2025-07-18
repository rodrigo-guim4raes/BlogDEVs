package com.devs.blogdevs.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "postagens")
public class PostModel {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "titulo")
    @JsonProperty("titulo")
    private String title;

    @Getter
    @Setter
    @Column(name = "conteudo")
    @JsonProperty("conteudo")
    private String content;

    @Getter
    @Setter
    @Column(name = "data_criacao", updatable = false )
    @JsonProperty("data_criacao")
    private LocalDateTime createdDate;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UserModel user;

    @Getter
    @Setter
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<CommentModel> comment = new ArrayList<>();

    public PostModel() {
    }

    public PostModel(Long id, String title, String content, LocalDateTime createdDate, UserModel user, List<CommentModel> comment) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.user = user;
        this.comment = comment;
    }
}
