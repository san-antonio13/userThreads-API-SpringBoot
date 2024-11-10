package com.toni.apiUsers.service;

import com.toni.apiUsers.models.UserModel;
import com.toni.apiUsers.repositories.iUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    public iUserRepository userRepo;

    public UserModel createUser(UserModel userModel){
        return userRepo.save(userModel);
    }

    public ArrayList<UserModel> readUser(){
        return  (ArrayList<UserModel>) userRepo.findAll();
    }

    public UserModel updateUser(UserModel userModel, Integer id){
        UserModel user = this.userRepo.findById(id).get();
        System.out.println("Encontrado: " + user);

        user.setNombre(userModel.getNombre());
        user.setCorreo(userModel.getCorreo());
        user.setContrasena(userModel.getContrasena());
        user.setFecha_registro(userModel.getFecha_registro());
        user.setActivo(userModel.getActivo());

        return userRepo.save(user);
    }

    public Boolean deleteUser(Integer id){
        try{
            userRepo.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
