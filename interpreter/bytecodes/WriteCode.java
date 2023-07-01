package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class WriteCode extends ByteCode {
    public WriteCode(String[] args) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.printTopRunTimeStack();
    }

    @Override
    public String toString() {
        return "WRITE";
    }
}
