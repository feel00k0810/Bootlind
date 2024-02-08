package com.sparta.bootlind.entity;

import com.sparta.bootlind.dto.requestDto.PostRequest;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "posts")
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Post extends TimeStamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String category;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String postLikes;

    @Column
    private Integer likescnt;

    public Post(PostRequest postRequest, User user){
        this.title = postRequest.getTitle();
        this.content = postRequest.getContent();
        this.category = postRequest.getCategory();
        this.user = user;
        this.postLikes = "";
    }

    public void update(PostRequest postRequest) {
        this.title = postRequest.getTitle();
        this.content = postRequest.getContent();
        this.category = postRequest.getCategory();
    }
}
