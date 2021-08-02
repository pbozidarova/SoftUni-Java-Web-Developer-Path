package OOP04_InterfacesAndAbstraction.e6_Military_Elite.factories;

import OOP04_InterfacesAndAbstraction.e6_Military_Elite.army.*;
import OOP04_InterfacesAndAbstraction.e6_Military_Elite.army.enums.Corps;
import OOP04_InterfacesAndAbstraction.e6_Military_Elite.army.enums.State;
import OOP04_InterfacesAndAbstraction.e6_Military_Elite.army.helperClasses.MissionImpl;
import OOP04_InterfacesAndAbstraction.e6_Military_Elite.army.helperClasses.RepairImpl;
import OOP04_InterfacesAndAbstraction.e6_Military_Elite.army.helperClasses.interfaces.Mission;
import OOP04_InterfacesAndAbstraction.e6_Military_Elite.army.helperClasses.interfaces.Repair;
import OOP04_InterfacesAndAbstraction.e6_Military_Elite.army.interfaces.*;

import java.util.List;

public class SoldierFactory {

    public static Soldier producePrivate(List<String> args) {
        return new PrivateImpl(Integer.parseInt(args.get(0)),
                args.get(1),
                args.get(2),
                Double.parseDouble(args.get(3))
        );
    }

    public static Soldier produceLieutenantGeneral(List<String> args, List<Soldier> soldiers) {
        LieutenantGeneral general = new LieutenantGeneralImpl(Integer.parseInt(args.get(0)),
                args.get(1),
                args.get(2),
                Double.parseDouble(args.get(3))
        );

        for (int i = 4; i < args.size(); i++) {
            int id = Integer.parseInt(args.get(i));
            for (int j = 0; j < soldiers.size(); j++) {
                if (soldiers.get(j).getId() == id) {
                    general.addPrivate((Private) soldiers.get(j));
                }
            }
        }
        return (Soldier) general;
    }

    public static Soldier produceEngineer(List<String> args) {
        Engineer engineer = new EngineerImpl(Integer.parseInt(args.get(0)),
                args.get(1),
                args.get(2),
                Double.parseDouble(args.get(3)),
                Corps.valueOf(args.get(4))
        );

        for (int i = 5; i < args.size(); i += 2) {
            Repair repair = new RepairImpl(args.get(i), Integer.parseInt(args.get(i + 1)));
            engineer.addRepair(repair);
        }

        return (Soldier) engineer;

    }

    public static Soldier produceCommando(List<String> args) {
        Commando commando = new CommandoImpl(Integer.parseInt(args.get(0)),
                args.get(1),
                args.get(2),
                Double.parseDouble(args.get(3)),
                Corps.valueOf(args.get(4))
        );

        for (int i = 5; i < args.size(); i += 2) {
            if(args.get(i+1).equals("inProgress") || args.get(i+1).equals("Finished")) {
                Mission mission = new MissionImpl(args.get(i), State.valueOf(args.get(i + 1)));
                commando.addMission(mission);
            }

        }

        return (Soldier) commando;

    }

    public static Soldier produceSpy(List<String> args) {
        return new SpyImpl(Integer.parseInt(args.get(0)),
                args.get(1),
                args.get(2),
                args.get(3)
        );
    }
}
