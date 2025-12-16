package org.zerock.yesyes2.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.yesyes2.mappers.GameMapper;
import org.zerock.yesyes2.VO.GameVO;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameMapper gameMapper;

    public List<GameVO> getGameList(String category,int count) {
        // DAO를 호출하여 데이터베이스에서 게임 목록을 가져옴
        List<GameVO> gameList = gameMapper.getGameList(category,count);
        return gameList;
    }
    
    public int insertGame(GameVO vo) {
        int result = gameMapper.insertGame(vo);
        return result;
    }
}
