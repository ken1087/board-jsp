package kr.ac.kku.cs.wp.wsd.board2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import kr.ac.kku.cs.wp.wsd.board2.dto.PostRequestDto;
import kr.ac.kku.cs.wp.wsd.board2.model.Board;
import kr.ac.kku.cs.wp.wsd.board2.service.BoardService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/boards")
public class BoardController {
    
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    /**
     * 게시글 전체 조회
     * @param model
     * @param getRequestDto
     * @return board.jsp
     */
    @GetMapping
    public String getBoards(
        Model model
    ) {

        List<Board> boards = boardService.getBoardList();
        
        model.addAttribute("boards", boards);

        return "board";
    }

    /**
     * 게시글 상세 조회
     * @param id
     * @param model
     * @return detail.jsp
     */
    @GetMapping("/get/{id}")
    public String getMethodName(
        @PathVariable Long id
        , Model model
    ) {
        Board board = boardService.getBoard(id);

        model.addAttribute("board", board);

        return "detail";
    }
    

    /**
     * 게시글 등록
     * @param postRequestDto
     * @return board.jsp
     */
    @PostMapping("/post")
    public String postBoard(
        PostRequestDto postRequestDto
    ) {
        boardService.postBoard(postRequestDto);
        
        return "redirect:/boards";
    }

    /**
     * 게시글 수정
     * @param id
     * @param postRequestDto
     * @return board.jsp
     */
    @PostMapping("/put/{id}")
    public String putBoard(
        @PathVariable Long id
        , PostRequestDto postRequestDto
    ) {
        boardService.putBoard(id, postRequestDto);
        
        return "redirect:/boards";
    }

    /**
     * 게시글 삭제
     * @param id
     * @return board.jsp
     */
    @PostMapping("/delete/{id}")
    public String deleteBoard(
        @PathVariable Long id    
    ) {

        boardService.deleteBoard(id);

        return "redirect:/boards";
    }

    /**
     * 글쓰기
     * @param param
     * @return write.jsp
     */
    @GetMapping("/write")
    public String getWritePage() {
        return "write";
    }

    /**
     * 글수정 페이지 이동
     * @param id
     * @param model
     * @return modify.jsp
     */
    @GetMapping("/modify/{id}")
    public String getModifyPage(
        @PathVariable Long id
        , Model model
    ) {
        Board board = boardService.getBoard(id);

        model.addAttribute("board", board);

        return "modify";
    }
    

}
