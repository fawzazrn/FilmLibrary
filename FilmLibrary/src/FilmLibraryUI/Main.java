package FilmLibraryUI;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static Stage ps;
	Scene scene1, scene2;
	
	@FXML
	Button addbutton;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		ps = primaryStage;
		
		AnchorPane root1 = (AnchorPane) FXMLLoader.load(getClass().getResource("/FilmLibraryUI/View.fxml"));
		
		//scene1
		Platform.setImplicitExit(false);
		scene1 = new Scene(root1);
		
		//scene 2
		//AnchorPane root2 = (AnchorPane) FXMLLoader.load(getClass().getResource("/FilmLibraryUI/View2.fxml"));
		//scene2 = new Scene(root2);
		
		ps.setScene(scene1);
		ps.setResizable(false);
		ps.setTitle("Film Library");
		ps.show();
	
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
