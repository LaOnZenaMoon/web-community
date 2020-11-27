package me.lozm.repository.board;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import me.lozm.entity.board.Board;
import me.lozm.object.code.BoardType;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static me.lozm.entity.board.QBoard.board;


@Repository
@RequiredArgsConstructor
public class BoardRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;


    public List<Board> selectBoardList(PageRequest pageRequest) {
        return jpaQueryFactory
                .select(board)
                .from(board)
                .orderBy(board.createdDt.desc())
                .offset(pageRequest.getPageNumber())
                .limit(pageRequest.getPageSize())
                .fetch();
    }

    public List<Board> selectBoardListByBoardType(String boardType) {
        return jpaQueryFactory
                .select(board)
                .from(board)
                .where(
                        board.boardType.eq(boardType)
                )
                .orderBy(board.createdDt.desc())
                .fetch();
    }

    public List<Board> selectBoardListByBoardType(BoardType boardType, Pageable pageable) {
        return jpaQueryFactory
                .select(board)
                .from(board)
                .where(
                        board.boardType.eq(String.valueOf(boardType))
                )
                .orderBy(board.createdDt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    public long selectCountBoardListByBoardType(BoardType boardType) {
        return jpaQueryFactory
                .select(board)
                .from(board)
                .where(
                        board.boardType.eq(String.valueOf(boardType))
                )
                .fetchCount();
    }

}
