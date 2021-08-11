package Model;

public abstract class SportGame implements Gameable {

	protected enum gameType {
		basketBall, footBall, tennis
	};

	protected gameType gameType;
	protected Player player1;
	protected Player player2;

	public SportGame(Player player1, Player player2) { // Full constructor
		this.player1 = player1;
		this.player2 = player2;

	}

	public SportGame() { // Default constructor
		this.player1 = null;
		this.player2 = null;

	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

}
