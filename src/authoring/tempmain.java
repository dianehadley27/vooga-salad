package authoring;

import java.io.IOException;
import java.util.HashMap;

import authoring.editorview.EditorViewController;
import authoring.editorview.enemy.EnemyEditorViewController;
import authoring.editorview.level.LevelEditorViewController;
import authoring.editorview.path.PathEditorViewController;
import authoring.editorview.tower.TowerEditorViewController;
import authoring.editorview.weapon.WeaponEditorViewController;
import authoring.view.AuthoringViewController;
import authoring.view.IAuthoringView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import engine.*;
import engine.weapon.*;
import engine.tower.*;
import engine.ability.*;
import engine.enemy.*;
import engine.path.*;
import engine.level.*;
import engine.settings.*;

public class tempmain extends Application {

    public static final String TITLE = "VOOGASquad";
    private static final int SIZE = 700;

    
    @Override
    public void start (Stage s) throws IOException {
    	
    	ManagerTypeMediator mainMediator = new ManagerTypeMediator();
    	
        AuthoringViewController mainVC = new AuthoringViewController(SIZE, SIZE);
        IAuthoringView mainView = mainVC.getView();
        
    	this.createManagersAndControllers(mainMediator, mainVC);
        
        Scene scene = mainView.getScene();
        s.setTitle(TITLE);
        s.setScene(scene);
        s.setResizable(true);
        s.setHeight(SIZE);
        s.setWidth(SIZE + 145);
        s.show();
        
    }

    private void createManagersAndControllers(ManagerTypeMediator mainMediator, AuthoringViewController authoringVC) {
		TowerManager tower = new TowerTypeManager();
		WeaponManager weapon = new WeaponTypeManager();
		PathManager path = new PathTypeManager();
		EnemyManager enemy = new EnemyTypeManager();
		LevelManager level = new LevelTypeManager();
		AbilityManager ability = new AbilityTypeManager();
		GameModeManager gameMode = new GameModeTypeManager();
		mainMediator.addManager(tower);
		mainMediator.addManager(weapon);
		mainMediator.addManager(path);
		mainMediator.addManager(level);
		mainMediator.addManager(enemy);
		mainMediator.addManager(ability);
		mainMediator.addManager(gameMode);
		
		TowerManagerController towerController = new TowerTypeManagerController(tower);
		WeaponManagerController weaponController = new WeaponTypeManagerController(weapon);
		PathManagerController pathController = new PathTypeManagerController(path);
		EnemyManagerController enemyController = new EnemyTypeManagerController(enemy);
		LevelManagerController levelController = new LevelTypeManagerController(level);
		AbilityManagerController abilityController = new AbilityTypeManagerController(ability);
		GameModeManagerController gameModeController = new GameModeTypeManagerController(gameMode);

		HashMap<String, EditorViewController> editorVCs = authoringVC.getControllers();
		PathEditorViewController pathVC = (PathEditorViewController) editorVCs.get("path");
		LevelEditorViewController levelVC = (LevelEditorViewController) editorVCs.get("level");
		WeaponEditorViewController weaponVC = (WeaponEditorViewController) editorVCs.get("weapon");
		EnemyEditorViewController enemyVC = (EnemyEditorViewController) editorVCs.get("enemy");
		TowerEditorViewController towerVC = (TowerEditorViewController) editorVCs.get("tower");
		
		pathVC.setPathDataSource(pathController);
		levelVC.setLevelDataSource(levelController);
		weaponVC.setWeaponDataSource(weaponController);
		enemyVC.setEnemyDataSource(enemyController);
		towerVC.setTowerDataSource(towerController);
		
	}

	public static void main (String[] args) {
        launch(args);
    }

}
