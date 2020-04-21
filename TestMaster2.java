import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

/**
 * this class tests the LSTree
 */

public class TestMaster2{
    ArrayList<String> queries = new ArrayList<String>();
    int filelength = 0;

    /**
     * the main method here is designed to be compatible with the makefile to simplify
     * input and output for file writing and rewriting
     *
     * A filename is given as the argument and output redirection is used
     * to permanently store the results
     * @param args
     * @throws FileNotFoundException
     * @throws IOException
     */

    public static void main(String[] args) throws FileNotFoundException, IOException{

        if(args.length == 1){
            String filename;
            filename = args[0]; //assume default file name
            System.out.println(filename + " was the name of the file requested");
            LSTree lsTree = new LSTree(args[0]);
            Scanner createqueries = new Scanner(new File(filename));
            while (createqueries.hasNextLine())
            {
                String line =  createqueries.nextLine();
                int firstspace = line.indexOf(" ");
                String query = line.substring(0,firstspace); //query is constructed
               lsTree.printAreas(query);

            }


        }else{
            System.out.println("Could not compute. Stop.");
        }

    }








}