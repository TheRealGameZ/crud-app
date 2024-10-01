package com.example.crud_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

import com.example.crud_app.UserRepository;
import com.example.crud_app.models.User;

import jakarta.persistence.NoResultException;

@Service
public class UserRepositoryService 
{

    @Autowired
    private UserRepository userRepository;

    //Handle Save

    public User saveUser(String name, String email, String country) throws Exception
    {
        User user = new User();
        
        try 
        {
            
            user.setName(name);
            user.setEmail(email);
            user.setCountry(country);

            return userRepository.save(user);


        } catch (Exception e) 
        {
            throw new Exception("Error: " + e.getMessage());
        } 

    }

    //Handle Delete

    public String deleteUserById(String id)
    {
        try 
        {
            userRepository.deleteById(id);
            return "User Deleted";
        } catch (Exception e) 
        {
            return "Error: " + e.getMessage();
        }
    }

    public String deleteAll()
    {
        try 
        {
            userRepository.deleteAll();
            return "All Users Deleted";
        } catch (Exception e) 
        {
            return "Error: " + e.getMessage();
        }
    }

    public String deleteUsersByIds(Set<String> ids)
    {
        try 
        {
            
            userRepository.deleteAllById(ids);
            
            return "Users Deleted";
        } catch (Exception e) 
        {
            return "Error: " + e.getMessage();
        }
    }
    
    //Handle Update

    public User updateUser(String id, String name, String email, String country) throws Exception
    {
        try 
        {
            User user = userRepository.findById(id).get();
            user.setName(name);
            user.setEmail(email);
            user.setCountry(country);

            return userRepository.save(user);
        } catch (Exception e) 
        {
            throw new Exception("Error: " + e.getMessage());

        }
    }

    //Handle Get

    public User getUserById(String id) throws NoResultException
    {
        try 
        {
            return userRepository.findById(id).get();
        } catch (NoResultException e) 
        {
            throw new NoResultException(e.getMessage());
        }
    }

    public Iterable<User> getAllUsers() throws Exception
    {
        try 
        {
        
            return userRepository.findAll();
            
        } catch (Exception e) 
        {
            throw new Exception("Error: " + e.getMessage());
        }
        
        
    }
    
}
