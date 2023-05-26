package com.cinema.customer.web.controller;

import javax.servlet.http.Cookie;

import com.cinema.clients.customer.model.UserDto;
import com.cinema.customer.domain.User;
import com.cinema.customer.domain.http.HttpResponse;
import com.cinema.customer.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/usersPage")
    public ResponseEntity<HttpResponse> getAllUsersPageable(@RequestParam Optional<String> name,
                                                            @RequestParam Optional<Integer> page,
                                                            @RequestParam Optional<Integer> size) throws InterruptedException {

        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .data(of("page", userService.getAllUsersPageable(name.orElse(""), page.orElse(0), size.orElse(10))))
                        .message("Users Retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }

    @GetMapping("/users/{name}/{email}")
    public ResponseEntity<List<UserDto>> getAllUsersByNameOrByEmail(@PathVariable("name") String name,
                                                                    @PathVariable("email") String email) {
        return new ResponseEntity<>(userService.getAllUsersByNameOrEmail(name, email), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        System.out.println("All users: " + userService.getAllUsers().stream().toList());
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Long userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
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

    @GetMapping("/users/resetPassword/{userId}")
    public void resetPassword(@PathVariable("userId") Long userId) {
        userService.resetUserPassword(userId);
    }

    @GetMapping("/users/currentUserRole")
    public Map<String, String> getCurrentUSerRole() {
        Collection<GrantedAuthority> roles =
                (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        String role = "";
        if (roles.size() > 0) {
            GrantedAuthority ga = roles.iterator().next();
            role = ga.getAuthority().substring(5);
        }

        Map<String, String> results = new HashMap<>();
        results.put("role", role);
        System.out.println("This is role: " + role);
        return results;
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse response) {

        Cookie cookie = new Cookie("token", null);
        cookie.setPath("/api");
        cookie.setHttpOnly(true);
        //TODO: When in production must do cookie.setSecure(true);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        SecurityContextHolder.getContext().setAuthentication(null);
        System.out.println("Loguot: ");

        return "";
    }

    @PostMapping("/upload/{userId}")
    public ResponseEntity<User> uploadImage(@RequestParam("imageFile") MultipartFile file, @PathVariable("userId") Long userId) throws IOException {

        return new ResponseEntity(userService.uploadImage(userId, file), HttpStatus.OK);
    }


}
