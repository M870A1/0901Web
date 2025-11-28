package Game;

import java.sql.Date;

public class GameDTO {
	private String gameId;
	private String title;
	private String description;
	private String imagePath;
	private String linkUrl;
	private String category;
	private java.sql.Date regDate;
	public GameDTO(String gameId, String title, String description, String imagePath, String linkUrl, String category,
			Date regDate) {
		super();
		this.gameId = gameId;
		this.title = title;
		this.description = description;
		this.imagePath = imagePath;
		this.linkUrl = linkUrl;
		        this.category = category;
		        this.regDate = regDate;	}
	public String getGameId() {
		return gameId;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public java.sql.Date getRegDate() {
		return regDate;
	}
	public void setRegDate(java.sql.Date regDate) {
		this.regDate = regDate;
	}



}




