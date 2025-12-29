package me.shinsunyoung.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="users")
@NoArgsConstructor
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name="email", nullable = false, unique = true)
    private String email; // 로그인시 사용하는 ID

    @Column(name="password")
    private String password; // 비밀번호

    @Column(name="auth")
    private String auth; // 권한

    @Column(name="social")
    private boolean social;

    @Builder
    public User(String email, String password, String auth, boolean social){
        this.email = email;
        this.password = password;
        this.auth = auth;
        this.social = social;
    }
}
