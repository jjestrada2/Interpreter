package interpreter.virtualmachine;

import interpreter.bytecodes.*;

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
            if(bc instanceof LabelCode){
                labels.put(((LabelCode) program.getCode(counterIndex)).getLabel(), counterIndex);
            }
            counterIndex++;
        }
        counterIndex = 0;
        for (ByteCode bc : program.program){

            if(bc instanceof GotoCode){
                ((GotoCode) program.getCode(counterIndex)).setAddress(
                        program.getAddress().get(((GotoCode) program.getCode(counterIndex)).getLabel()));
            } else if (bc instanceof CallCode) {
                ((CallCode) program.getCode(counterIndex)).setAddress(
                        program.getAddress().get(((CallCode) program.getCode(counterIndex)).getLabel())
                );

            } else if (bc instanceof FalseBranchCode) {
                program.getAddress().get(((FalseBranchCode) program.getCode(counterIndex)).getLabel());
            }
            counterIndex++;
        }


    }

    public HashMap<String, Integer> getAddress(){
        return this.labels;
    }
}