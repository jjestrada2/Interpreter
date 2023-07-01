package interpreter.bytecodes;

import interpreter.Interpreter;
import interpreter.virtualmachine.VirtualMachine;

public class StoreCode extends ByteCode {
    private int offset;
    private String identifier;
    public StoreCode(String[] args) {
        this.offset = Integer.parseInt(args[1]);
        if(args.length == 3){
            this.identifier = args[3];
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.store(offset);
    }

    @Override
    public String toString() {
        String base = "STORE" + this.offset;
        if(this.identifier != null){
            base += this.identifier;
        }
        return base;
    }
}
