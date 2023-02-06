package com.cinema.customer.web.controller;


import com.cinema.clients.customer.model.UserDto;
import com.cinema.customer.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Long userId) {
        return new ResponseEntity(userService.getUserById(userId), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("userId") Long userId, @RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.updateUser(userId, userDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

//    @GetMapping("/users/resetPassword/{userId}")
//    public void resetPassword(@PathVariable("userId") Long userId) {
//        userService.resetUserPassword(userId);
//    }

//    @GetMapping("/users/currentUserRole")
//    public Map<String, String> getCurrentUSerRole() {
//        Collection<GrantedAuthority> roles = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
//        String role = "";
//        if (roles.size() > 0) {
//            GrantedAuthority ga = roles.iterator().next();
//            role = ga.getAuthority().substring(5);
//        }
//
//        Map<String, String> results = new HashMap<>();
//        results.put("role", role);
//        return results;
//    }
//
//    @GetMapping("/logout")
//    public String logout(HttpServletResponse response) {
//
//        Cookie cookie = new Cookie("token", null);
//        cookie.setPath("/api");
//        cookie.setHttpOnly(true);
//        //TODO: When in production must do cookie.setSecure(true);
//        cookie.setMaxAge(0);
//        response.addCookie(cookie);
//        SecurityContextHolder.getContext().setAuthentication(null);
//        return "";
//    }

}
