package me.lozm.object.dto.board;

import lombok.*;
import me.lozm.entity.board.Comment;
import me.lozm.object.code.CommentType;
import org.springframework.data.domain.Page;

@Getter @Builder
@NoArgsConstructor @AllArgsConstructor
public class CommentGetDto {

    private Long id;
    private CommentType commentType;
    private int flag;
    private String content;


    public static CommentGetDto of(Comment comment) {
        return CommentGetDto.builder()
                .id(comment.getId())
                .commentType(comment.getCommentType())
                .content(comment.getContent())
                .flag(comment.getFlag())
                .build();
    }


    @Getter
    public static class Response {
        Page<CommentGetDto> list;

        public void setList(Page<Comment> commentList) {
            this.list = commentList.map((entity) -> CommentGetDto.of(entity));
        }
    }

}
