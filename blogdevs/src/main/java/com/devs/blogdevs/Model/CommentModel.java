package com.devs.blogdevs.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="comentarios")
public class CommentModel {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UserModel user;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private PostModel post;

    @Getter
    @Setter
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Setter
    @Getter
    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dateComent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_coment_id")
    @JsonBackReference
    private CommentModel parentComment;

    @Getter
    @Setter
    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<CommentModel> answers = new ArrayList<>();

    public CommentModel() {
    }

    public CommentModel(Long id, String content, UserModel user, PostModel post, LocalDateTime dateComent, List<CommentModel> answers) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.post = post;
        this.dateComent = dateComent;
        this.answers = answers;
    }
}
