package com.nhnacademy.springjpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "file")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_no")
    private int fileNo;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "file_path")
    private String filePath;

    @ManyToOne
    @JoinColumn(name="post_no")
    private Post post;

}
//	file_no	int	NOT NULL auto_increment primary key,
//            file_name	varchar(300)	NOT NULL,
//            file_path	varchar(300)	NOT NULL,
//            post_no	int	NOT NULL