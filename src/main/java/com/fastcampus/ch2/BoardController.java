package com.fastcampus.ch2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


// �Խ���
@Controller
@RequestMapping("/board")
public class BoardController {

	// �Խ��� ���
	@GetMapping("/list")
	public String list(HttpServletRequest request) {
		// �α����� ���� ���¿��� �Խ��� ����� ��û�ϸ� �α��� ȭ������ �̵�
		if(!loginCheck(request))
			return "redirect:/login/login?toURL="+request.getRequestURL();  // �α����� �������� �α��� ȭ������ �̵�
		
		return "boardList"; // �α����� �� �����̸�, �Խ��� ȭ������ �̵�
	}

	// �α� üũ
	private boolean loginCheck(HttpServletRequest request) {
		// 1. ������ ��
		HttpSession session = request.getSession();
		// 2. ���ǿ� id�� �ִ��� Ȯ��, ������ true�� ��ȯ
		return session.getAttribute("id")!=null;
	}
}
