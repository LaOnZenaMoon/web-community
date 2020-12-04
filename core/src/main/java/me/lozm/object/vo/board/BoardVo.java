package me.lozm.object.vo.board;

import lombok.Builder;
import lombok.Getter;
import me.lozm.object.dto.board.DeleteBoardDto;
import me.lozm.object.dto.board.PostBoardDto;
import me.lozm.object.dto.board.PutBoardDto;
import me.lozm.object.vo.BaseVo;

import java.time.LocalDateTime;

@Getter
public class BoardVo extends BaseVo {

    private Long id;
    private String boardType;
    private String contentType;
    private String title;
    private String content;


    @Builder
    public BoardVo(LocalDateTime createdDt, LocalDateTime modifiedDt, Long createdBy, Long modifiedBy, int flag, Long id, String boardType, String contentType, String title, String content) {
        super(createdDt, modifiedDt, createdBy, modifiedBy, flag);
        this.id = id;
        this.boardType = boardType;
        this.contentType = contentType;
        this.title = title;
        this.content = content;
    }


    public static BoardVo of(PostBoardDto.Request reqDto) {
        return BoardVo.builder()
                .boardType(reqDto.getBoardType())
                .contentType(reqDto.getContentType())
                .title(reqDto.getTitle())
                .content(reqDto.getContent())
                .createdBy(reqDto.getCreatedBy())
                .build();
    }

    public static BoardVo of(PutBoardDto.Request reqDto) {
        return BoardVo.builder()
                .id(reqDto.getId())
                .boardType(reqDto.getBoardType())
                .contentType(reqDto.getContentType())
                .title(reqDto.getTitle())
                .content(reqDto.getContent())
                .modifiedBy(reqDto.getModifiedBy())
                .build();
    }

    public static BoardVo of(DeleteBoardDto.Request reqDto, DeleteBoardDto targetDto) {
        return BoardVo.builder()
                .id(targetDto.getId())
                .modifiedBy(reqDto.getModifiedBy())
                .build();
    }

}