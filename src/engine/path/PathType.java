package engine.path;

import engine.AbstractType;
import engine.TypeInitializer;
import engine.observer.ObservableProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathType extends AbstractType implements Path {

    private ObservableProperty<String> type;
    private ObservableProperty<List<Coordinate<Integer>>> coordinates;    

    protected PathType (PathInitializer pathInitializer) {
        super(pathInitializer);
        this.type = pathInitializer.getType();
        this.coordinates = pathInitializer.getCoordinates();
    }
    
    @Override
    public String getType () {
        return type.getProperty();
    }

    @Override
    public void setType (String type) {
        this.type.setProperty(type);
    }

    @Override
    public void addCoordinate(Coordinate<Integer> coordinate) {
        coordinates.getProperty().add(coordinate);
    }
    
    @Override
    public void removeCoordinate(Coordinate<Integer> coordinate) {
        coordinates.getProperty().remove(coordinate);
    }
    
    @Override
    public List<Coordinate<Integer>> getCoordinates () {
        return Collections.unmodifiableList(coordinates.getProperty());
    }
    
}