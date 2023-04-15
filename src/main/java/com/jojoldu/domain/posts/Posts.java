package com.jojoldu.domain.posts;


import com.jojoldu.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 롬복어노테이션 (Getter 메소드 자동생성)
@NoArgsConstructor // 롬복어노테이션(기본생성자 자동추가)
@Entity // JPA의 어노테이션 (테이블과 링크될 클래스임을 나타냄, 카멜케이스로 된 클래스 이름을 언더스코어 네이밍으로 테이블과 매칭)

public class Posts extends BaseTimeEntity {
    @Id //PK필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment설정
    private Long id;

    @Column(length=500, nullable = false) // 테이블컬럼을 나타냄, 기본값 외 추가 옵션이 필요한 경우만 사용함
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
