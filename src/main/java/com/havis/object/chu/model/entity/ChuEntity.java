package com.havis.object.chu.model.entity;

import com.havis.common.basetime.entity.BaseTimeEntity;
import com.havis.object.comment.model.entity.CommentEntity;
import com.havis.object.member.model.entity.MemberEntity;
import com.havis.object.post.model.entity.PostEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_chu")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@ToString
@Builder
public class ChuEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chu_no", nullable = false)
    @Comment("츄천번호")
    private int chuNo;

    @Column(name = "chu_date")
    @CreatedDate
    @Comment("츄천일시")
    private LocalDateTime chuDate;

    @ManyToOne
    @JoinColumn(name = "member_no")
    @Comment("츄천회원")
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "post_no")
    @Comment("츄천게시글")
    private PostEntity post;

    @ManyToOne
    @JoinColumn(name = "comment_no")
    @Comment("츄천댓글")
    private CommentEntity comment;
}
