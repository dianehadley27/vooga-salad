package gameplayer.main;
import gameplayer.controller.GamePlayerController;
import gameplayer.view.GameGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {

	public static final String TITLE = "VOOGASquad";
	private Stage stage;

	
	public Stage getStage(){
		return stage;
	}

	@Override
	public void start(Stage s){
		this.stage = s;
		//This is just for testing, should be switched to creating the authoring environment first
<<<<<<< HEAD
		GameGUI game = new GameGUI(50,50); //TODO: dummy number of rows and columns

		//GamePlayerController playerController = new GamePlayerController(game);
		Scene scene = game.init(10,11,12);
=======
		GameGUI game = new GameGUI(); 
		GamePlayerController playerController = new GamePlayerController(game);
                Scene scene = game.init(10,11,12);
>>>>>>> 935d382387753142b59cf15423ef3b296acfa9c0
		s.setTitle(TITLE);
		s.setScene(scene);
		s.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
