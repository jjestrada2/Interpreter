package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class CallCode extends ByteCode {

    private String label;
    private int address;
    public CallCode(String[] args) {
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
        vm.returnAddressPush(vm.getPc());
        vm.setPc(this.address);

    }

    @Override
    public String toString() {
        return "CALL " + this.label+" "+this.address;
    }
}
