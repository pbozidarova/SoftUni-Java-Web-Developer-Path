package OOP05_Polymorphism.e4.calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class InputInterpreter {
    private CalculationEngine engine;
    Deque<Integer> memory = new ArrayDeque<>();

    public InputInterpreter(CalculationEngine engine){
        this.engine = engine;
    }

    public boolean interpret(String input) {
        try {
            engine.pushNumber(Integer.parseInt(input));
        }catch (Exception ex){
            engine.pushOperation(this.getOperation(input));
        }
        return true;
    }
    public Operation getOperation(String operation) {

        if (operation.equals("*")) {
            return new MultiplicationOperation();
        } else if(operation.equals("/")){
            return new DivisionOperation();
        }else if(operation.equals("ms")){
            return new MemorySaveOperation(memory);
        }else if(operation.equals("mr")){
            return new MemoryRecallOperation(memory);
        }

        return null;
    }
}
