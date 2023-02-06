package com.cinema.customer.web.controller;

import com.cinema.customer.services.LayoutCapacityService;
import com.cinema.clients.customer.model.LayoutCapacityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class LayoutCapacityController {

    private final LayoutCapacityService layoutCapacityService;

    @GetMapping("/layouts")
    public ResponseEntity<List<LayoutCapacityDto>> getAllLayouts() {
        return new ResponseEntity<>(layoutCapacityService.getAllLayouts(), HttpStatus.OK);
    }

}
