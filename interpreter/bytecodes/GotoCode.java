package interpreter.bytecodes;

import interpreter.virtualmachine.Program;
import interpreter.virtualmachine.VirtualMachine;

public  class GotoCode extends ByteCode{

    private String label;
    private int address;
    GotoCode(String []args){
        this.label = args[1];
    }

    public int getAddress() {
        return address;
    }
    public void setAddress(int address){
        this.address = address;
    }

    public String getLabel(){
        return this.label;
    }

    public void setLabel(String label){
        this.label = label;
    }
    @Override
    public void execute(VirtualMachine vm) {
        vm.setPc(this.address);

    }

    @Override
    public String toString() {
        return "GOTO" + this.label;

    }
}
