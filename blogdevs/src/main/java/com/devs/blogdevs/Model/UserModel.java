package com.devs.blogdevs.Model;

import jakarta.persistence.CascadeType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.OneToMany;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class UserModel implements UserDetails {

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "nome")
    private String name;

    @Getter
    @Setter
    @Column(name = "email")
    private String email;

    @Getter
    @Setter
    @Column(name = "senha")
    private String password;

    @Getter
    @Setter
    @Column(name = "data_cadastro", updatable = false)
    private LocalDateTime registrationDate;

    @Getter
    @Setter
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostModel> posts = new ArrayList<>();

    @Getter
    @Setter
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CommentModel> comment = new ArrayList<>();

    @Getter
    @Setter
    @Column(nullable = false)
    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Mapeia a string 'role' para uma GrantedAuthority
        return List.of(new SimpleGrantedAuthority(role));
    }

    public UserModel() {
    }

    public UserModel(Long id, String name, String email, String password, LocalDateTime registrationDate, List<PostModel> posts, List<CommentModel> comment) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
        this.posts = posts;
        this.comment = comment;
    }
}
