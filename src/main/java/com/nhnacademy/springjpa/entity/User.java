package com.nhnacademy.springjpa.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "user_no")
    private int userNo;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "user_nickname")
    private String userNickname;

    @ManyToOne
    @JoinColumn(name = "user_type_code")
    private UserType userType;


    @OneToMany(mappedBy = "user")
    private List<Post> posts;
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    public User(String userId, String userPassword, String userNickname, UserType userType) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userNickname = userNickname;
        this.userType = userType;
    }

//    @Builder(builderMethodName = "createUserBuilder")
//    public static User createUser(String userId,String userPassword,String userNickname){
//        return new User(userId,userPassword,userNickname,new UserType());
//    }

    //    CREATE TABLE user (
//            user_no	int	AUTO_INCREMENT PRIMARY KEY,
//            user_id	varchar(20)	NOT NULL,
//    user_password varchar(20) NOT NULL,
//    user_nickname varchar(20) NOT NULL,
//    user_type_code int NOT NULL,
//    FOREIGN KEY (user_type_code) REFERENCES user_type (user_type_code)
//            );
}
