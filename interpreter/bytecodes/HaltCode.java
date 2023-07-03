package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class HaltCode extends ByteCode{

    public HaltCode(String args[]){

    }
    @Override
    public void execute(VirtualMachine vm) {
        vm.toggleRunning();

    }

    @Override
    public String toString() {
        return "HALT";
    }
}
