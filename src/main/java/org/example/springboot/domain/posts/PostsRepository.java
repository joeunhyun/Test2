package org.example.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//Repository : DAO 개념이라고 생각 JpaRepository<Entity 클래스, PK타입>
public interface PostsRepository  extends JpaRepository<Posts,Long> {

}
