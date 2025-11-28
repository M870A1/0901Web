package Game;

import java.util.List;

public class GameService {

    public List<GameDTO> getGameList(String category,int count) {
        GameDAO dao = new GameDAO();
        // DAO를 호출하여 데이터베이스에서 게임 목록을 가져옴
        List<GameDTO> gameList = dao.getGameList(category,count);
        // DAO 내부에서 커넥션을 얻고 자원을 반납
        return gameList;
    }
    
    public int insertGame(GameDTO dto) {
        GameDAO dao = new GameDAO();
        int result = dao.insertGame(dto);
        return result;
    }
    
}
