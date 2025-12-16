package org.zerock.yesyes2.Game;

import lombok.*;

import java.sql.Date;

@Getter
@ToString
@AllArgsConstructor
@Builder

public class GameDTO {
    private String gameId;
    private String title;
    private String description;
    private String imagePath;
    private String linkUrl;
    private String category;
    private Date regDate;

}
