package com.cinema.customer.services.pagenation;

import com.cinema.clients.customer.model.UserDto;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class UserPageList extends PageImpl<UserDto> {
    public UserPageList(List<UserDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public UserPageList(List<UserDto> content) {
        super(content);
    }
}
