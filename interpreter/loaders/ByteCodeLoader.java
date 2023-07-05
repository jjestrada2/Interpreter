package interpreter.loaders;

import interpreter.bytecodes.ByteCode;
import interpreter.virtualmachine.Program;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public final class ByteCodeLoader {
    private String codSourceFileName;

    
    /**
     * Constructs ByteCodeLoader object given a COD source code
     * file name
     * @param fileName name of .cod File to load.
     */
    public ByteCodeLoader(String fileName){

        this.codSourceFileName = fileName;
    }
    
    /**
     * Loads a program from a .cod file.
     * @return a constructed Program Object.
     * @throws InvalidProgramException thrown when 
     * loadCodes fails.
     */
    public Program loadCodes() throws InvalidProgramException {
        Program program;
        try(BufferedReader reader = new BufferedReader(new FileReader(this.codSourceFileName))){
            program= new Program();
            ByteCode bc;
            String line;
            String[] items;
            while(reader.ready()){
                line = reader.readLine();
                items = line.split("\\s+");
                bc = ByteCode.getNewInstance(items[0],items);
                program.addByteCode(bc);

               // System.out.println(Arrays.toString(items));
            }
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return program;
    }
}
