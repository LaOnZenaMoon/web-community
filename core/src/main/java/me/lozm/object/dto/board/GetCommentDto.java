package me.lozm.object.dto.board;

import lombok.*;
import me.lozm.entity.board.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCommentDto {

    private Long id;
    private String commentType;
    private int flag;
    private String content;

    @Getter
    public static class Response {
        List<GetCommentDto> list = new ArrayList<>();

        public void setList(List<Comment> commentList) {
            this.list = commentList.stream()
                    .map(comment -> GetCommentDto.builder()
                            .id(comment.getId())
                            .commentType(comment.getCommentType())
                            .flag(comment.getFlag())
                            .content(comment.getContent())
                            .build())
                    .collect(Collectors.toList());
        }
    }

}
