package com.toni.apiUsers.controller;

import com.toni.apiUsers.models.UserModel;
import com.toni.apiUsers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    UserService userServ;

    @PostMapping("/register")
    public UserModel createdUser(@RequestBody UserModel user){
        return this.userServ.createUser(user);
    }

    @GetMapping()
    public ArrayList<UserModel> readUserAll(){
        return this.userServ.readUser();
    }

    @PutMapping(path = "/{id}")
    public UserModel updateUser(@RequestBody UserModel user, @PathVariable("id") Integer id){
        return this.userServ.updateUser(user, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        boolean ok = this.userServ.deleteUser(id);
        if(ok){
            return "User deleted";
        }else{
            return "error deleted";
        }
    }
}
