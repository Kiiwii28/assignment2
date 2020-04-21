import java.io.FileNotFoundException;
import java.io.IOException;

public class AVLTreeApp
{
    public static void main( String[] args ) throws FileNotFoundException, IOException {
       if (args.length == 3){ //trying to call printAreas
           LSAVL lsAVL = new LSAVL("LSData.txt");//construct AVL tree of type LSData that initiates with LSData.txt
        String query = args[0] + "_" + args[1] + "_" + args[2];
            lsAVL.printAreas(query); //searches for the query through an avl tree holding the contents LSData.txt
       }
       else if (args.length == 1){
           LSAVL lsAVL = new LSAVL(args[0]);//construct with textfile as argument
       }
       else{
           LSAVL lsAVL = new LSAVL("LSData.txt"); //initiates with original textfile
            lsAVL.printAllAreas();
       }


    }
}