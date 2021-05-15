package org.example.springboot.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        String title = "테스트게시글";
        String content = "테스트 본문";

        // 테이블 posts에 insert,update 쿼리실행 , PK 값이 있다면 update 없으면 insert
        postsRepository.save(Posts.builder()
                        .title(title)
                        .content(content)
                        .author("jojoldu@gmail.com")
                        .build());

        List<Posts> postsList = postsRepository.findAll(); //테이블 조회

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

        /** result
         * Hibernate: drop table if exists posts CASCADE
         * Hibernate: create table posts (id bigint generated by default as identity, author varchar(255),
         * content TEXT not null, title varchar(500) not null, primary key (id))
         * insert into posts (id, author, content, title) values (null, ?, ?, ?)
         * select posts0_.id as id1_0_, posts0_.author as author2_0_, posts0_.content as content3_0_, posts0_.title as title4_0_ from posts posts0_
         * select posts0_.id as id1_0_, posts0_.author as author2_0_, posts0_.content as content3_0_, posts0_.title as title4_0_ from posts posts0_
         * delete from posts where id=?
         */

        /**
         * bigint generated by default as identity : H2 의 쿼리 문법 적용
         */

    }

    @Test
    public void BastTimeEntity_등록(){
        LocalDateTime now = LocalDateTime.of(2020,7,12,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>>>> crateDate"+posts.getCreatedDate()+", modifiedDate="+posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);

    }
}
