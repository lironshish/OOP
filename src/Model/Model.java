package Model;

public class Model {

	public Player[] allPlayers;
	private static int countPlayers = 0;
	private final int MAX_PLAYERS = 8;
	private BasketBall basketBall;
	private Tennis tennis;
	private FootBall footBall;
	private int round;

	public Model() { // Constructor
		this.allPlayers = new Player[MAX_PLAYERS];
		basketBall = new BasketBall();
		tennis = new Tennis();
		footBall = new FootBall();
	}

	public Player[] getAllPlayers() {
		return allPlayers;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public void addParticipant(Player player) throws ArrayIndexOutOfBoundsException { // update the list of participans
		allPlayers[countPlayers] = player;
		countPlayers++;
	}

	public boolean checkIfThereAre8Participants() { // Check if there are 8 participants
		if (countPlayers < 8) {
			return false;
		}
		return true;
	}

	public String returnWinnerName(SportGame gameType, int[] arr1, int[] arr2) {
		return gameType.whoIsTheWinner(arr1, arr2);
	}

	public String returnWinnerName(int sum1, int sum2) {
		return footBall.whoIsTheWinnerPenatlyKicks(sum1, sum2);
	}

	public SportGame getGameType(String gameName) {
		if (gameName.equals("basketBall"))
			return basketBall;
		else if (gameName.equals("football"))
			return footBall;
		else if (gameName.equals("tennis"))
			return tennis;
		else
			return null;
	}

	public Player searchPlayerByName(String playerName) {
		for (int i = 0; i < allPlayers.length; i++) {
			if (allPlayers[i].getName().equals(playerName)) {
				return allPlayers[i];
			}
		}
		return null;
	}

	public int getRound() {
		return round;
	}

}
