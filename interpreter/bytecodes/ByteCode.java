package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public abstract class ByteCode {

    abstract public void execute(VirtualMachine vm);
    public abstract String toString();

    public static ByteCode getNewInstance(String type,String[]args){
        return switch (type){
            case "HALT" -> new HaltCode(args);
            case "POP" -> new PopCode(args);
            case "FALSEBRANCH" -> new FalseBranchCode(args);
            case "GOTO" -> new GotoCode(args);
            case "STORE" -> new StoreCode(args);
            case "LOAD" -> new LoadCode(args);
            case "LIT" -> new LitCode(args);
            case "ARGS" -> new ArgsCode(args);
            case "CALL" -> new CallCode(args);
            case "RETURN" -> new ReturnCode(args);
            case "BOP" -> new BopCode(args);
            case "READ" -> new ReadCode(args);
            case "WRITE" -> new WriteCode(args);
            case "LABEL" -> new LabelCode(args);
            case "DUMP" -> new DumpCode(args);


            default -> throw new IllegalArgumentException( );
        };
    }
}
