import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This is like LSArray however it creates a binary search tree that only hols
 * objects of type LSData
 */

public class LSTree{
    String fileName;
    BinarySearchTree<LSData> bst = new BinarySearchTree<LSData>();
    int filelinelength = 2976;

    public LSTree(String pfilename){
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
        Scanner fileInput = new Scanner(new File(fileName));
        while (fileInput.hasNextLine())
        {
            String line =  fileInput.nextLine();
            int firstspace = line.indexOf(" ");
            LSData lsd = new LSData(line.substring(0,firstspace),line.substring(firstspace));
            //bst.setDefaults();
            bst.insert(lsd);
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
        loadData();
        String query = pquery; //Make query into binary node
        LSData LSquery = new LSData(query,"");
        BinaryTreeNode<LSData> result = bst.find(LSquery);
        try {
            if (result.data != null) {
                System.out.println(result.data.toString() + "   result..");
                System.out.println(bst.showResults());
            }
        } catch (NullPointerException e) {
            System.out.println("no results were found");
        }
        bst.setDefaults();

    }

    /**
     *
     * @throws FileNotFoundException
     */
    public void printAllAreas() throws FileNotFoundException{
        loadData();
        bst.inOrder();
       }


//to string
    public String toString(){
       return bst.showResults();
    }



    }