package me.lozm.data;

import com.github.javafaker.Faker;
import me.lozm.object.code.BoardType;
import me.lozm.object.code.ContentType;
import me.lozm.object.dto.board.BoardPostDto;
import me.lozm.object.dto.board.BoardPutDto;

import java.util.concurrent.ThreadLocalRandom;

public class BoardTestDto {

    private static Faker faker = new Faker();


    public static BoardPostDto.Request makeTestBoardPostDto(Long userId) {
        Faker faker = new Faker();
        BoardPostDto.Request reqDto = BoardPostDto.Request.builder()
                .boardType(getRandomBoardType())
                .contentType(getRandomContentType())
                .title(faker.book().title())
                .content(faker.lorem().sentences(ThreadLocalRandom.current().nextInt(0, 10)).toString())
                .build();

        return reqDto;
    }

    public static BoardPutDto.Request makeTestBoardPutDto(Long boardId) {
        BoardPutDto.Request reqDto = BoardPutDto.Request.builder()
                .id(boardId)
                .boardType(getRandomBoardType())
                .contentType(getRandomContentType())
                .title(faker.book().title())
                .content(faker.lorem().sentences(ThreadLocalRandom.current().nextInt(0, 10)).toString())
                .build();

        return reqDto;
    }

    private static String getRandomBoardType() {
        BoardType[] boardTypeArr = BoardType.values();
        String boardType = boardTypeArr[ThreadLocalRandom.current().nextInt(1, boardTypeArr.length - 1)].toString();
        return boardType;
    }

    private static String getRandomContentType() {
        ContentType[] contentTypeArr = ContentType.values();
        String contentType = contentTypeArr[ThreadLocalRandom.current().nextInt(0, contentTypeArr.length - 1)].toString();
        return contentType;
    }

}
