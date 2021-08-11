package Program;

import javafx.application.Application;
import javafx.stage.Stage;
import Controller.Controller;
import Model.Model;
import View.View;

public class Program extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Model model = new Model();
		View theView = new View(primaryStage);
		Controller TheController = new Controller(model, theView);

	}
}
