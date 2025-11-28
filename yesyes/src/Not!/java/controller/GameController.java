package controller;

import java.io.IOException;
import java.util.List;


import Game.GameDAO;
import Game.GameDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class GameController extends HttpServlet {
	private static final long serialVersionUID = 1L; // 서블릿 직렬화 ID

	// GET 요청을 처리하는 메소드
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		// GameDAO를 사용하여 데이터베이스에서 게임 목록 불러옴
		GameDAO gameDao = new GameDAO();
		
		// 각 카테고리별 게임 목록을 가져와 request 속성에 저장
		// 이 데이터는 JSP(뷰)로 전달됩니다.
		List<GameDTO> latestGames = gameDao.getGameList("최신"); 
		request.setAttribute("latestGames", latestGames);

		List<GameDTO> popularGames = gameDao.getGameList("인기");
		request.setAttribute("popularGames", popularGames);

		List<GameDTO> fpsGames = gameDao.getGameList("장르"); 
		request.setAttribute("fpsGames", fpsGames);
		
		
		// 컨트롤러에서 처리한 데이터를 son.jsp로 전달하여 화면을 구성
		request.getRequestDispatcher("son.jsp").forward(request, response);
	}

	// @Override
	// protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	// 		throws ServletException, IOException {
	// 	// doPost 로직
	// }
}
