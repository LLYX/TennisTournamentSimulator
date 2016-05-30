package orbis.tennis.leon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Tournament {
	
	ArrayList<String> players;
	ArrayList<Match> matches;
	String winner;
	int roundNumber;

	public Tournament(ArrayList<String> namesOfPlayers) {
		this.players = new ArrayList<String>();
		this.matches = new ArrayList<Match>();
		
        for (String name : namesOfPlayers) {
        	this.players.add(name);
        }
        
        this.roundNumber = 1;
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int numOfPlayers = 0;
			
			System.out.print("Enter Number of Players: ");
	        numOfPlayers = Integer.parseInt(br.readLine());
			
			while (!(((numOfPlayers > 1) && (numOfPlayers < 65) && ((numOfPlayers & (numOfPlayers - 1)) == 0)))) {
				System.out.println("Please input a valid number (power of 2 between 2 and 64)...");
				System.out.print("Enter Number of Players: ");
		        numOfPlayers = Integer.parseInt(br.readLine());
			}
	        
	        System.out.print("Enter Names of Players (separated by a ,): ");
	        ArrayList<String> namesOfPlayers = new ArrayList<String>(Arrays.asList(br.readLine().split(",")));
	        
	        while (namesOfPlayers.size() < numOfPlayers) {
	        	int required = numOfPlayers - namesOfPlayers.size();
	        	System.out.println("Please input " + Integer.toString((required)) + " more names...");
	        	System.out.print("Enter a Name of a Player: ");
	        	namesOfPlayers.add(br.readLine());
	        }

	        Tournament tournament = new Tournament(namesOfPlayers);
	        
	        while (tournament.players.size() > 1) {
	        	tournament.playRound();
	        	System.out.println("Round " + Integer.toString(tournament.roundNumber) + " over!");
	        	tournament.roundNumber+= 1;
	        }
	        
	        tournament.winner = tournament.players.get(0);
	        System.out.println("And the winner of the tournament is... " + tournament.winner + "!");
		}
		catch (Exception e){
			e.printStackTrace();
		}
    }
	
	public void playRound() {
		ArrayList<String> winners = new ArrayList<String>();
		Collections.shuffle(this.players);
		
		for (int i = 0; i < this.players.size(); i+= 2) {
			String playerOne = this.players.get(i);
			String playerTwo = this.players.get(i + 1);
			
			Match match = new Match(playerOne, playerTwo);
			
			String matchWinner = match.getWinner();
			
			winners.add(matchWinner);
		}
		
		this.players = winners;
	}
}
