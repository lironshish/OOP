package View;

import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.CheckBox;

public class View {

	private BorderPane bp;
	private RadioButton rbTennis, rbFootBall, rbBasketBall;
	private TextField tfPlayerName;
	private Button btAddPlayer, btStartGame, btPlayGame, btPlayGame1, btPlayGame2, btPlayGame3, btPlayGame4,
			btPlayGame5, btPlayGame6, btPlayGame7, btDonePlay, btDonePlayKick;
	private Scene main;
	private StackPane spTop;
	private Pane pCenter;
	private ToggleGroup tgType;
	private Group root;
	private VBox vbAllPlayers;
	private Stage gameStage;
	private int i = 0, penatlyKicks;
	private Button btWin1, btWin2, btWin3, btWin4, btWin5, btWin6, btWinner;
	private TextField[] resultPlayer1, resultPlayer2;
	private CheckBox[] cBpenaltyKicksRound1, cBpenaltyKicksRound2;
	private Button[] btAllPlayers;
	private Label lbPlayer1, lbPlayer2;

	public View(Stage primaryStage) throws Exception {
		bp = new BorderPane();

		// Initialize main menu buttons
		tgType = new ToggleGroup();
		rbTennis = new RadioButton("Tennis");
		rbTennis.setToggleGroup(tgType);
		rbFootBall = new RadioButton("FootBall");
		rbFootBall.setToggleGroup(tgType);
		rbBasketBall = new RadioButton("BasketBall");
		rbBasketBall.setToggleGroup(tgType);
		tfPlayerName = new TextField();
		btAddPlayer = new Button("Add participant");
		btStartGame = new Button("Start championship");
		spTop = new StackPane();
		root = new Group();
		pCenter = new Pane();
		vbAllPlayers = new VBox();
		btAllPlayers = new Button[8];

		// Initialize play game buttons
		btPlayGame = new Button("play game");
		gameStage = new Stage();
		gameStage.setTitle("The Game");
		btDonePlay = new Button("Done");
		penatlyKicks = 0;
		btPlayGame1 = new Button("play game");
		btPlayGame2 = new Button("play game");
		btPlayGame3 = new Button("play game");
		btPlayGame4 = new Button("play game");
		btPlayGame5 = new Button("play game");
		btPlayGame6 = new Button("play game");
		btPlayGame7 = new Button("play game");
		btWin1 = new Button();
		btWin2 = new Button();
		btWin3 = new Button();
		btWin4 = new Button();
		btWin5 = new Button();
		btWin6 = new Button();
		btWinner = new Button();

		// Button design
		btWin1.setStyle(
				"-fx-background-color: ALICEBLUE; -fx-border-color: BLACK; -fx-border-width: 2px; -fx-font-size: 18; ");
		btWin2.setStyle(
				"-fx-background-color: ALICEBLUE; -fx-border-color: BLACK; -fx-border-width: 2px; -fx-font-size:18; ");
		btWin3.setStyle(
				"-fx-background-color: ALICEBLUE; -fx-border-color: BLACK; -fx-border-width: 2px; -fx-font-size: 18; ");
		btWin4.setStyle(
				"-fx-background-color: ALICEBLUE; -fx-border-color: BLACK; -fx-border-width: 2px; -fx-font-size: 18; ");
		btWin5.setStyle(
				"-fx-background-color: ALICEBLUE; -fx-border-color: BLACK; -fx-border-width: 2px; -fx-font-size: 18; ");
		btWin6.setStyle(
				"-fx-background-color: ALICEBLUE; -fx-border-color: BLACK; -fx-border-width: 2px; -fx-font-size: 18; ");
		btWinner.setStyle(
				"-fx-background-color: ALICEBLUE; -fx-border-color: BLACK; -fx-border-width: 2px; -fx-font-size: 18; ");

		// Initialize the game buttons:
		resultPlayer1 = new TextField[4];
		resultPlayer2 = new TextField[4];
		cBpenaltyKicksRound1 = new CheckBox[5];
		cBpenaltyKicksRound2 = new CheckBox[5];
		btDonePlayKick = new Button("Done");
		lbPlayer1 = new Label();
		lbPlayer2 = new Label();
		for (int i = 0; i < cBpenaltyKicksRound1.length; i++) {
			cBpenaltyKicksRound1[i] = new CheckBox();
		}
		for (int i = 0; i < cBpenaltyKicksRound2.length; i++) {
			cBpenaltyKicksRound2[i] = new CheckBox();
		}
		updateMain();

		// set the scene
		primaryStage.setTitle("Yuval and Liron Game");
		primaryStage.setScene(main);
		primaryStage.show();
	}

