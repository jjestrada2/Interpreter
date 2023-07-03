package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class ReturnCode extends ByteCode {
    public ReturnCode(String[] args) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.runStackPopFrame();
        vm.setPc(vm.returnAddressPop());
    }

    @Override
    public String toString() {
        return "RETURN";
    }
}
