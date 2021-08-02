package OOP09_Workshop2.core;

import L10_Workshop_2.exeptions.ArgumentException;
import L10_Workshop_2.models.Engine;

public interface EngineFactory {
    Engine produce(String[] args) throws ArgumentException;

}
