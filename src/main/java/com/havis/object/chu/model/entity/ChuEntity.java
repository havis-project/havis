package com.havis.object.chu.model.entity;

import com.havis.object.comment.model.entity.CommentEntity;
import com.havis.object.member.model.entity.MemberEntity;
import com.havis.object.post.model.entity.PostEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_chu")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ChuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chu_no", nullable = false)
    private int chuNo;

    @Column(name = "chu_date")
    private LocalDateTime chuDate;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "post_no")
    private PostEntity post;

    @ManyToOne
    @JoinColumn(name = "comment_no")
    private CommentEntity comment;
}
