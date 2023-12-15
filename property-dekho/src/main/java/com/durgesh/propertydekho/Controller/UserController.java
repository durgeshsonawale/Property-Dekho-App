package com.durgesh.propertydekho.Controller;

import com.durgesh.propertydekho.Model.UserContainer;
import com.durgesh.propertydekho.Model.UserDto;
import com.durgesh.propertydekho.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "user")
@CrossOrigin(origins = "http://localhost:64800")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("add")
    public String addUser(@RequestBody UserContainer user){
        return userService.addUser(user);

    }
    @PostMapping("validate")
    UserDto ValidateUser(@RequestBody UserContainer user){
        return this.userService.ValidateUser(user);
    }
    @GetMapping("restricted")
    List<UserContainer> getAll(){
        return this.userService.getAll();
    }
}
