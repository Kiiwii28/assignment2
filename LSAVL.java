import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This creates an AVL tree that only holds
 * objects of type LSData and has extra methods to help with testing and producing
 * results
 */

public class LSAVL{
    String fileName;
    AVLTree<LSData> avl = new AVLTree<LSData>();
    int filelinelength = 2976; //default file length of max

    public LSAVL(String pfilename){

        fileName = pfilename;
    }

    /**
     * loadData takes whatever the file name was at instantiation and creates a scanner
     * then loads in the data from the textfile, line by line
     * then using string splicing to seperate it into key and areas to
     * construct the LSData object with those 2 as parameters.
     * @throws FileNotFoundException
     */

    public void loadData() throws FileNotFoundException
    {
        Scanner fileInput = new Scanner(new File(fileName)); //reads in file from filename variable
        while (fileInput.hasNextLine()) //cycles through file using a scanner
        {
            String line =  fileInput.nextLine();
            int firstspace = line.indexOf(" "); //string handling to compare keys
            LSData lsd = new LSData(line.substring(0,firstspace),line.substring(firstspace)); //creates lsdatavaraiiables from each line in textfile
            avl.insert(lsd); //as LSdata object is created, added it into lsAVL variable
        }
    }

    /**
     * printAreas() cycles through the tree for the given LSData query which was constucted from a
     * string input.
     * @param pquery
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void printAreas(String pquery) throws FileNotFoundException, IOException {
        loadData(); //populate the tree
        System.out.println("Print areas called for search query");
        String query = pquery; //Make query into acceptable node
        LSData LSquery = new LSData(query,""); //AVL tree is child of binary tree
        BinaryTreeNode<LSData> result = avl.find(LSquery); //search with LSdata type, return into node
        try {
            if (result.data != null) { //avoid null pointer exception
                System.out.println("Result found: " + result.data.toString()); //calls lsdata type's default toString
                System.out.println(avl.showResults()); //returns instrumentation
            }
        } catch (NullPointerException e) {
            System.out.println("no results were found");
        }
        avl.setDefaults();

    }

    /**
     *
     * @throws FileNotFoundException
     */
    public void printAllAreas() throws FileNotFoundException{
        loadData(); //load textfile given into load shedding avl tree
        avl.treeOrder();  //cycle through tree and print each node's data
    }


    //to string
    public String toString(){
        return avl.showResults();
    }



}