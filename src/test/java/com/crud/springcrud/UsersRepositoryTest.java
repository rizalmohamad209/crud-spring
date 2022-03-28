package com.crud.springcrud;

import com.crud.springcrud.entites.Users;
import com.crud.springcrud.repository.UserRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UsersRepositoryTest {
    @Autowired private UserRepository repo;
     @Test
    public void addUser(){
         Users user = new Users();
         user.setFirstName("Mohamad");
         user.setLastName("Rizal");
         user.setUsername("rizalmohamad");
         user.setEmail("rizalmohamad@gmail.com");
         user.setPassword("Rizalmohamad123");
         Users savedUser =  repo.save(user);

         Assertions.assertThat(savedUser).isNotNull();
         Assertions.assertThat(savedUser.getId()).isGreaterThan(0);

     }
     @Test
    public void testGetAllUsers(){
         Iterable<Users> users = repo.findAll();

         Assertions.assertThat(users).hasSizeGreaterThan(0);

         for(Users user : users){
             System.out.println(user);
         }
     }

     @Test
    public void testUpdateUser(){
         Integer userId = 1;
         Optional<Users> byId = repo.findById(userId);

         Users user = byId.get();
         user.setPassword("rizal1234");
         repo.save(user);

         Users updated = repo.findById(userId).get();
         Assertions.assertThat(updated.getPassword()).isEqualTo("rizal1234");
     }

     @Test
    public void getUserById(){
         Integer userId = 1;
         Optional<Users> optionalUsers = repo.findById(userId);
         Assertions.assertThat(optionalUsers).isPresent();
         System.out.println(optionalUsers.get());
     }

     @Test
    public void deleteUser(){
         Integer userId = 1;
         repo.deleteById(userId);

         Optional<Users> optionalUsers = repo.findById(userId);
         Assertions.assertThat(optionalUsers).isNotPresent();
     }


}
