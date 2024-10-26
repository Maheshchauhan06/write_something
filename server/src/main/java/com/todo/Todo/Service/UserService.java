package com.todo.Todo.Service;


import com.todo.Todo.Entitiy.UserEntity;
import com.todo.Todo.Repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private  final UserRepo userRepo;

    public UserEntity createUser(UserEntity user){
        return userRepo.save(user);
    }

    public UserEntity getUser(Long id){
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public UserEntity updateUser(Long id , UserEntity user){
         UserEntity currUser = userRepo.findById(id)
                 .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

         currUser.setUserName(user.getUserName());
         currUser.setEmail(user.getEmail());
         currUser.setPassword(user.getPassword());
         currUser.setBio(user.getBio());
         currUser.setProfilePic(user.getProfilePic());

         return userRepo.save(currUser);
    }


    public void deleteUser(Long id){
        // Fetch the user by ID, or throw an exception if not found
        UserEntity currUser = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        // Delete the user by ID
        userRepo.deleteById(id);
    }


    public List<UserEntity> getAllUser(){
        return userRepo.findAll();
    }



}
