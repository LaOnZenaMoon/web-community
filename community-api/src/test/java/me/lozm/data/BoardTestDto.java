package me.lozm.data;

import com.github.javafaker.Faker;
import me.lozm.object.code.BoardType;
import me.lozm.object.code.ContentType;
import me.lozm.object.dto.board.BoardPostDto;
import me.lozm.object.dto.board.BoardPutDto;
import me.lozm.object.dto.board.CommentPostDto;

import java.util.concurrent.ThreadLocalRandom;

public class BoardTestDto {

    private static Faker faker = new Faker();


    public static BoardPostDto.Request makeTestBoardPostDto() {
        return BoardPostDto.Request.builder()
                .boardType(getRandomBoardType())
                .contentType(getRandomContentType())
                .title(faker.book().title())
                .content(faker.lorem().sentences(ThreadLocalRandom.current().nextInt(0, 10)).toString())
                .build();
    }

    public static BoardPutDto.Request makeTestBoardPutDto(Long boardId) {
        return BoardPutDto.Request.builder()
                .id(boardId)
                .boardType(getRandomBoardType())
                .contentType(getRandomContentType())
                .title(faker.book().title())
                .content(faker.lorem().sentences(ThreadLocalRandom.current().nextInt(0, 10)).toString())
                .build();
    }

    public static CommentPostDto.Request makeTestCommentPostDto(Long boardId) {
        return CommentPostDto.Request.builder()
                .boardId(boardId)
                .commentType(getRandomContentType())
                .content(getRandomContent())
                .build();
    }

    private static String getRandomContent() {
        return faker.lorem().sentences(ThreadLocalRandom.current().nextInt(0, 100)).toString();
    }


    public static String getRandomBoardType() {
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
