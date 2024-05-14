package com.capolavoroprova.capolavoro.Services;

import com.capolavoroprova.capolavoro.Entity.Casa;
import com.capolavoroprova.capolavoro.Entity.User;
import com.capolavoroprova.capolavoro.Repositories.UserRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired//Istanzia automaticamente casaRepository
    private UserRepository userRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public boolean checkUser(String uid){
        List<User> userTrovato = mongoTemplate.find(Query.query(Criteria.where("uid").regex(uid, "i")), User.class);
        return true;
    }

    public Cookie giveCookieToLogin(String email, String password) {
        try {
            FirebaseAuth auth = FirebaseAuth.getInstance();
            //AuthResult authResult = auth.signInWithEmailAndPassword(email, password);

            if (/*authResult*/"" != null) {
                String uid = "";
                Cookie cookie = createCookie(uid);
                return cookie;
            } else {
                return null;
            }
        } catch (Exception e) {
            // Handle authentication errors
            e.printStackTrace();
            return null;
        }
    }

    // Method to create a cookie
    private Cookie createCookie(String uid) {

        String cookieValue = uid;
        Cookie cookie = new Cookie("userId", cookieValue);

        cookie.setMaxAge(3600);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");

        return cookie;
    }

}
