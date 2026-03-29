package com.example.hospital_management.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO dto){
        try{
            userService.register(dto.getUserName(), dto.getPassword());

            return  ResponseEntity.status(HttpStatus.CREATED)
                    .body("User registered successfully");
        }
        catch(Exception e){
            return new ResponseEntity<>("invalid inputs", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO dto){
        try{
            return new ResponseEntity<>(userService.login(dto.getUserName(), dto.getPassword()), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("not authorized", HttpStatus.UNAUTHORIZED);
        }
    }


}
