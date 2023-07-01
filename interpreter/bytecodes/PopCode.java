package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class PopCode extends ByteCode {

    private int numOfPops;
    public PopCode(String[] args) {
        this.numOfPops = Integer.parseInt(args[1]);
    }

    @Override
    public void execute(VirtualMachine vm) {
        int frameSize = vm.frameSize();

        for(int i = 0;i < numOfPops && i < frameSize; i++){
            vm.popRunTimeStack();
        }

    }

    @Override
    public String toString() {
        return "POP " + numOfPops;
    }
}