	public void updateMain() {
		// center main
		HBox hbParticipantName1 = new HBox();
		HBox hbParticipantName2 = new HBox();
		VBox vbParticipantName = new VBox();
		Label lbParticipantName = new Label("participant name: ");

		hbParticipantName1.getChildren().addAll(lbParticipantName, tfPlayerName);
		hbParticipantName2.getChildren().addAll(btAddPlayer, btStartGame);
		vbParticipantName.getChildren().addAll(hbParticipantName1, hbParticipantName2);

		VBox.setMargin(hbParticipantName1, new Insets(100, 0, 0, 450));
		VBox.setMargin(hbParticipantName2, new Insets(30, 0, 0, 450));

		HBox.setMargin(btAddPlayer, new Insets(0, 20, 0, 0));
		HBox.setMargin(btStartGame, new Insets(0, 0, 0, 20));

		tfPlayerName.setFont(new Font(16));
		lbParticipantName.setFont(new Font(16));
		btAddPlayer.setFont(new Font(16));
		btStartGame.setFont(new Font(16));

		pCenter.getChildren().addAll(root, vbParticipantName);

		// top main
		Label lbChampionship = new Label("Championship");
		shadowLabel(lbChampionship);

		lbChampionship.setFont(new Font("Tahoma", 40));

		spTop.getChildren().add(lbChampionship);
		spTop.setAlignment(Pos.CENTER);
		bp.setTop(spTop);

		// right main
		VBox vbGameType = new VBox();

		rbTennis.setFont(new Font(20));
		rbFootBall.setFont(new Font(20));
		rbBasketBall.setFont(new Font(20));

		vbGameType.getChildren().addAll(rbTennis, rbFootBall, rbBasketBall);
		rbTennis.setSelected(true);

		VBox.setMargin(rbTennis, new Insets(50, 15, 20, 465));
		VBox.setMargin(rbFootBall, new Insets(50, 15, 20, 465));
		VBox.setMargin(rbBasketBall, new Insets(50, 15, 20, 465));

		vbGameType.setAlignment(Pos.TOP_RIGHT);
		bp.setRight(vbGameType);

		// leftMain
		for (int i = 0; i < btAllPlayers.length; i++) {
			btAllPlayers[i] = new Button();
			btAllPlayers[i].setStyle(
					"-fx-background-color: ALICEBLUE; -fx-border-color: BLACK; -fx-border-width: 2px; -fx-font-size: 18; ");
			vbAllPlayers.getChildren().add(btAllPlayers[i]);
			VBox.setMargin(btAllPlayers[i], new Insets(15, 0, 0, 5));
			btAllPlayers[i].setPrefSize(140, 40);
		}
		pCenter.getChildren().addAll(vbAllPlayers);

		bp.setCenter(pCenter);
		main = new Scene(bp, 1280, 720);
	}

	public void addParticipant() {
		btAllPlayers[i].setText(tfPlayerName.getText());
		i++;
		tfPlayerName.setText("");
	}

