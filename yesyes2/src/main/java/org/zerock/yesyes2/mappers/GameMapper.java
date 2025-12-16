package org.zerock.yesyes2.mappers;

import org.zerock.yesyes2.VO.GameVO;
import java.util.List;

public interface GameMapper {
    String getNow();
    List<GameVO> getGameList(String category, int count);
    int insertGame(GameVO vo);
}
