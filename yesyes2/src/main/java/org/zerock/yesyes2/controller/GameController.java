package org.zerock.yesyes2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.zerock.yesyes2.Game.GameDTO;
import org.zerock.yesyes2.Game.GameService;
import org.zerock.yesyes2.common.Constants;

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
		List<GameDTO> latestGames = gameService.getGameList(Constants.CATEGORY_LATEST, 3);
		request.setAttribute("latestGames", latestGames);

		List<GameDTO> popularGames = gameService.getGameList(Constants.CATEGORY_POPULAR, 3);
		request.setAttribute("popularGames", popularGames);
		
		// 장르별 게임 목록을 Map에 담아 request 속성에 저장
		Map<String, List<GameDTO>> genreGamesMap = new HashMap<>();
		genreGamesMap.put(Constants.GENRE_FPS, gameService.getGameList(Constants.GENRE_FPS, 5));
		genreGamesMap.put(Constants.GENRE_MMO, gameService.getGameList(Constants.GENRE_MMO, 5));
		genreGamesMap.put(Constants.GENRE_RPG, gameService.getGameList(Constants.GENRE_RPG, 5));
		genreGamesMap.put(Constants.GENRE_AOS, gameService.getGameList(Constants.GENRE_AOS, 5));
		genreGamesMap.put(Constants.GENRE_RTS, gameService.getGameList(Constants.GENRE_RTS, 5));
		genreGamesMap.put(Constants.GENRE_CCG, gameService.getGameList(Constants.GENRE_CCG, 5));
		genreGamesMap.put(Constants.GENRE_RACING, gameService.getGameList(Constants.GENRE_RACING, 5));
		genreGamesMap.put(Constants.GENRE_SIMULATOR, gameService.getGameList(Constants.GENRE_SIMULATOR, 5));
		genreGamesMap.put(Constants.GENRE_SPORTS, gameService.getGameList(Constants.GENRE_SPORTS, 5));
		request.setAttribute("genreGamesMap", genreGamesMap);
		
		//  뷰 로 요청 전달 
		request.getRequestDispatcher("son.jsp").forward(request, response);
	}

}
