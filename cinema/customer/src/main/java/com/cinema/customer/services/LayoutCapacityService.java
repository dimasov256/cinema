package com.cinema.customer.services;


import com.cinema.customer.repositories.LayoutCapacityRepository;
import com.cinema.customer.web.mappers.LayoutCapacityMapper;
import com.cinema.clients.customer.model.LayoutCapacityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LayoutCapacityService {

    private final LayoutCapacityRepository layoutCapacityRepository;
    private final LayoutCapacityMapper layoutCapacityMapper;

    public List<LayoutCapacityDto> getAllLayouts() {
        return layoutCapacityRepository.findAll().stream()
                .map(layoutCapacityMapper::layoutCapacityToLayoutCapacityDto)
                .collect(Collectors.toList());
    }
}
