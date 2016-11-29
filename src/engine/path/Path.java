package engine.path;

import java.util.List;
import engine.Type;


public interface Path extends Type {

    String getType ();

    void setType (String type);

    void addCoordinate (Coordinate<Integer> coordinate);

    void removeCoordinate (Coordinate<Integer> coordinate);

    List<Coordinate<Integer>> getCoordinates ();

}