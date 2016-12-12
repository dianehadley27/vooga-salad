package authoring.editorview.path.subviews.editorfields;

import authoring.editorview.path.IPathSetView;
import authoring.editorview.path.PathAuthoringViewDelegate;
import authoring.utilityfactories.ComboBoxFactory;
import authoring.utilityfactories.GridFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

public class PathTypeView implements IPathSetView {
	
	//TODO inheritance
	
	private ObservableList<Object> pathTypeList;
	private ComboBox<Object> pathTypeComboBox;
	private GridPane root;
	
	private PathAuthoringViewDelegate delegate;
	
	public PathTypeView(){
		makeComboBox();
	}
	
	private void makeComboBox(){
		
		pathTypeList = FXCollections.observableArrayList();
		pathTypeList.addAll("Free", "Set");
		pathTypeComboBox = ComboBoxFactory.makeComboBox("" , 
				e -> delegate.onUserEnteredPathType(pathTypeComboBox.getValue().toString()), pathTypeList);
		pathTypeComboBox.setPrefWidth(155); //TODO
		root = GridFactory.createRowWithLabelandNode("Path type: ", pathTypeComboBox);
		
	}
	
	public Node getInstanceAsNode(){
		return root;
	}

	private void setEditView(String string) {
		
	}

	@Override
	public void setDelegate(PathAuthoringViewDelegate delegate) {
		this.delegate = delegate;
		
	}
	
	public void updatePathType(String pathType){
		pathTypeComboBox.setValue(pathType);
		setEditView(pathType);
		
	}

}
