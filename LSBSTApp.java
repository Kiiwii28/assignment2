
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 @Author Kiera Wilson
*/
public class LSBSTApp
{
    /**
     This is the main method app to construct the LSTree and depending on how many arguments were
     given, what output will be called for.

    */


    public static void main( String[] args ) throws FileNotFoundException, IOException {

        if (args.length == 3){ //if want to use printAreas
            LSTree lsTree = new LSTree("LSData.txt"); //call default constructor
            String query = args[0] + "_" + args[1] + "_" + args[2];
            lsTree.printAreas(query); //call printAreas method
        }
        else if (args.length == 1){
            LSTree lsTree = new LSTree(args[0]);//construct tree and fill with data from given textfile
        }
        else{
            LSTree lsTree = new LSTree("LSData.txt"); //call default constructor
            lsTree.printAllAreas();
        }


    }


}