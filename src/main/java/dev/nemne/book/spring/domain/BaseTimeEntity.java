package dev.nemne.book.spring.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/*

JPA Auditing이란

여러 엔티티들이 동일한 컬럼을 사용한다면? (생성날짜, 수정날짜 등)
이렇게 자동화한게 JPA Auditing

 */

@Getter
@MappedSuperclass // 해당 클래스를 상속 받을 경우 아래 속성들도 인식한다.
@EntityListeners(AuditingEntityListener.class) // 엔티티를 DB에 적용하기 전, 이후에 커스텀 콜백을 요청할 수 있는 어노테이션
public abstract class BaseTimeEntity {

    @CreatedDate //생성되어 저장될 때 자동으로 저장한다.
    private LocalDateTime createdDate;

    @LastModifiedDate //변경될 때 자동으로 저장한다.
    private LocalDateTime modifiedDate;
}
