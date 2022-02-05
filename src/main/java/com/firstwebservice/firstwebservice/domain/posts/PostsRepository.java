package com.firstwebservice.firstwebservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//Post 클래스로 DataBase 를 접근하게 해줄 JPARepository 생성
public interface PostsRepository extends JpaRepository<Posts,Long> {  //JpaRepository<Entity 클래스,PK 타입> 를 상속하면 기본적인 CRUD메서드 자동생성된다.

}
