package interpreter.virtualmachine;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;

    private boolean dumpOn;

    public VirtualMachine(Program program) {
        this.program = program;
        this.runTimeStack = new RunTimeStack();
        this.returnAddress = new Stack<>();
        this.programCounter = 0;
    }

    public void push(int valueToPush){
        this.runTimeStack.push(valueToPush);
    }

    public void pushToFramePntrStck(int offset){
        this.runTimeStack.newFrameAt(offset);
    }

    public void toggleRunning() {
        isRunning = !isRunning;
    }

    public int frameSize() {
        return this.runTimeStack.getFramePointerSize();
    }

    public int popRunTimeStack() {
        return this.runTimeStack.popRuntimeStack();
    }

    public void load(int offset) {
        this.runTimeStack.load(offset);
    }

    public void store(int offset) {
        runTimeStack.store(offset);
    }

    public void printTopRunTimeStack() {
        System.out.println(this.runTimeStack.peek());
    }


    public void setPc(int address) {
        this.programCounter = address;
    }

    public void returnAddressPush(int valueToPush){
        this.returnAddress.push(valueToPush);
    }

    public int getPc(){
        return this.programCounter;
    }

    public int runStackPop() {
       return this.runTimeStack.popRuntimeStack();
    }

    public void runStackPopFrame() {
        this.runTimeStack.popFrame();
    }

    public int returnAddressPop() {
        return this.returnAddress.pop();
    }

    public void setDumpOn(boolean dumpOn) {
        this.dumpOn = dumpOn;
    }
}
