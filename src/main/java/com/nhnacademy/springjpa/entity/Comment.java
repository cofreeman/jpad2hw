package com.nhnacademy.springjpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_no")
    private int commentNo;
    @Column(name = "comment_content")
    private String commentContent;

    @ManyToOne
    @JoinColumn(name = "post_no")
    private Post post;
    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user;

}
//	comment_no int AUTO_INCREMENT PRIMARY KEY,
//            comment_content varchar(300) NOT NULL,
//            post_no int NOT NULL,
//            user_no int NOT NULL,
//            FOREIGN KEY (post_no) REFERENCES post (post_no),
//            FOREIGN KEY (user_no) REFERENCES user (user_no)
