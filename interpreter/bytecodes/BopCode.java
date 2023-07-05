package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class BopCode extends ByteCode {
    private String operand;
    private int leftNum;
    private int rightNum;

    public BopCode(String[] args) {
        this.operand = args[1];
    }

    @Override
    public void execute(VirtualMachine vm) {
        int rightNum = vm.popRunTimeStack();
        int leftNum = vm.popRunTimeStack();
        switch (operand){
            case "+" -> vm.push(leftNum + rightNum);
            case "-" ->vm.push(leftNum - rightNum);
            case "/" ->vm.push(leftNum / rightNum);
            case "*" ->vm.push(leftNum * rightNum);
            case "==" -> {
                if (leftNum == rightNum) {
                    vm.push(1);
                } else {
                    vm.push(0);
                }
            }
            case "!=" -> {
                if (leftNum != rightNum) {
                    vm.push(1);
                } else {
                    vm.push(0);
                }
            }
            case "<=" ->{
                if (leftNum <= rightNum) {
                    vm.push(1);
                } else {
                    vm.push(0);
                }
            }
            case ">=" ->{
                if (leftNum >= rightNum) {
                    vm.push(1);
                } else {
                    vm.push(0);
                }
            }
            case "&" ->{
                if (leftNum == 1 && rightNum == 1) {
                    vm.push(1);
                } else {
                    vm.push(0);
                }
            }
            case ">" ->{
                if (leftNum > rightNum) {
                    vm.push(1);
                } else {
                    vm.push(0);
                }
            }
            case "<" ->{

                if (leftNum < rightNum) {
                    vm.push(1);
                } else {
                    vm.push(0);
                }
            }
            case "|" ->{
                if (leftNum == 1 || rightNum == 1) {
                    vm.push(1);
                } else {
                    vm.push(0);
                }
            }
            default -> System.out.println("Invalid Operand");
        }
    }

    @Override
    public String toString() {
        return "BOP" + this.operand;
    }
}
