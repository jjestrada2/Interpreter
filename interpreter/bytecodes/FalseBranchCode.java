package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class FalseBranchCode extends ByteCode {
    private String label;
    private int address;
    public FalseBranchCode(String[] args) {
        this.label = args[1];
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    @Override
    public void execute(VirtualMachine vm) {
        if(vm.runStackPop() == 0){
            vm.setPc(this.address);
        }
    }

    @Override
    public String toString() {
        return "FALSEBRANCH "+ this.label +" "+this.address;
    }
}
