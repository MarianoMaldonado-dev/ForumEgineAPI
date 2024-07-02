package com.alurachallenges.forohub.forumengineapi.Domain.User;

import java.util.Collection;
import java.util.List;

import com.alurachallenges.forohub.forumengineapi.Domain.user.DTO.DTOUserRegister;
import com.alurachallenges.forohub.forumengineapi.Domain.user.DTO.DTOUserUpdate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private boolean active;

    public User(DTOUserRegister dtoUserRegister, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.name = dtoUserRegister.name();
        this.email = dtoUserRegister.email();
        this.username = dtoUserRegister.username();
        this.password = bCryptPasswordEncoder.encode(dtoUserRegister.password());
        this.active = true;
    }

    public void UserUpdate(DTOUserUpdate dtoUserUpdate) {
        if (dtoUserUpdate.name() != null) {
            this.name = dtoUserUpdate.name();
        }
        //Consultar
        /*if (dtoUserUpdate.email() != null) {
            this.email = dtoUserUpdate.email();
        }*/
    }

    public void desactivateUser() {
        this.active = false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}