package com.example.springdatajpa;

import com.example.springdatajpa.domain.Board;
import com.example.springdatajpa.domain.Role;
import com.example.springdatajpa.domain.User;
import com.example.springdatajpa.dto.BoardIf;
import com.example.springdatajpa.repository.BoardRepository;
import com.example.springdatajpa.repository.RoleRepository;
import com.example.springdatajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class SpringdatajpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	BoardRepository boardRepository;

	@Override
	public void run(String... args) throws Exception {
//		List<Board> boards = boardRepository.getBoards();
//		for (Board board : boards) {
//			System.out.println("board = " + board);
//			System.out.println("board = " + board.getUser());
//		}
//		Long boardCount = boardRepository.getBoardCount();
//		System.out.println(boardCount);
		//
//		Role role = roleRepository.findById(2).get();
//		System.out.println("role = " + role);
//
//		User user = new User();
//		user.setName("관리자");
//		user.setEmail("admin@naver.com");
//		user.setPassword("1234");
//		user.setRegdate(LocalDateTime.now());
//		user.setRoles(Set.of(role));
//
//		userRepository.save(user);

//		User user = userRepository.findById(6).get();
//		Board board = new Board();
//		board.setUser(user);
//		board.setRegdate(LocalDateTime.now());
//		board.setTitle("관리자의 글");
//		board.setContent("내용입니다.");
//
//		boardRepository.save(board);
		//
//		List<Board> adminBoard = boardRepository.findByBoards("ROLE_ADMIN");
//		for (Board board : adminBoard) {
//			System.out.println(board);
//		}
		List<BoardIf> list = boardRepository.getBoardsWithNativeQuery();
		for (BoardIf board : list) {
			System.out.println("board = " + board);
		}
	}

}
