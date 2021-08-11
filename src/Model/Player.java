package Model;

public class Player {

	private String name;
	private int score;

	public Player(String name, int gameResult) throws Exception {
		setName(name);
		setGameResult(gameResult);
	}

	public Player() {
		this.name = null;
		this.score = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws Exception {
		if (!isOnlyLetters(name)) {
			throw new Exception("The name should be letters only");
		} else if (name.isEmpty()) {
			throw new Exception("The name should be a word");
		} else {
			this.name = name;
		}
	}

	public int getGameResult() {
		return score;
	}

	public void setGameResult(int gameResult) throws Exception {
		if (gameResult < 0) {
			throw new Exception("The result must be a positive number");
		}
	}

	public boolean isOnlyLetters(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i)) == true) {
				return false;
			}
		}
		return true;
	}

}
