package interpreter.virtualmachine;

import interpreter.bytecodes.ByteCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
public class Program {

    private List<ByteCode> program;
    private static HashMap<String,Integer> labels;

    /**
     * Instantiates a program object using an
     * ArrayList
     */
    public Program() {
        program = new ArrayList<>();
    }

    /**
     * Gets the size of the current program.
     * @return size of program
     */
    public int getSize() {
        return this.program.size();
    }

    /**
     * Grabs an instance of a bytecode at an index.
     * @param programCounter index of bytecode to get.
     * @return a bytecode.
     */
    public ByteCode getCode(int programCounter) {
        return this.program.get(programCounter);
    }

    /**
     * Adds a bytecode instance to the Program List.
     * @param c bytecode to be added
     */
    public void addByteCode(ByteCode c) {
        this.program.add(c);
    }

    /**
     * Makes multiple passes through the program ArrayList resolving
     * addrss for Goto,Call and FalseBranch bytecodes. These bytecodes
     * can only jump to Label codes that have a matching label value.
     * HINT: make note of what type of data-structure ByteCodes are stored in.
     * **** METHOD SIGNATURE CANNOT BE CAHNGED *****
     */
    public void resolveAddress(Program program) {

        labels = new HashMap<String,Integer>();
        int counterIndex = 0;
        for (ByteCode bc : program.program){
            String byteCodeName = bc.toString().split(" ")[0];
            if(byteCodeName.equals("LABEL")){
                String byteCodeLabel = bc.toString().split(" ")[1];
                labels.put(byteCodeLabel,counterIndex);
            }
            counterIndex++;
        }
        for (ByteCode bc : program.program){
            String byteCodeName = bc.toString().split(" ")[0];
            if(byteCodeName.equals("GOTO")){
                labels.get(bc.toString().split(" ")[1]);
                //add address in the bytecode
            } else if (byteCodeName.equals("CALL")) {
                //add address in the bytecode
                labels.get(bc.toString().split(" ")[1]);
            } else if (byteCodeName.equals("FALSEBRANCH")) {
                //add address in the bytecode
                labels.get(bc.toString().split(" ")[1]);
            }
        }


    }
}