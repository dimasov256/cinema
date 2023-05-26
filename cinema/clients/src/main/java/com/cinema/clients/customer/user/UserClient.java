package com.cinema.clients.customer.user;

import com.cinema.clients.customer.model.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user", url = "localhost:8080/api/v1/")
public interface UserClient {
    @GetMapping("users/{userId}")
    UserDto getUserById(@PathVariable("userId") Long userId);

    @PostMapping("users")
    UserDto createUser(@RequestBody UserDto userDto);

    @PutMapping("users/{userId}")
    UserDto updateUser(@PathVariable("userId") Long userId, @RequestBody UserDto userDto);
}
