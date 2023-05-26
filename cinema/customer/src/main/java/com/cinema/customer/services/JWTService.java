package com.cinema.customer.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;
import java.util.Date;

@Service
public class JWTService {


    private RSAPrivateKey rsaPrivateKey;
    private RSAPublicKey rsaPublicKey;
    private long expTime = 0;

    @PostConstruct
    private void initKeys() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
        rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
    }

    public String generateToken(String name, String role) {
        return JWT.create()
                .withClaim("user", name)
                .withClaim("role", role)
//                .withExpiresAt(new Date(System.currentTimeMillis() + expTime))
                .sign(Algorithm.RSA256(rsaPublicKey, rsaPrivateKey));
    }


    public String validateToken(String token) throws JWTVerificationException {
        String encodePayload = JWT.require(Algorithm.RSA256(rsaPublicKey, rsaPrivateKey))
                .build()
                .verify(token)
                .getPayload();

        return new String(Base64.getDecoder().decode(encodePayload));
    }
}

