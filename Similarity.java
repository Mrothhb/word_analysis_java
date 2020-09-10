import java.io.IOException;
import java.util.ArrayList;

public class Similarity {
  
  public static WordCountContainer findMax(WordCountContainer a, 
        WordCountContainer b) {

      WordCountContainer wordCount = new WordCountContainer();
      for (int i = 0; i < a.getList().size()-1; i++)
      {
        for(int j =0; j< b.getList().size()-1; j++) {

          if (b.getList().get(j).getWord().contains(a.getList().get(i).getWord())){
            if(b.getList().get(j).getCount() > a.getList().get(i).getCount()){
              wordCount.getList().add(b.getList().get(j));
              break;
            }
            else{
              wordCount.getList().add(a.getList().get(i));
              break;              
          }              
        
       }else{

         wordCount.getList().add(a.getList().get(i));
       }

      }
    }   

      return wordCount;
    }
      
    public static WordCountContainer findMin(WordCountContainer a, WordCountContainer b) {
      return null;
    }
    
    public static double getSimilarity(WordCountContainer a, WordCountContainer b) {
      return 0.0;
    }
    
    public static boolean isStrictSubset(WordCountContainer a, WordCountContainer b) {
      return false;
    }


    /*given main*/
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("This program takes exactly 2 arguments!");
            //return;
        }

        WordCountContainer fileA = new WordCountContainer();
        WordCountContainer fileB = new WordCountContainer();


       // fileA.getWordsFromFile(args[0]);
       // fileB.getWordsFromFile(args[1]);

        fileA.getWordsFromFile("test1.txt");
        fileB.getWordsFromFile("test2.txt");
        
        System.out.println(findMax(fileA, fileB).toString());

        fileA.removeCommon("commonWords.txt");
        fileB.removeCommon("commonWords.txt");

        boolean fileAIsSubset = isStrictSubset(fileB, fileA);
        boolean fileBIsSubset = isStrictSubset(fileA, fileB);

        if (fileAIsSubset && fileBIsSubset) {
            System.out.println("Warning! " + args[0] + " and " + args[1] +
                               " have the same contents!");
        } else if (fileAIsSubset) {
            System.out.println("Warning! " + args[0] + 
                               " is a subset of " + args[1]);
        } else if (fileBIsSubset) {
            System.out.println("Warning! " + args[1] + 
                               " is a subset of " + args[0]);
        }

        System.out.println("The files have a " + getSimilarity(fileA, fileB) +
                           "% similarity.");
    }
}
