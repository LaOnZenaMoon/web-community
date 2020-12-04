package me.lozm.object.vo.board;

import lombok.Builder;
import lombok.Getter;
import me.lozm.object.dto.board.CommentDeleteDto;
import me.lozm.object.dto.board.CommentPostDto;
import me.lozm.object.dto.board.CommentPutDto;
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

    public static CommentVo of(CommentPostDto.Request reqDto) {
        return CommentVo.builder()
                .boardId(reqDto.getBoardId())
                .commentType(reqDto.getCommentType())
                .content(reqDto.getContent())
                .createdBy(reqDto.getCreatedBy())
                .build();
    }

    public static CommentVo of(CommentPutDto.Request reqDto) {
        return CommentVo.builder()
                .id(reqDto.getId())
                .commentType(reqDto.getCommentType())
                .content(reqDto.getContent())
                .modifiedBy(reqDto.getModifiedBy())
                .build();
    }

    public static CommentVo of(CommentDeleteDto.Request reqDto, CommentDeleteDto targetDto) {
        return CommentVo.builder()
                .id(targetDto.getId())
                .modifiedBy(reqDto.getModifiedBy())
                .build();
    }

}
