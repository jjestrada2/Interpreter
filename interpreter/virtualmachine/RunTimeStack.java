package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.Collections;
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

    public int push(int valueToPush) {
        this.runTimeStack.add(valueToPush);
        return valueToPush;
    }
    public void newFrameAt(int offset){
        int newFramePointer = runTimeStack.size()-offset;
        framePointer.push(newFramePointer);
    }

    public int getFramePointerSize(){
        return framePointer.size();
    }

    public int pop(){
        int i = 0;
        if(!runTimeStack.isEmpty()){
            i = runTimeStack.get(runTimeStack.size()-1);
            runTimeStack.remove(runTimeStack.size()-1);
        }
        return i;
    }

    public int load(int offset) {
        int temp = 0;
        //if(!this.runTimeStack.isEmpty()){
            temp = runTimeStack.get(framePointer.peek()+offset);
            this.runTimeStack.add(temp);
        //}
        return temp;
    }

    public int store(int currentOffset) {
        int value = pop();
        int  offset = this.framePointer.peek() + currentOffset ;
        runTimeStack.set(offset,value);
        return value;
    }

    public int peek() {
        return runTimeStack.get(runTimeStack.size()-1);
    }


    public void popFrame() {
        int frameSize = framePointer.pop();
        int rv = this.pop();
        while (runTimeStack.size()  > frameSize) {
            this.pop();
        }
        this.push(rv);
    }


    public void dump() {
        // Print the runtime stack, frames separated by brackets and
        // variables within frames separated by commas

//        ArrayList<Integer> frames = new ArrayList<Integer>();
//        for (int i = 0; i < framePointer.size(); i++) {
//            frames.add(framePointer.pop());
//            Collections.reverse(frames); // Frames as an ArrayList
//        }
//        // push the items from frames back into the framePointer stack
//        for (int i = 0; i < frames.size(); i++) {
//            framePointer.push(frames.get(i));
//        }
        // Use an external iterator variable to track position in frames ArrayList
        int j = 1;
        // Open with a bracket,
       // if (runTimeStack.size() > 0) {
            String output = "[";
            // Then print every item in the runTimeStack
            for (int i = 0; i < runTimeStack.size(); i++) {
                output = output + runTimeStack.get(i) + ",";
                // Add in brackets where necessary
                if (this.framePointer.size() > j && i == this.framePointer.get(j)) {
                    output = output + "] [";
                    j++;
                }
            }
            // Trim closing comma
          //6
        // output = output.substring(0, output.length() - 1);
            // Close with another bracket
            output = output + "]";
            System.out.println(output);
        }
    //}
}
