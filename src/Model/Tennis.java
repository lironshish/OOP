package Model;

public class Tennis extends SportGame implements Gameable {
	private final int ROUNDS = 3;
	private final int DIFFERENCE_WINS = 3;

	public Tennis(Player player1, Player player2, Player winner) {
		super(player1, player2); // call to constructor of SportGame
	}

	public Tennis() { // Default constructor
		super(null, null);
	}

	@Override
	public String whoIsTheWinner(int[] resultPlayer1, int[] resultPlayer2) {// Returns the name of the winner
		int counter1 = 0, counter2 = 0;
		for (int i = 0; i < ROUNDS; i++) {
			if (resultPlayer1[i] > resultPlayer2[i]) {
				counter1++;
			} else if (resultPlayer2[i] > resultPlayer1[i]) {
				counter2++;
			} else if (resultPlayer2[i] == resultPlayer1[i]) {
				counter1--;
				counter2--;
			}
		}
		if (counter1 == counter2 + DIFFERENCE_WINS) {
			return player1.getName();
		} else if (counter2 == counter1 + DIFFERENCE_WINS) {
			return player2.getName();
		} else
			return null;
	}

	@Override
	public int getRounds() {
		return ROUNDS;
	}

}
