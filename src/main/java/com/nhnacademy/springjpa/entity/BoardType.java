package com.nhnacademy.springjpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "board_type")
public class BoardType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_type_code")
    private int boardTypeCode;
    @Column(name = "board_code_value")
    private String boardCodeValue;

    @OneToMany(mappedBy = "boardType")
    private List<Post> posts;


}
//board_type_code	int	AUTO_INCREMENT PRIMARY KEY,
//        board_code_value varchar(20) NOT NULL