//package com.capolavoroprova.capolavoro.Services;
//
//import com.capolavoroprova.capolavoro.Models.Ruolo;
//import com.capolavoroprova.capolavoro.Models.UserAuthenticated;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserAuthenticationImplementation implements AuthenticationService {
//
//    private final UserService userService;
//
//    @Autowired
//    public UserAuthenticationImplementation(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public UserAuthenticated getAuthentication(String uid) {
//        userService.checkUser(uid);
//        // TODO
//        /*
//        * Prendere UserEntity dall'uid preso in input
//        * e convertirlo in UserAuthenticated
//        * */
//        return new UserAuthenticated(
//                "UID TEST",
//                Ruolo.ADMIN
//        );
//    }
//}
