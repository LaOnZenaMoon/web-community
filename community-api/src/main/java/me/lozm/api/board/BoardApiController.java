package me.lozm.api.board;

import lombok.RequiredArgsConstructor;
import me.lozm.object.code.BoardType;
import me.lozm.object.dto.board.*;
import me.lozm.object.vo.board.BoardVo;
import me.lozm.object.vo.board.CommentVo;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController @RequestMapping(value = "/api/board")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;


    @GetMapping("/boardType/{boardType}")
    public BoardGetDto.Response getBoardList(@PathVariable(value = "boardType") BoardType boardType, Pageable pageable) {
        BoardGetDto.Response resDto = new BoardGetDto.Response();
        resDto.setList(boardService.getBoardList(boardType, pageable));

        return resDto;
    }

    @GetMapping("/{boardId}")
    public BoardGetDto getBoardDetail(@PathVariable(value = "boardId") Long boardId) {
        return BoardGetDto.of(boardService.getBoardDetail(boardId));
    }

    @PostMapping
    public void postBoard(@RequestBody @Valid BoardPostDto.Request reqDto) {
        boardService.save(BoardVo.of(reqDto));
    }

    @PutMapping
    public void putBoard(@RequestBody @Valid BoardPutDto.Request reqDto) {
        boardService.update(BoardVo.of(reqDto));
    }

    @DeleteMapping
    public void deleteBoard(@RequestBody @Valid BoardDeleteDto.Request reqDto) {
        for(BoardDeleteDto dto : reqDto.getList()) {
            boardService.delete(BoardVo.of(reqDto.getModifiedBy(), dto));
        }
    }

    @GetMapping("/{boardId}/comment")
    public CommentGetDto.Response getCommentList(@PathVariable(value = "boardId") Long boardId, Pageable pageable) {
        CommentGetDto.Response resDto = new CommentGetDto.Response();
        resDto.setList(boardService.getCommentList(boardId, pageable));

        return resDto;
    }

    @PostMapping("/comment")
    public void postComment(@RequestBody @Valid CommentPostDto.Request reqDto) {
        boardService.save(CommentVo.of(reqDto));
    }

    @PutMapping("/comment")
    public void putComment(@RequestBody @Valid CommentPutDto.Request reqDto) {
        boardService.update(CommentVo.of(reqDto));
    }

    @DeleteMapping("/comment")
    public void deleteComment(@RequestBody @Valid CommentDeleteDto.Request reqDto) {
        for(CommentDeleteDto dto : reqDto.getList()) {
            boardService.delete(CommentVo.of(reqDto.getModifiedBy(), dto));
        }
    }

}
