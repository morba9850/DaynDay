package com.bhs.springboot.dto;

import com.bhs.springboot.domain.Gallery.GalleryEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class GalleryDto {
    private String title;
    private String filePath;
    private String name;


    public GalleryEntity toEntity(){
        GalleryEntity build = GalleryEntity.builder()
                .title(title)
                .filePath(filePath)
                .name(name)
                .build();
        return build;
    }

    @Builder
    public GalleryDto(String title, String filePath, String name) {
        this.title = title;
        this.filePath = filePath;
        this.name = name;
    }
}