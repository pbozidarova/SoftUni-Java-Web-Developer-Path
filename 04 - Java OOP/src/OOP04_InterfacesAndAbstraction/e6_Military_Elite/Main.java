package OOP04_InterfacesAndAbstraction.e6_Military_Elite;

import L4_Interfaces_And_Abstractions.e6_Military_Elite.army.interfaces.Soldier;
import L4_Interfaces_And_Abstractions.e6_Military_Elite.commands.*;
import L4_Interfaces_And_Abstractions.e6_Military_Elite.commands.interfaces.Command;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Command> commands = new HashMap<>();
        List<Soldier> soldiers = new ArrayList<>();
        commands.put("Private", new PrivateCommand(soldiers));
        commands.put("LeutenantGeneral", new LieutenantGeneralCommand(soldiers));
        commands.put("Engineer", new EngineerCommand(soldiers));
        commands.put("Commando", new CommandoCommand(soldiers));
        commands.put("Spy", new SpyCommand(soldiers));

        while (!input.equals("End")) {
            String command = input.substring(0, input.indexOf(" "));

            try {
                commands.get(command).execute(
                        Arrays.stream(input.split("\\s+"))
                                .skip(1)
                                .collect(Collectors.toList())
                );
            } catch (Exception ex) {

            }
            input = scanner.nextLine();
        }

        for (Soldier soldier : soldiers) {
            System.out.println(soldier.toString());

        }

    }
}