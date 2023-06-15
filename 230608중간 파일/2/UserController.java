package com.coding404.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coding404.user.service.UserService;
import com.coding404.user.service.UserServiceImpl;

//1. 확장자패턴으로 변경
@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	//2. get/post하나로 모은다
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//3. 요청분기
		
		//한글처리
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring( conPath.length()  );

		System.out.println(command);
		
		//** MVC2에서는 화면을 띄우는 요청도 컨트롤러를 거쳐 나가도록 처리
		//** 기본 이동이 전부 forward형식으로 처리를 합니다.
		//** 리다이렉트는 다시 컨트롤러를 태워 나가는 용도 사용합니다.
		
		//필요한 객체를 if문 바깥에 선언
		UserService service= new UserServiceImpl();
		
		if(command.equals("/user/user_join.user")) {
			
			request.getRequestDispatcher("user_join.jsp").forward(request, response);
			
		} else if( command.equals("/user/user_login.user") ) {
			
			request.getRequestDispatcher("user_login.jsp").forward(request, response);
		
		//회원가입요청
		} else if(command.equals("/user/joinForm.user")) {
			
			//가입
			int result = service.join(request, response);
			
			if(result == 1) { //중복
				
				request.setAttribute("msg", "중복된 아이디 입니다");
				request.getRequestDispatcher("user_join.jsp").forward(request, response);
			} else { //가입성공
				
				response.sendRedirect("user_login.user");
			}
		
		//로그인
		} else if(command.equals("/user/loginForm.user")) {
			
			service.login(request, response);
			
		}
		
		
		
		
		
		
		
		
	}
	
	
}
