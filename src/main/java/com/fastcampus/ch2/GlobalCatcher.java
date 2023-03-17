package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 예외 처리
	@ControllerAdvice("com.fastcampus.ch3") // 지정된 패키지에서 발생한 예외만 처리
//	@ControllerAdvice // 모든 패키지에 적용
	public class GlobalCatcher {

		//	catcher2 ( 널 , 파일 낫파운드)
		@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
		public String catcher2(Exception ex, Model m) {
			m.addAttribute("ex", ex);
			return "error";
		}

		// catcher (서버 에러러
		@ExceptionHandler(Exception.class)
		public String catcher(Exception ex, Model m) {
			m.addAttribute("ex", ex);
	
			return "error";
		}
	}
