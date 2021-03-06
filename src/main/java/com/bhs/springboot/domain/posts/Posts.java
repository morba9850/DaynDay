package com.bhs.springboot.domain.posts;


import com.bhs.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;


    @Column(nullable = false)
    private String name;

    @Builder
    public Posts(String title, String name) {
        this.title = title;
        this.name = name;
    }


    public void update(String title) {
        this.title = title;
    }
}
