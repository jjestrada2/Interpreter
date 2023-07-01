package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public  class GotoCode extends ByteCode{

    private String label;
    GotoCode(String []args){
        this.label = args[2];
    }

    @Override
    public void execute(VirtualMachine vm) {

    }

    @Override
    public String toString() {
        return null;
    }
}
