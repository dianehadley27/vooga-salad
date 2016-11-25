package authoring.editorview.path.subviews;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import authoring.editorview.PhotoFileChooser;
import authoring.editorview.path.PathEditorViewDelegate;
import authoring.utilityfactories.ButtonFactory;
import authoring.utilityfactories.DialogueBoxFactory;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

//TODO: Combine with BackgroundImageView to reduce duplicated code


public class PathImageView extends PhotoFileChooser{

	private HBox root;
	private String pathImagePath;
	private ImageView pathImageView;
	private PathEditorViewDelegate delegate;
	
	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringPath";	
	private ResourceBundle pathResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	private static final String DEFAULT_IMAGE_FILE_NAME = "blacksquare.png";
	
	public PathImageView(){
		root = new HBox(10);
		makeChooseImageButton();
		formatPathImageView();
		addPathImageView();
	}
	
	public Node getInstanceAsNode(){		
		return root;
		
	}
	
	private void formatPathImageView() {
		pathImageView = new ImageView();
		pathImageView.setFitHeight(100);
		pathImageView.setFitWidth(100);
	}	
	
	private void addPathImageView() {
		if (root.getChildren().contains(pathImageView)){
			root.getChildren().remove(pathImageView);
		}
		pathImageView = loadPathImage();
		root.getChildren().add(pathImageView);
	}
	
	private void makeChooseImageButton(){
		Button setPathImageButton = ButtonFactory.makeButton(pathResource.getString("PathImageButton"), 
				e -> selectFile("Photos: ", "Select new path image"));
		root.getChildren().add(setPathImageButton);
	}

	@Override
	public void openFileChooser(FileChooser chooseFile) {
		File chosenFile = chooseFile.showOpenDialog(new Stage());
		if (chosenFile != null){
			try {
				BufferedImage image = ImageIO.read(chosenFile) ;
				pathImagePath = chosenFile.getPath();
				addPathImageView();
				
			}
			catch(Exception e){
				Alert errorDialogueBox = DialogueBoxFactory.displayErrorDialogueBox("Invalid File", "Error With File");
				errorDialogueBox.show();
			}
		}
	}
	
	
	public String getPathImagePath(){
		return pathImagePath;
	}
	
	public void setDelegate(PathEditorViewDelegate delegate){
		this.delegate = delegate;
	}


	private ImageView loadPathImage() {	
		try {
			Image image = new Image(pathImagePath);
			pathImageView.setImage(image);
			delegate.onUserEnteredBackgroundImage(pathImagePath);			
		}
		catch (Exception e){
			Image defaultImage = new Image(getClass().getClassLoader().getResourceAsStream(DEFAULT_IMAGE_FILE_NAME));
			pathImageView.setImage(defaultImage);	
		}		
		return pathImageView;
		
	}
	
	
}
