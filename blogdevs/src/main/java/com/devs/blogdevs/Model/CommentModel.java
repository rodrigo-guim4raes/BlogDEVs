package com.devs.blogdevs.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="comentarios")
public class CommentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UserModel user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    @JsonBackReference
    private PostModel post;

    @Column(name = "conteudo", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDate dateComent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_comment_id")
    @JsonBackReference
    private CommentModel parentComment;

    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<CommentModel> answers = new ArrayList<>();

    public CommentModel() {
    }

    public CommentModel(Long id, String content, UserModel user, PostModel post, LocalDate dateComent, List<CommentModel> answers) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.post = post;
        this.dateComent = dateComent;
        this.answers = answers;
    }
}
