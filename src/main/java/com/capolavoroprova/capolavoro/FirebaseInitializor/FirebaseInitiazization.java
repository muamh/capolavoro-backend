package com.capolavoroprova.capolavoro.FirebaseInitializor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import jakarta.annotation.PostConstruct;


@CrossOrigin(origins = "*")
@Configuration
public class FirebaseInitiazization {

    @PostConstruct
    public void initialize() {
        /*2° letto*/
        try {
            System.out.println("\n\nEntro 1\n\n");
            GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream("./src/main/resources/config/mumah-estate-firebase-adminsdk-4ydlh-0914b0ac8b.json"));
            System.out.println("\n\nEntro 2\n\n");
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(credentials)
                    .build();
            System.out.println("\n\nEntro 3\n\n");
            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            System.out.println("\n\nEntro errore\n\n");
            e.printStackTrace();
        }
    }
/*
    public void FirebaseInitializor() throws IOException{
        System.out.println("\n\nSono entrato in: " + this.getClass() + "\n\n");
        /*FileInputStream serviceAccount = null;
        FirebaseOptions options = null;
        

        try {
            System.out.println("\n\nSono entrato nel try di: " + this.getClass() + "\n\n");
            serviceAccount = new FileInputStream("./src/main/resources/config/mumah-estate-firebase-adminsdk-4ydlh-0914b0ac8b.json");
            System.out.println("\n\nho letto il file dentro il try di: " + this.getClass() + "\n\n");
            options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .build();
            System.out.println("\n\nho buildato le options dentro il try di: " + this.getClass() + "\n\n");
            System.out.println("\n\necco options dentro il try: " + options.toString() + "\n\n");
        } catch (Exception e) {
            System.out.println("\n\n\nEntrato nel catch di: " + this.getClass() + "\n\n");
        }

        FirebaseApp.initializeApp(options);

    }

    public String getToken(){
        return this.token;
    }*/
}
