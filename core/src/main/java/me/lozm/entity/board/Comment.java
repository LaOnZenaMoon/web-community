package me.lozm.entity.board;

import lombok.*;
import me.lozm.entity.BaseEntity;
import me.lozm.object.vo.board.CommentVo;

import javax.persistence.*;

@Entity
@Table(schema = "LOZM", name = "COMMENTS")
@Getter @Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "COMMENT_ID")
    private Long id;

    @Column(name = "COMMENT_TYPE")
    private String commentType;

    @Column(name = "CONTENT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_ID")
    private Board board;


    public void insertComment(CommentVo commentVo, Board board) {
        this.commentType = commentVo.getCommentType();
        this.content = commentVo.getContent();
        this.board = board;
        this.setBaseEntity(commentVo.getCreatedBy(), null, 1);
    }

    public void updateComment(CommentVo commentVo) {
        this.commentType = commentVo.getCommentType();
        this.content = commentVo.getContent();
        this.setBaseEntity(null, commentVo.getModifiedBy(), 1);
    }

    public void deleteComment(CommentVo commentVo) {
        this.setBaseEntity(null, commentVo.getModifiedBy(), 0);
    }

}
