package me.lozm.object.dto.board;

import lombok.Getter;
import me.lozm.object.dto.BaseUserDto;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
public class BoardDeleteDto {
    @NotNull
    private Long id;

    @Getter
    public static class Request extends BaseUserDto {
        private List<BoardDeleteDto> list = new ArrayList<>();
    }

}
