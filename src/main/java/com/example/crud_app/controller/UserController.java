package com.example.crud_app.controller;

import com.example.crud_app.models.User;
import com.example.crud_app.service.UserRepositoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path="/user")

public class UserController 
{
    @Autowired
    private UserRepositoryService userService; 

    
    // CREATE
    
    @PostMapping(path = "/add")
    public User addNewUser(@RequestParam String name, @RequestParam String email, @RequestParam String country)
    {

        try 
        {
            return userService.saveUser(name, email, country);    
        } catch (Exception e) 
        {
            return null;
        }
    
        
    }

    //GET

    @GetMapping("/all")
    public Iterable<User> getAllUsers()
    {
        try 
        {
            return userService.getAllUsers();   
        } catch (Exception e) 
        {
            return null;
        }

        
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value="id") String id)
    {
        try 
        {
            return userService.getUserById(id);  
        } catch (Exception e) 
        {
            return null;
        }
    }


    //UPDATE


    @PostMapping("/update/{id}")
    public User postMethodName(@PathVariable(value="id") String id, @RequestParam String name, @RequestParam String email, @RequestParam String country) 
    {
        try 
        {
            return userService.updateUser(id, name, email, country);   
        } catch (Exception e) 
        {
            return null;
        }

    }
    
    
    //DELETE

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable(value="id") String id)
    {
        try 
        {
            return userService.deleteUserById(id);    
        } catch (Exception e) 
        {
            return null;
        }

        
    }

    @PostMapping("/delete/all")
    public String postMethodName() 
    {
        try 
        {
            return userService.deleteAll();   
        } catch (Exception e) 
        {
            return null;
        }
        
        
    }
    

}
