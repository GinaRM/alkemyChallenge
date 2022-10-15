package com.example.AlkemyChallenge.service;

import com.example.AlkemyChallenge.entity.User;


public interface AuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
