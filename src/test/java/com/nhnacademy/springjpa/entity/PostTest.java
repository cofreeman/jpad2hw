package com.nhnacademy.springjpa.entity;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
class PostTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void insertAndSelectPost() {

        Post p1 = Post.createPostBuilder()
                .postTitle("글 제목")
                .postContent("글 내용")
                .build();

        entityManager.persist(p1);
        entityManager.flush();

        Post p2 = entityManager.find(Post.class, p1.getPostNo());
        Assertions.assertThat(p1).isEqualTo(p2);
    }

}