	public void gameScene() { // New screen for participants and winners
		bp.getChildren().clear(); // Reset the screen
		spTop.getChildren().clear();

		Label lbGameName = new Label(getGameType());
		HBox playGame = new HBox();
		HBox playersName = new HBox();
		HBox hbMiddle = new HBox();
		HBox hbBottom = new HBox();
		HBox hbWinner = new HBox();
		HBox hbFinal = new HBox();
		HBox hbFinalPlay = new HBox();
		VBox vbAll = new VBox();

		playGame.getChildren().addAll(btPlayGame1, btPlayGame2, btPlayGame3, btPlayGame4);
		hbMiddle.getChildren().addAll(btWin1, btWin2, btWin3, btWin4);
		playersName.getChildren().addAll(btAllPlayers);
		spTop.getChildren().add(lbGameName);
		hbBottom.getChildren().addAll(btPlayGame5, btPlayGame6);
		hbFinal.getChildren().addAll(btWin5, btWin6);
		hbFinalPlay.getChildren().addAll(btPlayGame7);
		hbWinner.getChildren().addAll(btWinner);
		vbAll.getChildren().addAll(playersName, playGame, hbMiddle, hbBottom, hbFinal, hbFinalPlay, hbWinner);
		vbAll.setSpacing(10);
		// Arranging the labels
		HBox.setMargin(btAllPlayers[0], new Insets(40, 0, 0, 70));
		HBox.setMargin(btAllPlayers[1], new Insets(40, 0, 0, 3));
		HBox.setMargin(btAllPlayers[2], new Insets(40, 0, 0, 50));
		HBox.setMargin(btAllPlayers[3], new Insets(40, 0, 0, 3));
		HBox.setMargin(btAllPlayers[4], new Insets(40, 0, 0, 50));
		HBox.setMargin(btAllPlayers[5], new Insets(40, 0, 0, 3));
		HBox.setMargin(btAllPlayers[6], new Insets(40, 0, 0, 50));
		HBox.setMargin(btAllPlayers[7], new Insets(40, 25, 15, 3));
		HBox.setMargin(btPlayGame1, new Insets(0, 0, 0, 140));
		HBox.setMargin(btPlayGame2, new Insets(0, 0, 0, 220));
		HBox.setMargin(btPlayGame3, new Insets(0, 0, 0, 230));
		HBox.setMargin(btPlayGame4, new Insets(0, 0, 15, 240));
		HBox.setMargin(btWin1, new Insets(0, 0, 0, 190));
		HBox.setMargin(btWin2, new Insets(0, 0, 0, 3));
		HBox.setMargin(btWin3, new Insets(0, 0, 0, 400));
		HBox.setMargin(btWin4, new Insets(0, 0, 0, 3));
		HBox.setMargin(btPlayGame5, new Insets(15, 0, 0, 270));
		HBox.setMargin(btPlayGame6, new Insets(15, 0, 0, 635));
		HBox.setMargin(btWin5, new Insets(15, 0, 0, 260));
		HBox.setMargin(btWin6, new Insets(15, 0, 0, 590));
		HBox.setMargin(btPlayGame7, new Insets(25, 0, 0, 600));
		HBox.setMargin(btWinner, new Insets(15, 0, 0, 580));

		shadowLabel(lbGameName);
		lbGameName.setFont(new Font("Tahoma", 40));
		btPlayGame1.setFont(new Font(16));
		btPlayGame2.setFont(new Font(16));
		btPlayGame3.setFont(new Font(16));
		btPlayGame4.setFont(new Font(16));
		btPlayGame5.setFont(new Font(16));
		btPlayGame6.setFont(new Font(16));
		btPlayGame7.setFont(new Font(16));
		spTop.setAlignment(Pos.CENTER);
		btPlayGame.setAlignment(Pos.BOTTOM_RIGHT);
		btWin1.setPrefSize(btAllPlayers[0].getWidth(), btAllPlayers[0].getHeight());
		btWin2.setPrefSize(btAllPlayers[0].getWidth(), btAllPlayers[0].getHeight());
		btWin3.setPrefSize(btAllPlayers[0].getWidth(), btAllPlayers[0].getHeight());
		btWin4.setPrefSize(btAllPlayers[0].getWidth(), btAllPlayers[0].getHeight());
		btWin5.setPrefSize(btAllPlayers[0].getWidth(), btAllPlayers[0].getHeight());
		btWin6.setPrefSize(btAllPlayers[0].getWidth(), btAllPlayers[0].getHeight());
		btWinner.setPrefSize(btAllPlayers[0].getWidth(), btAllPlayers[0].getHeight());

		bp.setCenter(vbAll);
		bp.setTop(spTop);
	}

	public void playGame(String player1, String player2) { // new screen to game
		BorderPane bpGame = new BorderPane();
		Label lbGameName = new Label(getGameType());
		lbGameName.setAlignment(Pos.TOP_CENTER);
		shadowLabel(lbGameName);
		lbGameName.setFont(new Font("Ariel", 32));

		// Top game
		updateTextFieldArray();

		// Center game
		StackPane spCenter = new StackPane();

		lbPlayer1.setText(player1);
		lbPlayer2.setText(player2);
		lbPlayer1.setFont(new Font(16));
		lbPlayer2.setFont(new Font(16));

		VBox vbPlayersName = new VBox();
		HBox hbResult1 = new HBox();
		HBox hbResult2 = new HBox();
		VBox vbResults = new VBox();
		HBox hbAll = new HBox();
		VBox vbAll = new VBox();

		vbPlayersName.getChildren().addAll(lbPlayer1, lbPlayer2);
		hbResult1.getChildren().addAll(resultPlayer1);
		hbResult1.setSpacing(10);
		hbResult2.getChildren().addAll(resultPlayer2);
		hbResult2.setSpacing(10);
		vbResults.getChildren().addAll(hbResult1, hbResult2);
		vbResults.setSpacing(10);
		hbAll.getChildren().addAll(vbPlayersName, vbResults);
		hbAll.setSpacing(10);
		hbAll.setAlignment(Pos.CENTER);
		vbAll.getChildren().addAll(lbGameName, hbAll, btDonePlay);
		vbAll.setAlignment(Pos.BASELINE_CENTER);
		vbAll.setSpacing(10);
		spCenter.getChildren().addAll(vbAll);
		bpGame.setCenter(spCenter);
		if (getGameType().equals("football")) { // In football, results of 2 halves are recorded
			resultPlayer1[2].setVisible(false);
			resultPlayer1[3].setVisible(false);
			resultPlayer2[2].setVisible(false);
			resultPlayer2[3].setVisible(false);
		}
		if (getGameType().equals("tennis")) { // In tennis, results of 3 or 5 sets are recorded - we chose 3
			resultPlayer1[3].setVisible(false);
			resultPlayer2[3].setVisible(false);
		}
		Scene gameScene = new Scene(bpGame, 300, 300);
		gameStage.setScene(gameScene);
		gameStage.show();
	}

