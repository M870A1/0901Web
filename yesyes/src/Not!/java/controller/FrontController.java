package controller;

import java.io.IOException;

import action.Action;
import action.ActionFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String command = request.getRequestURI();
		command = command.substring(request.getContextPath().length());
		System.out.println("프론트 커멘드 에서 받은 커멘드 ::" + command);

		// Action 객체 생성
		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getAction(command);

		//  Action을 실행하고, 반환된 경로로 포워딩
		if (action != null) {
			String forwardPath = action.execute(request, response);
			if (forwardPath != null) {
				if (forwardPath.startsWith("/")) {
					// 절대 경로인 경우: /WEB-INF/views/login.jsp를 사용
					RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
					dispatcher.forward(request, response);
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
					dispatcher.forward(request, response);
				}
			}
		} else {

			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().println("<h1>FrontController: 처리할 수 없는 요청입니다: " + command + "</h1>");
		}

	}
}
