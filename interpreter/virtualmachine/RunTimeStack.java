package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class RunTimeStack {

    private List<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial frame pointer value, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void push(int valueToPush) {
        this.runTimeStack.add(valueToPush);
    }
    public void newFrameAt(int offset){
        int newFramePointer = runTimeStack.size()-offset;
        framePointer.push(newFramePointer);
    }

    public int getFramePointerSize(){
        return framePointer.size();
    }

    public int popRuntimeStack(){
        int i = 0;
        if(!runTimeStack.isEmpty()){
            i = runTimeStack.get(runTimeStack.size()-1);
            runTimeStack.remove(runTimeStack.size()-1);
        }
        return i;
    }

    public int load(int offset) {
        if(!this.runTimeStack.isEmpty()){
            int temp = runTimeStack.get(framePointer.peek()+offset);
            this.runTimeStack.add(temp);
        }
        return 0;
    }

    public int store(int currentOffset) {
        int value = popRuntimeStack();
        int  offset = runTimeStack.size() - currentOffset -1;
        runTimeStack.set(offset,value);
        return 0;
    }

    public int peek() {
        return runTimeStack.get(runTimeStack.size()-1);
    }


    public void popFrame() {
        int frameSize = framePointer.pop();
        int rv = this.popRuntimeStack();
        while (runTimeStack.size() - 1 > frameSize) {
            this.popRuntimeStack();
        }
        this.push(rv);
    }
}
