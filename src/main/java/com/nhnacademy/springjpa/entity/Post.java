package com.nhnacademy.springjpa.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "post")
public class Post {
	/*
	enum BOARD_TYPE{
		BOARD_TYPE_ADMIN,
		BOARD_TYPE_MEMEBER
	}

	@Enumerated(value = EnumType.STRING)
	private BOARD_TYPE boardType;
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_no", nullable = false)
	private int postNo;
	@Column(name = "post_title", nullable = false)
	private String postTitle;
	@Column(name = "post_content", nullable = false)
	private String postContent;
	@Column(name = "write_datetime", nullable = false)
	private LocalDateTime writeDatetime;
	@Column(name = "reply_order", nullable = false)
	private int replyOrder;
	@Column(name = "modify_datetime", nullable = true)
	private LocalDateTime modifyDatetime;
	@Column(name = "user_no", nullable = false)
	private int userNo;
	@Column(name = "parent_post_no")
	private Integer parentPostNo;
	@Column(name = "top_post_no")
	private Integer topPostNo;
	@Column(name = "board_type_code", nullable = false)
	private int boardTypeCode;

	@Column(name = "modifier_user_no", nullable = true)
	private Integer modifierUserNo;
	@Column(name = "is_delete", nullable = false)
	private Boolean isDelete;

	@ManyToOne
	@JoinColumn(name="user_no",insertable = false,updatable = false)
	private User user;
	@ManyToOne
	@JoinColumn(name = "board_type_code",insertable = false,updatable = false)
	private BoardType boardType;
	@ManyToOne
	@JoinColumn(name = "parent_post_no",insertable = false, updatable = false)
	private Post parentPost;
	@ManyToOne
	@JoinColumn(name = "top_post_no",insertable = false, updatable = false)
	private Post topPost;

	@OneToMany(mappedBy = "post")
	private List<File> files;
	@OneToMany(mappedBy = "post")
	private List<Comment> comments;
	@OneToMany(mappedBy = "parentPost")
	private List<Post> posts1;
	@OneToMany(mappedBy = "topPost")
	private List<Post> posts2;


	private Post( String postTitle, String postContent, LocalDateTime writeDatetime, int replyOrder, LocalDateTime modifyDatetime, int userNo, int boardTypeCode, Integer parentPostNo, Integer topPostNo, Integer modifierUserNo, Boolean isDelete) {
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.writeDatetime = writeDatetime;
		this.replyOrder = replyOrder;
		this.modifyDatetime = modifyDatetime;
		this.userNo = userNo;
		this.boardTypeCode = boardTypeCode;
		this.parentPostNo = parentPostNo;
		this.topPostNo = topPostNo;
		this.modifierUserNo = modifierUserNo;
		this.isDelete = isDelete;
	}

	@Builder(builderMethodName = "createPostBuilder")
	public static Post createPost(String postTitle, String postContent){
		return new Post(postTitle,postContent,LocalDateTime.now(),1,null,1,1,null,null,null,false);
	}

}
//	post_no	int	AUTO_INCREMENT PRIMARY KEY,
//			post_title	varchar(255) NOT NULL,
//			post_content	varchar(3000) NOT NULL,
//			write_datetime	datetime NOT NULL,
//			reply_order	int	NOT NULL,
//			modify_datetime	datetime NULL,
//			user_no	int	NOT NULL,
//			board_type_code	int	NOT NULL,
//			parent_post_no	int NULL,
//			top_post_no	int NULL,
//			modifier_user_no int NULL,
//			is_delete boolean NOT NULL,

//			FOREIGN KEY (user_no) REFERENCES user (user_no),
//			FOREIGN KEY (board_type_code) REFERENCES board_type (board_type_code),
//			FOREIGN KEY (parent_post_no) REFERENCES post (post_no),
//			FOREIGN KEY (top_post_no) REFERENCES post (post_no),
//			FOREIGN KEY (modifier_user_no) REFERENCES user (user_no)