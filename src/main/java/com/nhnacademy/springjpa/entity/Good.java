package com.nhnacademy.springjpa.entity;

import com.nhnacademy.springjpa.idClass.GoodId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "good")
@IdClass(GoodId.class)
public class Good {
    @Id
    @Column(name = "post_no")
    private int postNo;
    @Id
    @Column(name = "user_no")
    private int userNo;
    //todo:키가 두개임

    @MapsId
    @OneToOne
    @JoinColumn(name="user_no")
    private User user;

    @MapsId
    @OneToOne
    @JoinColumn(name="post_no")
    private Post post;
}
//	post_no	int	NOT NULL,
//            user_no	int	NOT NULL,
//            PRIMARY KEY (post_no, user_no),
//            FOREIGN KEY (post_no) REFERENCES post (post_no),
//            FOREIGN KEY (user_no) REFERENCES user (user_no)
