package kr.ac.kku.cs.wp.wsd.board2.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import kr.ac.kku.cs.wp.wsd.board2.dto.GetRequestDto;
import kr.ac.kku.cs.wp.wsd.board2.model.Board;
import kr.ac.kku.cs.wp.wsd.board2.service.BoardService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;


@WebMvcTest(BoardController.class)
public class BoardControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private BoardService boardService;

    @Test
    public void testPostBoard() throws Exception {

        mockMvc.perform(post("/boards/post")
                .param("title", "Hello")
                .param("content", "Content"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/boards"));
    }

    @Test
    public void testPutBoard() throws Exception {

        mockMvc.perform(post("/boards/put/4")
                .param("title", "Hello")
                .param("content", "Content"))
               .andExpect(status().is3xxRedirection())
               .andExpect(redirectedUrl("/boards"));
    }

    @Test
    public void testGetBoard() throws Exception {
        
        mockMvc.perform(get("/boards/get/1"))
            .andExpect(status().isOk())
            .andExpect(view().name("detail"));
    }

    @Test
    public void testDeleteBoard() throws Exception {
        mockMvc.perform(post("/boards/delete/4"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/boards"));
    }

    @Test
    public void testGetBoardList() throws Exception {
        mockMvc.perform(get("/boards"))
                .andExpect(status().isOk())
                .andExpect(view().name("board")) // view name이 boardList.jsp인지를 확인
                .andExpect(model().attributeExists("boards")); // "boards" 모델 속성이 존재하는지 확인
    }
}
