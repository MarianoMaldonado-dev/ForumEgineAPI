package com.alurachallenges.forohub.forumengineapi.Infrastructure.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import com.alurachallenges.forohub.forumengineapi.Domain.Repository.UserRepository;
import com.alurachallenges.forohub.forumengineapi.Domain.User.User;

import static org.springframework.security.config.Elements.JWT;

@Service
public class TokenService {
    private User user;
    @Autowired
    private UserRepository userRepository;

    public String generateToken(User user) {
        Date = new Date();
        Date expiryDate = new Date(now.getTime() + expirationTime);
        try {
            Algorithm algorithm = Algorithm.HMAC256(user.getPassword());
            return JWT.create()
                    .withIssuer("Forum Engine API")
                    .withSubject(user.getUsername())
                    .withClaim("id", user.getId())
                    .withExpiresAt(expirationdate())
                    .sign(algorithm);
                    //.signWith(SignatureAlgorithm.HS512, secretKey) Error de compilación, no entiendo por qué.
                    //.compact();
        } catch (JWTCreationException exception) {
            throw new RuntimeException();
        }
    }

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private Long expirationTime;

    public String getSubject(String token) {
        if (token == null) {
            throw new IllegalArgumentException("Token no válido o nulo.");
        }
        try {
            DecodedJWT decodedJWT = JWT.decode(token);
            String username = decodedJWT.getSubject();
            if (username == null) {
                throw new IllegalArgumentException("Token inválido: Usuario no encontrado");
            }
            User user = (User) userRepository.findByUsername(username);
            if (user == null) {
                throw new IllegalArgumentException("El nombre de usuario proporcionado no se encuentra: " + username);
            }

            Algorithm algorithm = Algorithm.HMAC256(user.getPassword());
            DecodedJWT verifier = JWT.require(algorithm)
                    .withIssuer("Forum Engine API")
                    .build()
                    .verify(token);

            return verifier.getSubject();
        } catch (JWTVerificationException | IllegalArgumentException e) {
            throw new IllegalArgumentException("Token inválido: " + e.getMessage(), e);
        }
    }

    private Instant expirationdate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e){
            return false;
        } /*if (Exception e) = true
                System.out.println(e.getMessage());
        }*/ //Este if debe mejorarse y hacer que funcione
    }

    public String getUsernameFromToken(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}
