package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode{

    private int numOfArgs;

    ArgsCode(String []args){
        this.numOfArgs = Integer.parseInt(args[1]);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushToFramePntrStck(this.numOfArgs);

    }

    @Override
    public String toString() {
        return "ARGS" + this.numOfArgs;
    }
}
