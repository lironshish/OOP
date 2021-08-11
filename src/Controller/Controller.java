package Controller;

import java.util.InputMismatchException;
import Model.Model;
import Model.Player;
import View.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Controller {
	private Model theModel;
	private View theView;

	public Controller(Model m, View v) throws Exception {
		theModel = m;
		theView = v;

		// Add new player handler
		EventHandler<ActionEvent> addParticipantEvent = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					Player player = new Player(theView.getTfPlayerName(), 0);
					theModel.addParticipant(player); // update the list of participants
					theView.addParticipant(); // Add the participant name to the screen
					if (!theView.getTfPlayerName().isEmpty()) {
						throw new Exception("Please enter a name");
					}
				} catch (ArrayIndexOutOfBoundsException e) { // If the user tries to enter more than 8 participants
					theView.showErrorMessage("You can add only 8 players");
				} catch (Exception e) {
					theView.showErrorMessage(e.getMessage());
				}
			}
		};

		EventHandler<ActionEvent> startChampionShipEvent = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!theModel.checkIfThereAre8Participants()) { // If the user tries to start the game without 8
					// participants
					theView.showErrorMessage("8 players must be added");
				}
				if (theModel.checkIfThereAre8Participants()) {
					theView.gameScene();
				}
			}
		};

		// Events to Buttons
		EventHandler<ActionEvent> playGameEvent1 = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if (!theView.checkIfRound2Started()) {
					theView.playGame(theModel.allPlayers[0].getName(), theModel.allPlayers[1].getName());
					theModel.getGameType(theView.getGameType()).setPlayer1(theModel.allPlayers[0]);
					theModel.getGameType(theView.getGameType()).setPlayer2(theModel.allPlayers[1]);
					theModel.setRound(0);
					theView.setPenatlyKicks(0);
				} else {
					theView.showErrorMessage("You cannot return to Round 1 if you started the next rounds");
				}
			}

		};

		EventHandler<ActionEvent> playGameEvent2 = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if (!theView.checkIfRound2Started()) {
					theView.playGame(theModel.allPlayers[2].getName(), theModel.allPlayers[3].getName());
					theModel.getGameType(theView.getGameType()).setPlayer1(theModel.allPlayers[2]);
					theModel.getGameType(theView.getGameType()).setPlayer2(theModel.allPlayers[3]);
					theModel.setRound(2);
					theView.setPenatlyKicks(0);
				} else {
					theView.showErrorMessage("You cannot return to Round 1 if you started the next rounds");
				}
			}
		};

		EventHandler<ActionEvent> playGameEvent3 = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if (!theView.checkIfRound2Started()) {
					theView.playGame(theModel.allPlayers[4].getName(), theModel.allPlayers[5].getName());
					theModel.getGameType(theView.getGameType()).setPlayer1(theModel.allPlayers[4]);
					theModel.getGameType(theView.getGameType()).setPlayer2(theModel.allPlayers[5]);
					theModel.setRound(4);
					theView.setPenatlyKicks(0);
				} else {
					theView.showErrorMessage("You cannot return to Round 1 if you started the next rounds");
				}
			}

		};

		EventHandler<ActionEvent> playGameEvent4 = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if (!theView.checkIfRound2Started()) {
					theView.playGame(theModel.allPlayers[6].getName(), theModel.allPlayers[7].getName());
					theModel.getGameType(theView.getGameType()).setPlayer1(theModel.allPlayers[6]);
					theModel.getGameType(theView.getGameType()).setPlayer2(theModel.allPlayers[7]);
					theModel.setRound(6);
//					theView.setPenatlyKicks(0);
				} else {
					theView.showErrorMessage("You cannot return to Round 1 if you started the next rounds");
				}
			}
		};

		EventHandler<ActionEvent> playGameEvent5 = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {

				if (!theView.checkIfRound1Ended()) {
					theView.showErrorMessage("you cannot start round 2 if you no finished round 1");
				} else if (theView.checkIfRound3Started()) {
					theView.showErrorMessage("You cannot return to Round 2 if you started the next rounds");
				} else {

					theView.playGame(theView.getBtWin1().getText(), theView.getBtWin2().getText());
					theModel.getGameType(theView.getGameType())
							.setPlayer1(theModel.searchPlayerByName(theView.getBtWin1().getText()));
					theModel.getGameType(theView.getGameType())
							.setPlayer2(theModel.searchPlayerByName(theView.getBtWin2().getText()));
					theModel.setRound(7);
					theView.setPenatlyKicks(0);
				}
			}
		};

		EventHandler<ActionEvent> playGameEvent6 = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if (!theView.checkIfRound1Ended()) {
					theView.showErrorMessage("you cannot start round 2 if you no finished round 1");
				} else if (theView.checkIfRound3Started()) {
					theView.showErrorMessage("You cannot return to Round 2 if you started the next rounds");
				} else {

					theView.playGame(theView.getBtWin3().getText(), theView.getBtWin4().getText());
					theModel.getGameType(theView.getGameType())
							.setPlayer1(theModel.searchPlayerByName(theView.getBtWin3().getText()));
					theModel.getGameType(theView.getGameType())
							.setPlayer2(theModel.searchPlayerByName(theView.getBtWin4().getText()));
					theModel.setRound(8);
					theView.setPenatlyKicks(0);
				}
			}
		};

		EventHandler<ActionEvent> playGameEvent7 = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if (theView.checkIfRound1Ended() && theView.checkIfRound2Ended()) {
					theView.playGame(theView.getBtWin5().getText(), theView.getBtWin6().getText());
					theModel.getGameType(theView.getGameType())
							.setPlayer1(theModel.searchPlayerByName(theView.getBtWin5().getText()));
					theModel.getGameType(theView.getGameType())
							.setPlayer2(theModel.searchPlayerByName(theView.getBtWin6().getText()));
					theModel.setRound(9);
					theView.setPenatlyKicks(0);
				} else {
					theView.showErrorMessage("You cannot start round 3 if you not completed the previous rounds");
				}
			}
		};

		EventHandler<ActionEvent> donePlay = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				int[] temp1 = new int[4];
				int[] temp2 = new int[4];
				try {
					for (int i = 0; i < theModel.getGameType(theView.getGameType()).getRounds(); i++) {
						if (theView.getResultPlayer1(i).getText().isEmpty()) {
							throw new Exception("Please enter a number");
						}
						temp1[i] = (Integer.parseInt(theView.getResultPlayer1(i).getText()));
						temp2[i] = (Integer.parseInt(theView.getResultPlayer2(i).getText()));
						if (temp1[i] < 0 || temp2[i] < 0) {
							throw new Exception("The result must be a positive number");
						}

					}
					String winner = theModel.returnWinnerName(theModel.getGameType(theView.getGameType()), temp1,
							temp2);
					if (winner == (null)) {
						theView.updateEqualityScene();
					} else {
						theView.updateWinner(winner, theModel.getRound());
						theView.closeGameStage();
					}
				} catch (InputMismatchException e) {
					theView.showErrorMessage("The results must be numbers");
					// theView.clearRsultTf();
				} catch (Exception e) {
					theView.showErrorMessage(e.getMessage());
					// theView.clearRsultTf();
				}

			}
		};

		EventHandler<ActionEvent> panetlyKick = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String winner = theModel.returnWinnerName(theView.howManyPentalyKicksPlayer1(),
						theView.howManyPentalyKicksPlayer2());
				theView.updateWinner(winner, theModel.getRound());
				if (winner == null)
					theView.updateEqualityScene();
				else
					theView.closeGameStage();
			}

		};

		theView.getBtAddPlayer().setOnAction(addParticipantEvent);
		theView.getBtStartGame().setOnAction(startChampionShipEvent);
		theView.getBtPlayGame1().setOnAction(playGameEvent1);
		theView.getBtPlayGame2().setOnAction(playGameEvent2);
		theView.getBtPlayGame3().setOnAction(playGameEvent3);
		theView.getBtPlayGame4().setOnAction(playGameEvent4);
		theView.getBtPlayGame5().setOnAction(playGameEvent5);
		theView.getBtPlayGame6().setOnAction(playGameEvent6);
		theView.getBtPlayGame7().setOnAction(playGameEvent7);
		theView.getBtDonePlay().setOnAction(donePlay);
		theView.getBtDonePlayKick().setOnAction(panetlyKick);
	}

}