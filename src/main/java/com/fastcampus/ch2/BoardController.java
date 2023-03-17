package com.fastcampus.ch2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


// 게시판
@Controller
@RequestMapping("/board")
public class BoardController {

	// 게시판 목록
	@GetMapping("/list")
	public String list(HttpServletRequest request) {
		// 로그인을 안한 상태에서 게시판 목록을 요청하면 로그인 화면으로 이동
		if(!loginCheck(request))
			return "redirect:/login/login?toURL="+request.getRequestURL();  // 로그인을 안했으면 로그인 화면으로 이동
		
		return "boardList"; // 로그인을 한 상태이면, 게시판 화면으로 이동
	}

	// 로긴 체크
	private boolean loginCheck(HttpServletRequest request) {
		// 1. 세션을 얻어서
		HttpSession session = request.getSession();
		// 2. 세션에 id가 있는지 확인, 있으면 true를 반환
		return session.getAttribute("id")!=null;
	}
}
