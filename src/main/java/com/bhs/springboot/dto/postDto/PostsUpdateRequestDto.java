package com.bhs.springboot.dto.postDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;

    @Builder
    public PostsUpdateRequestDto(String title) {
        this.title = title;
    }
}