package com.springboot_to_aws.domain.posts;

import com.springboot_to_aws.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter  // 선언된 모든 필드의 Get 메소드를 생성
@NoArgsConstructor  //기본생성자 자동 추가
@Entity //테이블과 링크될 클래스임을 나타냄
public class Posts extends BaseTimeEntity {
    @Id // 해당 테이블의 PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성규칙
    private  Long id;

    @Column(length = 500, nullable = false)
    // 테이블의 칼럼을 나타내며 굳이 선언하지않아도 해당 클래스의 필드는 모두 칼럼이된다.
    // 기본값 이외의 추가로 변경이 필요한 옵션이 있으면 사용.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스를 생성
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
