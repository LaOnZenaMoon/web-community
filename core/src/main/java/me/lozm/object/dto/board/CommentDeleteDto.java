package me.lozm.object.dto.board;

import lombok.*;
import me.lozm.object.dto.BaseUserDto;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter @Builder
@NoArgsConstructor @AllArgsConstructor
public class CommentDeleteDto {
    @NotNull
    private Long id;

    @Getter @Setter
    public static class Request extends BaseUserDto {
        private List<CommentDeleteDto> list = new ArrayList<>();
    }

}
