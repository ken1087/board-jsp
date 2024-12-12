package kr.ac.kku.cs.wp.wsd.board2.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import kr.ac.kku.cs.wp.wsd.board2.dto.PostRequestDto;
import kr.ac.kku.cs.wp.wsd.board2.model.Board;
import kr.ac.kku.cs.wp.wsd.board2.repository.BoardRepository;

@Service
public class BoardService {
    
    private final BoardRepository boardRepository;

    BoardService (BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    /**
     * 게시글 전체 조회
     * @return List<Board>
     */
    public List<Board> getBoardList() {
        return boardRepository.findAll();
    }

    /**
     * 게시글 상세 조회
     * @param id
     * @return Board
     */
    public Board getBoard(Long id) {
        return boardRepository.findById(id).get();
    }

    /**
     * 게시글 등록
     * @param postRequestDto
     */
    public void postBoard(PostRequestDto postRequestDto) {

        Board board = new Board();
        board.setTitle(postRequestDto.getTitle());
        board.setContent(postRequestDto.getContent());

        boardRepository.save(board);

    }

    /**
     * 게시글 저장
     * @param id
     * @param postRequestDto
     */
    public void putBoard(Long id, PostRequestDto postRequestDto) {
        Board board = boardRepository.findById(id).get();

        board.setTitle(postRequestDto.getTitle());
        board.setContent(postRequestDto.getContent());
        board.setUpdateDate(LocalDate.now());

        boardRepository.save(board);
    }

    /**
     * 게시글 삭제
     * @param id
     */
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
