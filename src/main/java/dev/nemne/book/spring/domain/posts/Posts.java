package dev.nemne.book.spring.domain.posts;

import dev.nemne.book.spring.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity // 주요 어노테이션 부터 우선 정렬
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성 규칙, GenerationType.IDENTITY 옵션을 추가해야지 auto-increment
    private Long id;    //웬만하면 Long타입 할것

    @Column(length = 500, nullable = false) // String은 VARCHAR(255)가 기본값
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    // @Column을 선언하지 않아도 알아서 인식
    private String author;

    @Builder // 빌드 패턴 사용 -> 개발자가 어느 필드에 어떤 값을 채워야할지 명확해짐
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
