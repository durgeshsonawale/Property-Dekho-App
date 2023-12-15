package com.durgesh.propertydekho.Service;

import com.durgesh.propertydekho.Jwt.GenerateToken;
import com.durgesh.propertydekho.Model.UserContainer;
import com.durgesh.propertydekho.Model.UserDto;
import com.durgesh.propertydekho.Repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    IUserRepo iUserRepo;
    @Autowired
    GenerateToken generateToken;
    public String  addUser( UserContainer user){
        if(iUserRepo.findFirstByEmail(user.getEmail())!=null){
            return "already exist";
        }
        iUserRepo.save(user);
        return "User added Succesfully";
    }

    public UserDto ValidateUser(UserContainer user) {
        UserContainer user1=iUserRepo.findFirstByEmailAndPassword(user.getEmail(),user.getPassword());
        if(user1!=null )
            return new UserDto(generateToken.generateToken(user1));
        else return new UserDto(null);
    }

    public List<UserContainer> getAll() {
        return this.iUserRepo.findAll();
    }
}
