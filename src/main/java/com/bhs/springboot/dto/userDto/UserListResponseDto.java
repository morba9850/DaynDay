package com.bhs.springboot.dto.userDto;

import com.bhs.springboot.domain.user.User;
import lombok.Getter;

@Getter
public class UserListResponseDto {
    private Long id;
    private String email;
    private String name;

    public UserListResponseDto(User entity) {
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.name = entity.getName();

    }
}
