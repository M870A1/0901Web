package action;

import java.io.IOException;
import java.util.List;

import Game.GameDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.GameService;

public class SonAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");// 한글 처리

		GameService service = new GameService();

		List<GameDTO> latestGames = service.getGameListByCategory("최신"); // 카테고리
		List<GameDTO> popularGames = service.getGameListByCategory("인기"); // 카테고리
		List<GameDTO> genreGames = service.getGameListByCategory("장르"); // 카테고리
		
		request.setAttribute("latestGames", latestGames);
		request.setAttribute("popularGames", popularGames);
		request.setAttribute("genreGames", genreGames);

		return "/son.jsp";
	}

}
