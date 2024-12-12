package kr.ac.kku.cs.wp.wsd.board2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ac.kku.cs.wp.wsd.board2.model.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
