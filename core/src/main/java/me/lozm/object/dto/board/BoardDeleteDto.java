package me.lozm.object.dto.board;

import lombok.*;
import me.lozm.object.dto.BaseUserDto;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter @Builder
@NoArgsConstructor @AllArgsConstructor
public class BoardDeleteDto {

    @NotNull
    private Long id;


    @Getter @Setter
    public static class Request extends BaseUserDto {
        private List<BoardDeleteDto> list = new ArrayList<>();
    }

}
