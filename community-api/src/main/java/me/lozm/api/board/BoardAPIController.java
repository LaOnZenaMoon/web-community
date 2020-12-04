package me.lozm.api.board;

import lombok.RequiredArgsConstructor;
import me.lozm.object.code.BoardType;
import me.lozm.object.dto.ApiResponseCode;
import me.lozm.object.dto.ApiResponseDto;
import me.lozm.object.dto.board.*;
import me.lozm.object.vo.board.BoardVo;
import me.lozm.object.vo.board.CommentVo;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController @RequestMapping(value = "/api/board")
@RequiredArgsConstructor
public class BoardAPIController {

    private final BoardService boardService;


    @GetMapping("/boardType/{boardType}")
    public ApiResponseDto getBoardList(@PathVariable(value = "boardType") BoardType boardType, Pageable pageable) {
        GetBoardDto.Response resDto = new GetBoardDto.Response();
        resDto.setList(boardService.getBoardList(boardType, pageable));

        return ApiResponseDto.createException(ApiResponseCode.OK, resDto);
    }

    @GetMapping("/{boardId}")
    public ApiResponseDto getBoardDetail(@PathVariable(value = "boardId") Long boardId) {
        return ApiResponseDto.createException(ApiResponseCode.OK, GetBoardDto.of(boardService.getBoardDetail(boardId)));
    }

    @PostMapping
    public ApiResponseDto postBoard(@RequestBody @Valid PostBoardDto.Request reqDto) {
        boardService.save(BoardVo.of(reqDto));

        return ApiResponseDto.createException(ApiResponseCode.OK, null);
    }

    @PutMapping
    public ApiResponseDto putBoard(@RequestBody @Valid PutBoardDto.Request reqDto) {
        boardService.update(BoardVo.of(reqDto));

        return ApiResponseDto.createException(ApiResponseCode.OK, null);
    }

    @DeleteMapping
    public ApiResponseDto deleteBoard(@RequestBody @Valid DeleteBoardDto.Request reqDto) {
        for(DeleteBoardDto dto : reqDto.getList()) {
            boardService.delete(BoardVo.of(reqDto, dto));
        }

        return ApiResponseDto.createException(ApiResponseCode.OK, null);
    }

    @GetMapping("/{boardId}/comment")
    public ApiResponseDto getCommentList(@PathVariable(value = "boardId") Long boardId, Pageable pageable) {
        GetCommentDto.Response resDto = new GetCommentDto.Response();
        resDto.setList(boardService.getCommentList(boardId, pageable));

        return ApiResponseDto.createException(ApiResponseCode.OK, resDto);
    }

    @PostMapping("/comment")
    public ApiResponseDto postComment(@RequestBody @Valid PostCommentDto.Request reqDto) {
        boardService.save(CommentVo.of(reqDto));

        return ApiResponseDto.createException(ApiResponseCode.OK, null);
    }

    @PutMapping("/comment")
    public ApiResponseDto putComment(@RequestBody @Valid PutCommentDto.Request reqDto) {
        boardService.update(CommentVo.of(reqDto));

        return ApiResponseDto.createException(ApiResponseCode.OK, null);
    }

    @DeleteMapping("/comment")
    public ApiResponseDto deleteComment(@RequestBody @Valid DeleteCommentDto.Request reqDto) {
        for(DeleteCommentDto dto : reqDto.getList()) {
            boardService.delete(CommentVo.of(reqDto, dto));
        }

        return ApiResponseDto.createException(ApiResponseCode.OK, null);
    }

}
