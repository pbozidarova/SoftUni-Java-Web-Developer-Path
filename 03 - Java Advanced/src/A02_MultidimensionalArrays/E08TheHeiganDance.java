package A02_MultidimensionalArrays;

import java.util.Scanner;

public class E08TheHeiganDance {
//    At last, level 80. And what do level eighties do? Go raiding. This is where you are now – trying not to be wiped
//    by the famous dance boss, Heigan the Unclean. The fight is pretty straightforward - dance around the Plague
//    Clouds and Eruptions, and you’ll be just fine.

//    Heigan’s chamber is a 15-by-15 two-dimensional array. The player always starts at the exact center.
//    For each turn, Heigan uses a spell that hits a certain cell and the neighboring rows/columns.
//    For example, if he hits (1,1), he also hits (0,0, 0,1, 0,2, 1,0 … 2,2). If the player’s current position
//    is within the area of damage, the player tries to move. First, he tries to move up, if there’s damage/wall,
//    he tries to move right, then down, then left. If he cannot move in any direction, because the cell is damaged
//    or there is a wall, the player stays in place and takes the damage.

//    Plague cloud does 3500 damage when it hits, and 3500 damage the next turn. Then it expires. Eruption does
//    6000 damage when it hits. If a spell hits a player that also has an active Plague Cloud from the previous turn,
//    the cloud damage is applied first. Both Heigan and the player may die in the same turn. If Heigan is dead,
//    the spell he would have casted is ignored.

//    The player always starts at 18500 hit points; Heigan starts at 3,000,000 hit points. Each turn, the player
//    does damage to Heigan. The fight is over either when the player is killed, or Heigan is defeated.

    private static int[][] filed = new int[15][15];
    private static int playerRow = 7;
    private static int playerCol = 7;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double damage = Double.parseDouble(scanner.nextLine());
        double playHealth = 18500;
        double boosHealth = 3000000;

        boolean shouldTakeDamage = false;

        String lastCastedSpell = "";

        while (playHealth > 0 && boosHealth > 0){
            boosHealth -= damage;

            if(shouldTakeDamage) {
                playHealth -= 3500;
                shouldTakeDamage = false;
            }

            if(playHealth < 0 || boosHealth < 0){
                break;
            }

            String[] tokens = scanner.nextLine().split("\\s+");

            String spell = tokens[0];
            int targetRow = Integer.parseInt(tokens[1]);
            int targetCol = Integer.parseInt(tokens[2]);

            boolean isHit = checkCell(targetRow, targetCol);

            if(isHit && boosHealth > 0){
                boolean hasMoved = movePlayer(targetRow, targetCol);

                if (!hasMoved) {
                    if(spell.equals("Cloud")){
                        playHealth -= 3500;
                        shouldTakeDamage = true;
                    }else {
                        playHealth -= 6000;
                    }

                    lastCastedSpell = spell;
                }
            }
        }
        if(boosHealth <= 0){
            System.out.println("Heigan: Defeated!");
        }else {
            System.out.println( String.format("Heigan: %.2f", boosHealth));
        }

        if(playHealth <= 0){
            System.out.println("Player: Killed by " + lastCastedSpell);
        }else {
            System.out.println(String.format("Player: %.0f", playHealth));
        }

        System.out.printf("Final position %d, %d", playerRow, playerCol);
    }

    private static boolean movePlayer(int targetRow, int targetCol) {
        //up, right, down, left

        if(targetRow == playerRow && targetCol == playerCol) return false;

        boolean hasMoved = false;
        if(isInRange(playerRow -1, playerCol) && canMove(targetRow, targetCol, playerRow-1, playerCol)){
            playerRow--;
            hasMoved = true;
        }else if(isInRange(playerRow, playerCol + 1) && canMove(targetRow, targetCol, playerRow, playerCol + 1)) {
            playerCol++;
            hasMoved = true;
        }else if(isInRange(playerRow + 1, playerCol) && canMove(targetRow, targetCol, playerRow + 1, playerCol)) {
            playerRow++;
            hasMoved = true;
        }else if(isInRange(playerRow, playerCol - 1) && canMove(targetRow, targetCol, playerRow, playerCol - 1)) {
            playerCol--;
            hasMoved = true;
        }

            return hasMoved;

    }

    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < 15 && c >= 0 && c < 15;
    }

    private static boolean canMove(int targetRow, int targetCol, int newRow, int newCol) {
        return !(newRow < targetRow - 1 && newRow > targetRow +1
                && newCol < targetCol - 1 && newCol > targetCol + 1);

    }

    private static boolean checkCell(int targetRow, int targetCol) {
        return playerRow >= targetRow - 1 && playerRow <= targetRow +1
                && playerCol >= targetCol - 1 && playerCol <= targetCol + 1;


    }
}
