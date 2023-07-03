package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class DumpCode extends ByteCode {

    private boolean dumpOn;

    public DumpCode(String[] args) {
        if(args[1] == "ON"){
            this.dumpOn = true;
        }else{
            this.dumpOn = false;
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setDumpOn(dumpOn);
    }

    @Override
    public String toString() {
        return "DUMP";
    }
}
