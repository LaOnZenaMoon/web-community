package me.lozm.object.vo.board;

import lombok.Builder;
import lombok.Getter;
import me.lozm.object.dto.board.DeleteCommentDto;
import me.lozm.object.dto.board.PostBoardDto;
import me.lozm.object.dto.board.PostCommentDto;
import me.lozm.object.dto.board.PutCommentDto;
import me.lozm.object.vo.BaseVo;

import java.time.LocalDateTime;

@Getter
public class CommentVo extends BaseVo {

    private Long id;
    private String commentType;
    private String content;

    private Long boardId;


    @Builder
    public CommentVo(LocalDateTime createdDt, LocalDateTime modifiedDt, Long createdBy, Long modifiedBy, int flag, Long id, String commentType, String content, Long boardId) {
        super(createdDt, modifiedDt, createdBy, modifiedBy, flag);
        this.id = id;
        this.commentType = commentType;
        this.content = content;
        this.boardId = boardId;
    }

    public static CommentVo of(PostCommentDto.Request reqDto) {
        return CommentVo.builder()
                .boardId(reqDto.getBoardId())
                .commentType(reqDto.getCommentType())
                .content(reqDto.getContent())
                .createdBy(reqDto.getCreatedBy())
                .build();
    }

    public static CommentVo of(PutCommentDto.Request reqDto) {
        return CommentVo.builder()
                .id(reqDto.getId())
                .commentType(reqDto.getCommentType())
                .content(reqDto.getContent())
                .modifiedBy(reqDto.getModifiedBy())
                .build();
    }

    public static CommentVo of(DeleteCommentDto.Request reqDto, DeleteCommentDto targetDto) {
        return CommentVo.builder()
                .id(targetDto.getId())
                .modifiedBy(reqDto.getModifiedBy())
                .build();
    }

}
