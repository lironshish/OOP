package Model;

public interface Gameable { // Games interface
	String whoIsTheWinner(int[] resultPlayer1, int[] resultPlayer2);

	int getRounds();
}
