package Model;

public class BasketBall extends SportGame implements Gameable {
	private final int ROUNDS = 4;

	public BasketBall(Player player1, Player player2, Player winner) {
		super(player1, player2); // call to constructor of SportGame
	}

	public BasketBall() { // Default constructor
		super(null, null);
	}

	@Override
	public String whoIsTheWinner(int[] resultPlayer1, int[] resultPlayer2) { // Returns the name of the winner
		int sumPlayer1 = 0, sumPlayer2 = 0;
		for (int i = 0; i < ROUNDS; i++) {
			sumPlayer1 = sumPlayer1 + resultPlayer1[i];
			sumPlayer2 = sumPlayer2 + resultPlayer2[i];
		}
		if (sumPlayer1 > sumPlayer2) {
			return player1.getName();
		} else if (sumPlayer1 < sumPlayer2) {
			return player2.getName();
		} else
			return null;
	}

	@Override
	public int getRounds() {

		return ROUNDS;
	}

}
