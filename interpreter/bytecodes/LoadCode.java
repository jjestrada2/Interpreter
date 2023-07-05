package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class LoadCode extends ByteCode{
    private int offset;
    private  String id;

    public LoadCode(String[] args) {
        this.offset = Integer.parseInt(args[1]);
        if(args.length == 3){
            this.id = args[2];
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.load(offset);

    }

    @Override
    public String toString() {
        String base = "LOAD " + offset;
        if(id != null){
            base = base + id;
        }
        return base;
    }
}
