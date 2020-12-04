package me.lozm.object.dto.board;

import lombok.*;
import me.lozm.entity.board.Comment;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Builder
@NoArgsConstructor @AllArgsConstructor
public class GetCommentDto {

    private Long id;
    private String commentType;
    private int flag;
    private String content;


    public static GetCommentDto of(Comment comment) {
        return GetCommentDto.builder()
                .id(comment.getId())
                .commentType(comment.getCommentType())
                .content(comment.getContent())
                .flag(comment.getFlag())
                .build();
    }


    @Getter
    public static class Response {
        Page<GetCommentDto> list;

        public void setList(Page<Comment> commentList) {
            this.list = commentList.map((entity) -> GetCommentDto.of(entity));
        }
    }

}
