package me.lozm.api.board;

import lombok.RequiredArgsConstructor;
import me.lozm.entity.board.Board;
import me.lozm.entity.board.Comment;
import me.lozm.global.exception.ServiceException;
import me.lozm.object.code.BoardType;
import me.lozm.object.vo.board.BoardVo;
import me.lozm.object.vo.board.CommentVo;
import me.lozm.repository.board.BoardRepository;
import me.lozm.repository.board.BoardRepositorySupport;
import me.lozm.repository.board.CommentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    private final BoardRepositorySupport boardRepositorySupport;


    public Page<Board> getBoardList(BoardType boardType, Pageable pageable) {
        List<Board> boardList = boardRepositorySupport.getBoardListByBoardType(boardType, pageable);
        long totalCount = boardRepositorySupport.getTotalCountByBoardType(boardType);
        return new PageImpl<>(boardList, pageable, totalCount);
    }

    public Board getBoardDetail(Long boardId) {
        return findBoard(boardId).get();
    }

    @Transactional
    public void save(BoardVo boardVo) {
        Board board = Board.builder().build();
        board.insertBoard(boardVo);

        boardRepository.save(board);
    }

    @Transactional
    public void update(BoardVo boardVo) {
        Optional<Board> findBoard = findBoard(boardVo.getId());
        findBoard.get().updateBoard(boardVo);
    }

    @Transactional
    public void delete(BoardVo boardVo) {
        Optional<Board> findBoard = findBoard(boardVo.getId());
        findBoard.get().deleteBoard(boardVo);
    }

    public List<Comment> getCommentList(Long boardId) {
        return commentRepository.selectCommentListByBoardId(boardId);
    }

    @Transactional
    public void save(CommentVo commentVo) {
        Optional<Board> findBoard = findBoard(commentVo.getBoardId());

        Comment comment = Comment.builder().build();
        comment.insertComment(commentVo, findBoard.get());

        commentRepository.save(comment);
    }

    @Transactional
    public void update(CommentVo commentVo) {
        Optional<Comment> findComment = findComment(commentVo.getId());
        findComment.get().updateComment(commentVo);
    }

    @Transactional
    public void delete(CommentVo commentVo) {
        Optional<Comment> findComment = findComment(commentVo.getId());
        findComment.get().deleteComment(commentVo);
    }

    private Optional<Board> findBoard(Long boardId) {
        Optional<Board> findBoard = boardRepository.findById(boardId);
        findBoard.orElseThrow(() -> new ServiceException("BOARD_0002", "Board doesn't exist."));
        return findBoard;
    }

    private Optional<Comment> findComment(Long commentId) {
        Optional<Comment> findComment = commentRepository.findById(commentId);
        findComment.orElseThrow(() -> new ServiceException("COMMENT_0002", "Comment doesn't exist."));
        return findComment;
    }

}
