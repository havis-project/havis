package com.havis.object.comment.model.entity;

import com.havis.object.member.model.entity.MemberEntity;
import com.havis.object.post.model.entity.PostEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_comment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@ToString
@Builder
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_no", nullable = false)
    @Comment("댓글번호")
    private int commentNo;

    @Column(name = "comment_text", nullable = false)
    @Comment("댓글내용")
    private String commentText;

    @Column(name = "comment_date", nullable = false)
    @CreatedDate
    @Comment("댓글작성일시")
    private LocalDateTime commentDate;

    @Column(name = "comment_banned_date")
    @Comment("댓글정지일시")
    private LocalDateTime commentBannedDate;

    @Column(name = "comment_ban_end_date")
    @Comment("댓글정지해제일시")
    private LocalDateTime commentBanEndDate;

    @ManyToOne
    @JoinColumn(name = "member_no")
    @Comment("댓글작성자")
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "post_no")
    @Comment("댓글작성게시글")
    private PostEntity post;
}
