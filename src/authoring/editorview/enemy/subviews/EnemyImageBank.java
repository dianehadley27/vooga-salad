package authoring.editorview.enemy.subviews;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import authoring.editorview.PhotoFileChooser;
import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.ButtonFactory;
import authoring.utilityfactories.DialogueBoxFactory;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EnemyImageBank extends PhotoFileChooser {

    private EnemyEditorViewDelegate delegate;
    private ScrollPane enemyBank;
    private VBox vbox;
    private File chosenFile;

    public EnemyImageBank (ResourceBundle labelsResource, ResourceBundle dialogueBoxResource) {
        enemyBank = new ScrollPane();
        Button createNewEnemy =
                ButtonFactory.makeButton(labelsResource.getString("NewEnemy"),
                                         e -> {
                                             try {
                                                 selectFile(labelsResource.getString("Photos"),
                                                            labelsResource.getString("Image"));
                                             }
                                             catch (IOException e1) {
                                                 DialogueBoxFactory
                                                         .createErrorDialogueBox(dialogueBoxResource
                                                                 .getString("UnableToOpen"),
                                                                                 dialogueBoxResource
                                                                                         .getString("TryAgain"));
                                             }
                                         });
        vbox = BoxFactory.createVBox(labelsResource.getString("EnemyBank"));
        vbox.getChildren().add(createNewEnemy);
        enemyBank.setContent(vbox);
    }

    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public Node getInstanceAsNode () {
        return enemyBank;
    }

    public void updateEnemyBank (List<Integer> activeEnemies) {
        // update each enemy in bank
    }

    @Override
    public void openFileChooser (FileChooser chooseFile) throws IOException {
        chosenFile = chooseFile.showOpenDialog(new Stage());
        if (chosenFile != null) {
            // give this image an id, keep it in bank
            BufferedImage imageRead;
            ImageView imageView = new ImageView();
            try {
                imageRead = ImageIO.read(chosenFile);
                Image image2 = SwingFXUtils.toFXImage(imageRead, null);
                imageView.setImage(image2);
                // enemyBank.setContent(imageView);
                // TODO: These should be correct but are erring out currently
                // delegate.onUserPressedCreateEnemy();
                // delegate.onUserEnteredEnemyImage(chosenFile.toURI().toString());
            }
            catch (Exception e) {
                System.out.println("You failed");
                imageRead =
                        ImageIO.read(getClass().getClassLoader()
                                .getResourceAsStream("butterfly.png"));
                Image image2 = SwingFXUtils.toFXImage(imageRead, null);
                imageView.setImage(image2);
                // TODO: Fix this output to be better for the user
            }
        }
    }

}
