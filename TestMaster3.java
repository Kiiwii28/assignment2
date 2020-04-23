import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

/**
 * this class tests the LSTree
 */

public class TestMaster3{
    ArrayList<String> queries = new ArrayList<String>();  //create array list to hold all queries
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
            LSAVL lsAVL = new LSAVL(filename);
            System.out.println("constructed and populated avl tree");
            Scanner createqueries = new Scanner(new File(filename)); //Creates queries from given textfile
            while (createqueries.hasNextLine())
            {
                String line =  createqueries.nextLine();
                int firstspace = line.indexOf(" ");
                String query = line.substring(0,firstspace); //query is constructed from first part of line
                lsAVL.printAreas(query); //search through entire avl tree and prints out for that query
                    //searches for each line through AVL tree.
            }


        }else{
            System.out.println("Could not compute. Stop.");
        }

    }








}