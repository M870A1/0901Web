package org.zerock.yesyes2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.zerock.yesyes2.VO.GameVO; // GameVO 임포트
import org.zerock.yesyes2.Game.GameService;
import org.zerock.yesyes2.common.Constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GameController {
	
    @Autowired
    private GameService gameService;

    @GetMapping({"/", "/index"})
    public String mainPage(Model model) {
        
        // 데이터 처리
        // 최신, 인기 게임 목록을 가져와 request 속성에 저장.
        List<GameVO> latestGames = gameService.getGameList(Constants.CATEGORY_LATEST, 3);
        model.addAttribute("latestGames", latestGames);

        List<GameVO> popularGames = gameService.getGameList(Constants.CATEGORY_POPULAR, 3);
        model.addAttribute("popularGames", popularGames);
        
        // 장르별 게임 목록을 Map에 담아 request 속성에 저장
        Map<String, List<GameVO>> genreGamesMap = new HashMap<>();
        genreGamesMap.put(Constants.GENRE_FPS, gameService.getGameList(Constants.GENRE_FPS, 5));
        genreGamesMap.put(Constants.GENRE_MMO, gameService.getGameList(Constants.GENRE_MMO, 5));
        genreGamesMap.put(Constants.GENRE_RPG, gameService.getGameList(Constants.GENRE_RPG, 5));
        genreGamesMap.put(Constants.GENRE_AOS, gameService.getGameList(Constants.GENRE_AOS, 5));
        genreGamesMap.put(Constants.GENRE_RTS, gameService.getGameList(Constants.GENRE_RTS, 5));
        genreGamesMap.put(Constants.GENRE_CCG, gameService.getGameList(Constants.GENRE_CCG, 5));
        genreGamesMap.put(Constants.GENRE_RACING, gameService.getGameList(Constants.GENRE_RACING, 5));
        genreGamesMap.put(Constants.GENRE_SIMULATOR, gameService.getGameList(Constants.GENRE_SIMULATOR, 5));
        genreGamesMap.put(Constants.GENRE_SPORTS, gameService.getGameList(Constants.GENRE_SPORTS, 5));
        model.addAttribute("genreGamesMap", genreGamesMap);
        
        //  뷰 로 요청 전달 
        return "son";
    }
}
