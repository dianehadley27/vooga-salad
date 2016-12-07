package engine.level;

import engine.TypeInitializer;
import engine.level.wave.Wave;
import engine.level.wave.WaveType;
import engine.observer.ObservableMap;
import engine.observer.ObservableProperty;


public interface LevelInitializer extends TypeInitializer {
    ObservableMap<Integer, Wave> getWaves ();

    ObservableProperty<Double> getRewardHealth ();

    ObservableProperty<Double> getRewardMoney ();

    ObservableProperty<Double> getRewardScore ();

    ObservableProperty<Double> getDurationInSeconds ();
    
    ObservableProperty<Double> getLevelTime ();
}
