package orbis.tennis.leon;

import java.util.Random;

public class Game {
	
	int playerOneScore;
	int playerTwoScore;
	static int possibleScores[] = {0, 15, 30, 40, 41};
	Integer winner;
	
	public Game() {
		this.playerOneScore = 0;
		this.playerTwoScore = 0;
	}
	
	public int getWinner() {
		if (this.winner == null) {
			this.playGame();
		}
		
		return this.winner;
	}
	
	public void playGame() {
		if (winner == null) {
			Random rand = new Random();
			int playerOneCounter = 0;
			int playerTwoCounter = 0;
			
			this.playerOneScore = possibleScores[playerOneCounter];
			this.playerTwoScore = possibleScores[playerTwoCounter];
			
			while (this.playerOneScore != 41 && this.playerTwoScore != 41) {
				if (rand.nextInt(2) == 0) {
					playerOneCounter+= 1;
					this.playerOneScore = possibleScores[playerOneCounter];
				}
				else {
					playerTwoCounter+= 1;
					this.playerTwoScore = possibleScores[playerTwoCounter];
				}
			}
			
			while (Math.abs(playerOneCounter - playerTwoCounter) < 2) {
				if (rand.nextInt(2) == 0) {
					playerOneCounter+= 1;
				}
				else {
					playerTwoCounter+= 1;
				}
			}
			
			if (playerOneCounter > playerTwoCounter) {
				this.winner = 0;
			}
			else {
				this.winner = 1;
			}
		}
	}
}