	public void updateWinner(String winner, int round) {
		if (round == 0) {
			btWin1.setText(winner);
			btPlayGame1.setDisable(true);
		}
		if (round == 2) {
			btWin2.setText(winner);
			btPlayGame2.setDisable(true);
		}
		if (round == 4) {
			btWin3.setText(winner);
			btPlayGame3.setDisable(true);
		}
		if (round == 6) {
			btWin4.setText(winner);
			btPlayGame4.setDisable(true);
		}
		if (round == 7) {
			btWin5.setText(winner);
			btPlayGame5.setDisable(true);
		}
		if (round == 8) {
			btWin6.setText(winner);
			btPlayGame6.setDisable(true);
		}
		if (round == 9) {
			btWinner.setText(winner);
			btPlayGame7.setDisable(true);
		}
	}

	public void penaltyKicksFootball() {
		BorderPane bpKick = new BorderPane();
		StackPane spCenter = new StackPane();
		Label lbPenaltyKicks = new Label("Penalty Kicks");
		shadowLabel(lbPenaltyKicks);
		lbPenaltyKicks.setFont(new Font("Ariel", 32));

		VBox vbPlayersName = new VBox();
		HBox hbResult1 = new HBox();
		HBox hbResult2 = new HBox();
		VBox vbResults = new VBox();
		HBox hbAll = new HBox();
		VBox vbAll = new VBox();

		vbPlayersName.getChildren().addAll(lbPlayer1, lbPlayer2);
		hbResult1.getChildren().addAll(cBpenaltyKicksRound1);
		hbResult1.setSpacing(10);
		hbResult2.getChildren().addAll(cBpenaltyKicksRound2);
		hbResult2.setSpacing(10);
		vbResults.getChildren().addAll(hbResult1, hbResult2);
		vbResults.setSpacing(10);
		hbAll.getChildren().addAll(vbPlayersName, vbResults);
		hbAll.setSpacing(10);
		hbAll.setAlignment(Pos.CENTER);
		vbAll.getChildren().addAll(lbPenaltyKicks, hbAll, btDonePlayKick);
		vbAll.setAlignment(Pos.BASELINE_CENTER);
		vbAll.setSpacing(10);
		spCenter.getChildren().addAll(vbAll);
		updateCbPenatlyKicks();
		bpKick.setCenter(spCenter);
		gameStage.getScene().setRoot(bpKick);
	}

	public void standoffFootBall() {
		resultPlayer1[1].setVisible(false);
		resultPlayer2[1].setVisible(false);
		resultPlayer1[1].setText("0");
		resultPlayer2[1].setText("0");
		resultPlayer1[0].setText("");
		resultPlayer2[0].setText("");
	}

	public void updateTextFieldArray() {
		for (int i = 0; i < 4; i++) {
			resultPlayer1[i] = new TextField();
			resultPlayer1[i].setPrefWidth(30);
		}
		for (int i = 0; i < 4; i++) {
			resultPlayer2[i] = new TextField();
			resultPlayer2[i].setPrefWidth(30);
		}
	}

	public void showErrorMessage(String errorMessage) { // show error message in exceptions
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setContentText(errorMessage);
		alert.show();
	}

	public Label shadowLabel(Label tempLabel) { // Label design
		tempLabel.setEffect(new DropShadow(15, Color.DARKBLUE));
		return tempLabel;
	}

	public void clearRsultTf() { // Reset the TextField if the user entered incorrect data
		for (int i = 0; i < resultPlayer1.length; i++)
			resultPlayer1[i].setText("");
		for (int i = 0; i < resultPlayer2.length; i++)
			resultPlayer2[i].setText("");

	}

