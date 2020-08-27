package com.example.demo;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "credentials")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCredentials {
   @Id
   @GeneratedValue
   private long id;

   @Column(unique = true)
   private String username;

   private String password;

   public UserCredentials(String user, String pass) {
      username = user;
      password = pass;
   }
}