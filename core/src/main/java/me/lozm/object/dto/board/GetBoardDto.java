package me.lozm.object.dto.board;

import lombok.*;
import me.lozm.entity.board.Board;
import me.lozm.entity.board.Comment;
import me.lozm.object.code.BoardType;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Builder
@NoArgsConstructor @AllArgsConstructor
public class GetBoardDto {

    private Long id;
    private String boardType;
    private String contentType;
    private String title;
    private String content;
    private List<Comment> comments;


    public static GetBoardDto of(Board board) {
        return GetBoardDto.builder()
                .id(board.getId())
                .boardType(board.getBoardType())
                .contentType(board.getContentType())
                .title(board.getTitle())
                .content(board.getContent())
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
        Page<GetBoardDto> list;

        public void setList(Page<Board> boardList) {
            this.list = boardList.map((entity) -> GetBoardDto.of(entity));
        }
    }

}
