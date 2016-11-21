package authoring.editorview.weapon.subviews;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class WeaponImageBank {

    // TODO: I want to be able to load in a default weapon with default settings from model
    // What is our current plan with defaults?

    private File chosenFile;
    private ScrollPane weaponBank;
    private Map<Integer, ImageIcon> activeWeapons;
    private ImageIcon imageView;

    public WeaponImageBank () {
        Button createWeaponButton = createButton("Create Weapon", e -> selectFile("Photos: "));
        weaponBank.setContent(createWeaponButton);
    }

    public Map<Integer, ImageIcon> getMyWeapons () {
        return activeWeapons;
    }
    
    private Button createButton(String label, EventHandler<ActionEvent> event) {
        Button button = new Button(label);
        button.setOnAction(event);
        return button;
    }

    private void openFileChooser (FileChooser chooseFile) {
        chosenFile = chooseFile.showOpenDialog(new Stage());
        if (chosenFile != null) {
            // give this image an id, keep it in bank
            BufferedImage image;
            try {
                image = ImageIO.read(chosenFile);
                imageView = new ImageIcon(image);
            }
            catch (Exception e) {
                System.out.println("Unable to load photo");
                // TODO: Fix this output to be better for the user
            }
        }
    }

    private void selectFile (String fieldText) {
        FileChooser choose = new FileChooser();
        choose.setTitle("Load New Weapon to Editor");
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter(fieldText, "*.png", "*.jpg", "*.gif");
        choose.getExtensionFilters().add(extFilter);
        openFileChooser(choose);
    }

    public Node getInstanceAsNode () {
        return weaponBank;
    }

}