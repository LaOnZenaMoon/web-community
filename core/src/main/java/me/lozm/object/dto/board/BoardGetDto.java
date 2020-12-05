package me.lozm.object.dto.board;

import lombok.*;
import me.lozm.entity.board.Board;
import me.lozm.object.code.BoardType;
import me.lozm.object.code.ContentType;
import org.springframework.data.domain.Page;

@Getter @Builder
@NoArgsConstructor @AllArgsConstructor
public class BoardGetDto {

    private Long id;
    private BoardType boardType;
    private ContentType contentType;
    private String title;
    private String content;
    private int flag;


    public static BoardGetDto of(Board board) {
        return BoardGetDto.builder()
                .id(board.getId())
                .boardType(board.getBoardType())
                .contentType(board.getContentType())
                .title(board.getTitle())
                .content(board.getContent())
                .flag(board.getFlag())
                .build();
    }


    @Getter
    public static class Request {

        private BoardType boardType;


        public Request(BoardType boardType) {
            this.boardType = boardType;
        }

    }

    @Getter
    public static class Response {
        Page<BoardGetDto> list;

        public void setList(Page<Board> boardList) {
            this.list = boardList.map((entity) -> BoardGetDto.of(entity));
        }
    }

}
