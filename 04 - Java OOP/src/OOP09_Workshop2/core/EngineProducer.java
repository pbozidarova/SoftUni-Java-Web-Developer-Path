package OOP09_Workshop2.core;

import OOP09_Workshop2.exeptions.ArgumentException;
import OOP09_Workshop2.models.Engine;
import OOP09_Workshop2.models.Jet;
import OOP09_Workshop2.models.Sterndrive;

public class EngineProducer implements EngineFactory{


    @Override
    public Engine produce(String[] args) throws ArgumentException {
        String type = args[args.length -1];

        String model = args[1];
        int hp = Integer.parseInt(args[2]);
        int dis = Integer.parseInt(args[3]);
        Engine engine = null;

        switch (type){
            case "Jet":
                engine = new Jet(model, hp, dis);
                break;
            case "Sterndrive":
                engine = new Sterndrive(model, hp, dis);
                break;
        }

        return engine;
    }
}
