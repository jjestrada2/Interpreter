package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadCode extends ByteCode {

    private int input;
    Scanner scn;
    public ReadCode(String[] args) {
        this.scn = new Scanner(System.in);
    }

    @Override
    public void execute(VirtualMachine vm) {
        boolean readDone = false;
        do{
            System.out.println("Please enter a integer:");
            try {
                int value = scn.nextInt();
                vm.push(value);
                readDone = true;
            }catch (InputMismatchException e){
                System.out.println("The input is invalid, it has to be an integer");
                scn.nextLine();
            }

        }while(!readDone);


    }

    @Override
    public String toString() {
        return "READ";
    }
}
