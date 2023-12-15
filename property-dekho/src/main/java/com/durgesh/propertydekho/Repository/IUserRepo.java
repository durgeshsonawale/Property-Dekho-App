package com.durgesh.propertydekho.Repository;

import com.durgesh.propertydekho.Model.UserContainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<UserContainer,Integer> {
    UserContainer findFirstByEmailAndPassword(String email,String password);
    UserContainer findFirstByEmail(String email);

}
