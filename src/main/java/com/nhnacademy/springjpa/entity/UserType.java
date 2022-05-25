package com.nhnacademy.springjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="user_type")
public class UserType {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_type_code")
    private int userTypeCode;
    @Column(name="user_type_value")
    private String userTypeValue;

    @OneToMany(mappedBy = "userType")
    private List<User> users;


//    user_type_code int AUTO_INCREMENT PRIMARY KEY,
//    user_type_value	varchar(20)	NOT NULL
}
