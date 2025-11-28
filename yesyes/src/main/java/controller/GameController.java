package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;

import Game.GameDTO;
import Game.GameService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index.do")
public class GameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GameService gameService;

    @Override
    public void init() throws ServletException {
        gameService = new GameService();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// 데이터 처리
		// 최신, 인기 게임 목록을 가져와 request 속성에 저장.
		List<GameDTO> latestGames = gameService.getGameList("최신",3); 
		request.setAttribute("latestGames", latestGames);

		List<GameDTO> popularGames = gameService.getGameList("인기",3);
		request.setAttribute("popularGames", popularGames);
		
		// 장르별 게임 목록을 Map에 담아 request 속성에 저장
		Map<String, List<GameDTO>> genreGamesMap = new HashMap<>();
		genreGamesMap.put("FPS", gameService.getGameList("FPS",5));
		genreGamesMap.put("MMO", gameService.getGameList("MMO",5));
		genreGamesMap.put("RPG", gameService.getGameList("RPG",5));
		genreGamesMap.put("AOS", gameService.getGameList("AOS",5));
		genreGamesMap.put("RTS", gameService.getGameList("RTS",5));
		genreGamesMap.put("CCG", gameService.getGameList("CCG",5));
		genreGamesMap.put("RACING", gameService.getGameList("RACING",5));
		genreGamesMap.put("SIMULATOR", gameService.getGameList("SIMULATOR",5));
		genreGamesMap.put("SPORTS", gameService.getGameList("SPORTS",5));
		request.setAttribute("genreGamesMap", genreGamesMap);
		
		//  뷰 로 요청 전달 
		request.getRequestDispatcher("son.jsp").forward(request, response);
	}

}
