package dev.nemne.book.spring.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;


// Entity 파일과 같은 위치에 있어야한다.
public interface PostsRepository extends JpaRepository<Posts, Long> { // extends JpaRepository<Entity 클래스, PK 타입>
}
