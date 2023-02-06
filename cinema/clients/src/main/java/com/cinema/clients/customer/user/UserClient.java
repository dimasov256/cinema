package com.cinema.clients.customer.user;

import com.cinema.clients.customer.model.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user", url = "localhost:8080/api/v1/")
public interface UserClient {
    @GetMapping("users/{userId}")
    UserDto getUserById(@PathVariable("userId") Long userId);

    @PostMapping("api/v1/users")
    UserDto createUser(@RequestBody UserDto userDto);
}
