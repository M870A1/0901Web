package service;

import java.util.List;

import Game.GameDAO;
import Game.GameDTO;

public class GameService {
	private GameDAO dao;

	public GameService() {
		dao = new GameDAO();
	}

	public List<GameDTO> getGameListByCategory(String category) {
		return dao.getGameList(category);
	}

	public int addGame(GameDTO dto) {
		return dao.insertGame(dto);
	}
}