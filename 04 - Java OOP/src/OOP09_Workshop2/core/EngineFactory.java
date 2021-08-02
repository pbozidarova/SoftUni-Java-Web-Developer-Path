package OOP09_Workshop2.core;

import OOP09_Workshop2.exeptions.ArgumentException;
import OOP09_Workshop2.models.Engine;

public interface EngineFactory {
    Engine produce(String[] args) throws ArgumentException;

}
