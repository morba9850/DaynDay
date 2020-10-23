package com.bhs.springboot.dto.postDto;


import com.bhs.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String name;


    //데이터베이스에 데이터 넣기
    @Builder
    public PostsSaveRequestDto(String title, String name) {
        this.title = title;
        this.name = name;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .name(name)
                .build();
    }

}
