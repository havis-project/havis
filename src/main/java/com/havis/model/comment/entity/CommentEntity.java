package com.havis.model.comment.entity;

import com.havis.model.member.entity.MemberEntity;
import com.havis.model.post.entity.PostEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_comment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_no", nullable = false)
    private int commentNo;

    @Column(name = "comment_text", nullable = false)
    private String commentText;

    @Column(name = "comment_date", nullable = false)
    private LocalDateTime commentDate;

    @Column(name = "comment_banned_date")
    private LocalDateTime commentBannedDate;

    @Column(name = "comment_ban_end_date")
    private LocalDateTime commentBanEndDate;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "post_no")
    private PostEntity post;
}