	public void updateEqualityScene() {
		if (getGameType() == "basketBall") {
			showErrorMessage("standoff! please type again");
			clearRsultTf();
		} else if (getGameType() == "tennis") {
			showErrorMessage("To win you need a difference of 3 wins. Try again");
			clearRsultTf();
		} else if (getGameType() == "football" && penatlyKicks == 0) {
			standoffFootBall();
			penatlyKicks++;
		} else if (getGameType() == "football" && penatlyKicks == 1) {
			penaltyKicksFootball();
			penatlyKicks++;
		} else if (getGameType() == "football" && penatlyKicks > 1) {
			updateCbPenatlyKicks();
			showErrorMessage("Standoff! Another round of penalty kicks");
			penaltyKicksFootball();
		}
	}

	public void updateCbPenatlyKicks() {
		for (int i = 0; i < cBpenaltyKicksRound1.length; i++)
			cBpenaltyKicksRound1[i].setSelected(false);
		for (int i = 0; i < cBpenaltyKicksRound2.length; i++)
			cBpenaltyKicksRound2[i].setSelected(false);
	}

	public int howManyPentalyKicksPlayer1() {
		int count = 0;
		for (int i = 0; i < cBpenaltyKicksRound1.length; i++) {
			if (cBpenaltyKicksRound1[i].isSelected()) {
				count++;
			}
		}
		return count;
	}

	public int howManyPentalyKicksPlayer2() {
		int count = 0;
		for (int i = 0; i < cBpenaltyKicksRound2.length; i++) {
			if (cBpenaltyKicksRound2[i].isSelected()) {
				count++;
			}
		}
		return count;
	}

	public boolean checkIfRound1Ended() {
		if (btWin1.getText() != "" && btWin2.getText() != "" && btWin3.getText() != "" && btWin4.getText() != "") {
			return true;
		}
		return false;

	}

	public boolean checkIfRound2Ended() {
		if (checkIfRound1Ended() && btWin5.getText() != "" && btWin6.getText() != "") {
			return true;
		}
		return false;

	}

	public boolean checkIfRound2Started() {
		if (checkIfRound1Ended() && (btWin5.getText() != "" || btWin6.getText() != "")) {
			return true;
		}
		return false;
	}

	public boolean checkIfRound3Started() {
		if (checkIfRound2Ended() && btWinner.getText() != "") {
			return true;
		}
		return false;
	}

	// Setters and Getters
	public TextField getResultPlayer1(int i) {
		return resultPlayer1[i];
	}

	public TextField getResultPlayer2(int i) {
		return resultPlayer2[i];
	}

	public Button getBtAddPlayer() {
		return btAddPlayer;
	}

	public Button getBtStartGame() {
		return btStartGame;
	}

	public String getTfPlayerName() {
		return tfPlayerName.getText();
	}

	public Button getBtDonePlay() {
		return btDonePlay;
	}

	public Button getBtPlayGame1() {
		return btPlayGame1;
	}

	public Button getBtPlayGame2() {
		return btPlayGame2;
	}

	public Button getBtPlayGame3() {
		return btPlayGame3;
	}

	public Button getBtPlayGame4() {
		return btPlayGame4;
	}

	public TextField[] getResultPlayer1() {
		return resultPlayer1;
	}

	public TextField[] getResultPlayer2() {
		return resultPlayer2;
	}

	public void closeGameStage() {
		gameStage.close();
	}

	public String getGameType() {
		if (rbBasketBall.isSelected())
			return "basketBall";
		else if (rbFootBall.isSelected())
			return "football";
		else if (rbTennis.isSelected())
			return "tennis";
		else
			return null;
	}

	public Button getBtWin1() {
		return btWin1;
	}

	public Button getBtWin2() {
		return btWin2;
	}

	public Button getBtWin3() {
		return btWin3;
	}

	public Button getBtWin4() {
		return btWin4;
	}

	public Button getBtWin5() {
		return btWin5;
	}

	public Button getBtWin6() {
		return btWin6;
	}

	public Button getBtPlayGame5() {
		return btPlayGame5;
	}

	public Button getBtPlayGame6() {
		return btPlayGame6;
	}

	public Button getBtPlayGame7() {
		return btPlayGame7;
	}

	public int getPenatlyKicks() {
		return penatlyKicks;
	}

	public Button getBtDonePlayKick() {
		return btDonePlayKick;
	}

	public void setPenatlyKicks(int penatlyKicks) {
		this.penatlyKicks = penatlyKicks;
	}

}
