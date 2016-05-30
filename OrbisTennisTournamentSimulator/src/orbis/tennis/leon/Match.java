package orbis.tennis.leon;

public class Match {
	
	String playerOne;
	String playerTwo;
	int playerOneScore;
	int playerTwoScore;
	String winner;
	String setScores = "";
	
	public Match(String playerOneName, String playerTwoName) {
		this.playerOneScore = 0;
		this.playerTwoScore = 0;
		this.playerOne = playerOneName;
		this.playerTwo = playerTwoName;
	}
	
	public String getWinner() {
		if (this.winner == null) {
			this.playMatch();
		}
		
		String announcement;
		setScores = setScores.substring(0, setScores.length() - 2);
		
		if (winner == this.playerOne) {
			announcement = "Game, set, match, " + this.winner + " defeats " + this.playerTwo + ", " 
					+ this.playerOneScore + " sets to " + this.playerTwoScore + ", " + this.setScores;
		}
		else {
			announcement = "Game, set, match, " + this.winner + " defeats " + this.playerOne+ ", " 
					+ this.playerTwoScore + " sets to " + this.playerOneScore + ", " + this.setScores;
		}
		  
		System.out.println(announcement);
		
		return this.winner;
	}
	
	public void playMatch() {
		while (this.playerOneScore != 2 && this.playerTwoScore != 2) {
			Set set = new Set();
			int results[] = set.getWinner();
			
			if (results[0] == 0) {
				this.playerOneScore+= 1;
				this.setScores+= results[1] + "-" + results[2] + ", ";
			}
			else {
				this.playerTwoScore+= 1;
				this.setScores+= results[1] + "-" + results[2] + ", ";
			}
		}
		
		if (this.playerOneScore == 2) {
			this.winner = this.playerOne;
		}
		else {
			this.winner = this.playerTwo;
		}	
	}
}
