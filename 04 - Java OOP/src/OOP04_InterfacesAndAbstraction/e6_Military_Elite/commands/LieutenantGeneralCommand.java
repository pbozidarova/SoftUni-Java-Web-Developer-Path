package OOP04_InterfacesAndAbstraction.e6_Military_Elite.commands;

import OOP04_InterfacesAndAbstraction.e6_Military_Elite.army.interfaces.Soldier;
import OOP04_InterfacesAndAbstraction.e6_Military_Elite.factories.SoldierFactory;

import java.util.List;

public class LieutenantGeneralCommand extends BaseCommand {

    public LieutenantGeneralCommand(List<Soldier> soldiers) {
        super(soldiers);
    }

    @Override
    public void execute(List<String> args) {
        super.add(SoldierFactory.produceLieutenantGeneral(args, this.getSoldier()));
    }
}
