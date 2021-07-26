package A06_DefiningClasses.l03BankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        String line;
        Map<Integer, BankAccount> bankAccountMap = new HashMap<>();

        while (!"End".equals(line = reader.readLine())){
            String[] tokens = line.split("\\s+");

            switch (tokens.length){
                case 1:
                    BankAccount bankAccount = new BankAccount();
                    bankAccountMap.put(bankAccount.getId(), bankAccount);
                    System.out.println(String.format("Account ID%d created", bankAccount.getId()));
                    break;
                case 2:
                    double rate = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(rate);
                    break;
                case 3:
                    int id = Integer.parseInt(tokens[1]);

                    if(!bankAccountMap.containsKey(id)){
                        System.out.println("Account does not exist");
                    }else {

                        BankAccount bk1 = bankAccountMap.get(id);
                        if("Deposit".equalsIgnoreCase(tokens[0])){
                            double amount = Double.parseDouble(tokens[2]);
                            bk1.deposit(amount);
                            System.out.println(String.format("Deposited %.0f to ID%d", amount, id));
                        }else {
                            int years = Integer.parseInt(tokens[2]);
                            System.out.println(String.format("%.2f", bk1.getInterest(years)));
                        }
                    }

                    break;
            }
        }
    }
}
