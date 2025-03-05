package com.example.springdatajpa.repository;

import com.example.springdatajpa.domain.Board;
import com.example.springdatajpa.dto.BoardIf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface BoardRepository extends JpaRepository<Board, Integer> {
    //jpql
    //jpql 은 SQL과 모양이 비슷하지만, SQL이 아니다.
    //jpql 은 객체지향 언어이다.
    @Query(value = "select b, u from Board b join User u on b.user.userId = u.userId")
    List<Board> getBoards();

    @Query(value = "select count(b) from Board b")
    Long getBoardCount();

    @Query(value = "select b, u from Board b inner join  b.user u join u.roles r where r.name=:roleName")
    List<Board> findByBoards(@Param("roleName") String roleName);

    @Query(value = "select b.board_id, b.title, b.content, b.user_id, u.name, b.regdate, b.view_cnt from board b, user u where b.user_id = u.user_id",
            nativeQuery = true
    )
    List<BoardIf> getBoardsWithNativeQuery();

}
