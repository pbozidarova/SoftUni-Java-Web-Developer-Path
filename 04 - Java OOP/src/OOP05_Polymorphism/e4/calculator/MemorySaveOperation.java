package OOP05_Polymorphism.e4.calculator;

import java.util.Deque;

public class MemorySaveOperation implements Operation {
    private Deque<Integer> memory;

    public MemorySaveOperation(Deque<Integer> memory){
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
        this.memory.push(operand);
    }

    @Override
    public int getResult() {
        return this.memory.peek();
    }

    @Override
    public boolean isCompleted() {
        return false;
    }
}
