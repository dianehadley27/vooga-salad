package gameplayer.view;

import java.util.ArrayList;
import java.util.List;

import gameplayer.model.Cell;
import gameplayer.model.Grid;
import gameplayer.model.Tower;
import gameplayer.view.helper.GraphicsLibrary;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * 
 * Responsible for creating the grid in which the towers and enemies are placed
 * 
 * @author lucyzhang
 *
 */
public class GridGUI {

	private Pane grid;
	public static final int GRID_WIDTH = 600;
	public static final int GRID_HEIGHT = 600;
	private double rows;
	private double cols;
	private double cellWidth;
	private double cellHeight;
	private GraphicsLibrary graphicsLib;
	private List<int[]> path;

	public static final String TEST_URL = "https://images.designtrends.com/wp-content/uploads/2016/03/30060819/Elegant-Night-Stay-Anime-Background.jpg"; // TODO:
																																							// dummy
																																							// url

	public GridGUI(int rows, int columns/*, List<int[]> path*/) {
		//System.out.println("Rows: "+rows+"; columns: "+columns);
		this.grid = new Pane();
		this.graphicsLib = new GraphicsLibrary();
		this.rows = rows;
		this.cols = columns;
		this.cellWidth = GRID_WIDTH / cols;
		this.cellHeight = GRID_HEIGHT / this.rows;
		//System.out.println("Cell width: "+cellWidth+", "+cellHeight);
		//this.path = path;
	}

	//for testing
	private void initDummyPath(){
		int[] stuff  = {0,0};
		int []stuff1 = {1,1};
		int []stuff2 = {2,2};
		int[] stuff3={3,3};
		int[] stuff4={4,4};
		this.path = new ArrayList<int[]>();
		this.path.add(stuff);
		this.path.add(stuff1);
		this.path.add(stuff2);
		this.path.add(stuff3);
		this.path.add(stuff4);
	}
	
	public void init(){
		initDummyPath(); //TODO: get rid of
		styleGrid(TEST_URL);
		populatePath(this.path);
		
	}
	public Pane getGrid() {
		return this.grid;
	}

	private void styleGrid(String terrainURL) {
		setTerrain(terrainURL);
		grid.getStyleClass().add("grid");
		grid.setMaxWidth(GRID_WIDTH);
		grid.setMaxHeight(GRID_HEIGHT);
	}

	private void setTerrain(String imageURL) {
		// Image background = graphicsLib.createImage("kaneki.jpg");
		// graphicsLib.createImageView(graphicsLib.createImage("kaneki.jpg"));

		// String image =
		// this.getClass().getResource("kaneki.jpg").toExternalForm();
		grid.setStyle("-fx-background-image: url('" + imageURL + "'); " + "-fx-background-position: center center; "
				+ "-fx-background-repeat: stretch;");
	}

	private void addTowerToGrid(Tower tower, int row, int col) {
		ImageView towerImage = graphicsLib.createImageView(graphicsLib.createImage(tower.getImage()));
		graphicsLib.setImageViewParams(towerImage, cellWidth * col, cellHeight * row, cellWidth, cellHeight);
		this.grid.getChildren().add(towerImage);
	}

	private void populatePath( List<int[]> path) { //TODO: change how path is being sent
		//System.out.println("Populate path!");
		for (int i = 0; i < path.size(); i++) {
			double x = path.get(i)[0];
			double y = path.get(i)[1];
			//System.out.println("X: "+x+", Y: "+y);
			ImageView pathImage = graphicsLib.createImageView(graphicsLib.createImage("kaneki.jpg"));
			//System.out.println("Path image: "+pathImage);
			graphicsLib.setImageViewParams(pathImage, x*cellWidth, y*cellHeight,cellWidth, cellHeight);
			//System.out.println("Image width and height: "+pathImage.getFitWidth()+","+pathImage.getFitHeight());
			this.grid.getChildren().add(pathImage);
			//pathImage.setX(x*cellWidth);
			//pathImage.setY(x*cellWidth);
			//pathImage.relocate(x*cellWidth, y*cellHeight);
			//System.out.println("path image coords: "+pathImage.getX()+", "+pathImage.getY());
		}
	}
	

	// TOWER AND PATH ONLY
	public void populateGrid(Grid grid) {
		//populatePath(grid, gri)
		/*
		Cell[][] gridArr = grid.getGrid();
		for (int row = 0; row < gridArr.length; row++) {
			for (int col = 0; col < gridArr[row].length; col++) {

			}
		}
		*/
	}

}