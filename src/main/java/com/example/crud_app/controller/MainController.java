package com.example.crud_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController 
{
    @GetMapping("/")
    public String getApiInfo() {
        return "<html>" +
               "<head><title>CRUD-API</title></head>" +
               "<body>" +
               "<h1>API Information</h1>" +
               "<p>Welcome to the CRUD API. Here are the available endpoints:</p>" +
               "<ul>" +
               "<h3>/api-info</h3>" +
               "<h3>/user</h3>" +
               "<li><h4>GET</h4> /all- Get all users</li>" +
                "<li><h4>GET</h4> /{id}- Get user by id</li>" +
                "<li><h4>POST</h4> /add- Add a new user</li>" +
                "<li><h4>POST</h4> /update/{id}- Update user by id</li>" +
                "<li><h4>DELETE</h4> /delete/{id}- Delete user by id</li>" +
                "<li><h4>DELETE</h4> /delete/all- Delete all users</li>" +
               "</ul>" +
               "</body>" +
               "</html>";
    }

}
