package OOP04_InterfacesAndAbstraction.e6_Military_Elite.commands;

import L4_Interfaces_And_Abstractions.e6_Military_Elite.army.interfaces.Soldier;
import L4_Interfaces_And_Abstractions.e6_Military_Elite.factories.SoldierFactory;

import java.util.List;

public class PrivateCommand extends BaseCommand {

    public PrivateCommand(List<Soldier> soldiers) {
        super(soldiers);
    }

    @Override
    public void execute(List<String> args) {
        super.add(SoldierFactory.producePrivate(args));
    }
}
