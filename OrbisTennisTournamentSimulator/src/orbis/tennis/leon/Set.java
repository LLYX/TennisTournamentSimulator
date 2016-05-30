package orbis.tennis.leon;

public class Set {
	
	int playerOneScore;
	int playerTwoScore;
	int gameNumber; 
	Integer winner;
	
	public Set() {
		this.playerOneScore = 0;
		this.playerTwoScore = 0;
		this.gameNumber = 0;
	}
	
	public int[] getWinner() {
		if (this.winner == null) {
			this.playSet();
		}
		
		int results[] = {this.winner, this.playerOneScore, this.playerTwoScore};
		return results;
	}
	
	public void playSet() {
		while (this.gameNumber  < 6 || (Math.abs(this.playerOneScore - this.playerTwoScore) < 2)) {
			Game game = new Game();
			this.gameNumber+= 1;
			
			if (game.getWinner() == 0) {
				this.playerOneScore+= 1;
			}
			else {
				this.playerTwoScore+= 1;
			}
		}
		
		if (this.playerOneScore > this.playerTwoScore) {
			this.winner = 0;
		}
		else {
			this.winner = 1;
		}
	}
}
