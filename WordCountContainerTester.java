import java.io.*;
import java.util.*;

/**
 * the WordCountContainerTester class will contain the 
 * main method to demonstrate the WordCountContainer, WordCount
 * and WordCountContainerRunner class methods.
 * The class will also perform test methods and operations
 * on various methods on the WordCountContainer class. 
 *
 *
 * @author Matthew Roth
 * @ID: cs8bfds
 * @date 10/16/2018
 *
 * */
public class WordCountContainerTester {


  public static void main(String[] args) throws IOException {

    //run the testToString() method to test the toString of WordCount
    System.out.println("Testing toString()...");
    testToString();
    System.out.println();

    //run the testGetWordsFromFile() method to test reading words from
    //a text file 
    System.out.println("Testing getWordsFromFile()...");
    testGetWordsFromFile();
    System.out.println();

    //run the testRemoveCommon() method to remove the most common indicated
    //words from the file
    System.out.println("Testing removeCommon()...");
    testRemoveCommon();
    System.out.println();

    //run the testTopNWords() method to test the topNWords 
    System.out.println("Testing topNWords()...");
    testTopNWords();
    System.out.println();

  } 

  public static void testToString() {
    // create 3 WordCount objects
    WordCount WCthis = new WordCount("this");
    WCthis.setCount(3);
    WordCount WCa = new WordCount("a");
    WCa.setCount(1);
    WordCount WCis = new WordCount("is");
    WCis.setCount(2);           

    WordCount WCjava = new WordCount("java");
    WCjava.setCount(4);

    // create a WordCountList, add the 3 WordCounts into it
    WordCountContainer list = new WordCountContainer();
    list.getList().add(WCthis);
    list.getList().add(WCa);
    list.getList().add(WCis);
    list.getList().add(WCjava);
    // verify toString returns correct String
    if ( ! "this(3) a(1) is(2) java(4)".equals(list.toString()) ) {

      System.out.println("Failed");
    } else {
      System.out.println("Passed");
    }
  }

  /**
   * testTopNWords method will create objects of WordCountContainer
   * and run the topNWords() method from each container to 
   * ensure the program is functioning properly 
   *
   * */
  public static void testTopNWords() throws IOException {

    // create three WordCountContainer objects each with a
    // unique set of parameters for testing errors
    
    //standard case test of words 
    WordCountContainer container = new WordCountContainer();
    container.getWordsFromFile("topN.txt");
    container.topNWords(2);

    //test for returning top 2 when only one word object is in container 
    WordCountContainer container2 = new WordCountContainer();
    container2.getWordsFromFile("topN2.txt");
    container2.topNWords(2);
    
    //test for empty arraylist return empty when list is empty 
    WordCountContainer container3 = new WordCountContainer();
    container3.getWordsFromFile("topNwordEmpty.txt");
    container3.topNWords(1);
   
    //test for negative input for 'n' as an argument 
    WordCountContainer container4 = new WordCountContainer();
    container4.getWordsFromFile("topNnegative.txt");
    container4.topNWords(-1);
  
    /**
     * TESTING BELOW 
     *
     * */ 


    //verify the size of the list 
    int size1 = container.topNWords(2).size();
    if (size1 != 2 ) {
      System.out.println("Incorrect ArrayList size, should be 2");
        return; // return here to avoid null pointer exception 
    }

    boolean hasErrorCase1 = false;

    // verify each word and count
    if ( !container.topNWords(2).get(0).getWord().equals("word") ){
      System.out.println("Incorrect word at index 0, should be \"word\"");
      hasErrorCase1 = true;
    }
    if ( container.topNWords(2).get(0).getCount() != 9 ){
      System.out.println("Incorrect count at index 0, should be 8");
      hasErrorCase1 = true;
    }

    // verify each word and count
    if ( !container.topNWords(2).get(1).getWord().equals("lots") ){
      System.out.println("Incorrect word at index1, should be \"lots\"");
      hasErrorCase1 = true;
    }
    if ( container.topNWords(2).get(1).getCount() != 5 ){
      System.out.println("Incorrect count at index 1, should be 5");
      hasErrorCase1 = true;
    }
    if ( hasErrorCase1 ) {
        System.out.println("Test case 1 failed");
      } else {
        System.out.println("Test case 1 passed");
      }

    int size2 = container2.topNWords(2).size();
    if (container2.topNWords(2).size() != 1 ) {
      System.out.println("Incorrect ArrayList size, should be 1");
        return; // return here to avoid null pointer exception 
    }

    boolean hasErrorCase2 = false;

    // verify each word and count
    if ( !container2.topNWords(2).get(0).getWord().equals("word") ){
      System.out.println("Incorrect word at index 0, should be \"word\"");
      hasErrorCase2 = true;
    }
    if ( container2.topNWords(2).get(0).getCount() != 1 ){
      System.out.println("Incorrect count at index 0, should be 1");
      hasErrorCase2 = true;
    }

    if ( hasErrorCase2 ) {
        System.out.println("Test case 2 failed");
      } else {
        System.out.println("Test case 2 passed");
      }

    if ( !container3.topNWords(1).isEmpty() ) {
      System.out.println("Incorrect ArrayList size, should be null");
        return; // return here to avoid null pointer exception 
    }

    boolean hasErrorCase3 = false;

    // verify each word and count
    if ( !container3.topNWords(0).isEmpty() ){
      System.out.println("Incorrect return, the list should be empty");
      hasErrorCase3 = true;
    }

    if ( hasErrorCase3 ) {
        System.out.println("Test case 3 failed");
      } else {
        System.out.println("Test case 3 passed");
      }

     boolean hasErrorCase4 = false;

    // verify each word and count
    if ( !container4.topNWords(0).isEmpty() ){
      System.out.println("Incorrect the list should be empty");
      hasErrorCase4 = true;
    }

    if ( hasErrorCase4 ) {
        System.out.println("Test case 4 failed");
      } else {
        System.out.println("Test case 4 passed");
      }

  }
/**
 * testRemoveCommmon() method will test the removeCommon() method 
 * to see if the method was able to remove the correct words 
 * */
  public static void testRemoveCommon() throws IOException {
    //create a WordCountList, get words from text file
    WordCountContainer container = new WordCountContainer();
    container.getWordsFromFile("test1.txt");
    container.removeCommon("remove1.txt");
    System.out.println("Test case #1: ");
    

    WordCountContainer container2 = new WordCountContainer();
    container2.getWordsFromFile("word2.txt");
    //remove all the words from the text file and empty the ArrayList
    container2.removeCommon("remove2.txt");
    System.out.println("Test case #2: ");
    

    WordCountContainer container3 = new WordCountContainer();
    //remove the a word that isnt in the text file 
    container3.getWordsFromFile("word3.txt");
    container3.removeCommon("remove3.txt");
    System.out.println("Test case #3: ");   

    /**
     * TESTING BELOW 
     *
     * */

    //determine the size of the arraylist
    int size1 = container.getList().size();
    if (size1 != 2) {
      System.out.println("Incorrect ArrayList size, should be 2");
        return; // return here to avoid null pointer exception 
    }

    boolean hasErrorCase1 = false;

    // verify each word and count
    if ( !container.getList().get(0).getWord().equals("salad") ){
      System.out.println("Incorrect word at index 0, should be \"salad\"");
      hasErrorCase1 = true;
    }
    if ( container.getList().get(0).getCount() != 1 ){
      System.out.println("Incorrect count at index 0, should be 1");
      hasErrorCase1 = true;
    }

    if ( !container.getList().get(1).getWord().equals("cloud") ){
      System.out.println("Incorrect word at index 0, should be \"cloud\"");
      hasErrorCase1 = true;
    }
    if ( container.getList().get(1).getCount() != 1 ){
      System.out.println("Incorrect count at index 1, should be 1");
      hasErrorCase1 = true;
    }

    if ( hasErrorCase1 ) {
        System.out.println("Test case 1 failed");
      } else {
        System.out.println("Test case 1 passed");
      }
    

    int size2 = container2.getList().size();
    if (size2 != 0) {
      System.out.println("Incorrect ArrayList size, should be 0");
        return; // return here to avoid null pointer exception 
    }

    boolean hasErrorCase2 = false;

    // verify each word and count
    if ( !container2.getList().isEmpty() ){
      System.out.println("Incorrect word at index 0, should be \"null\"");
      hasErrorCase2 = true;
    }
    if ( hasErrorCase2 ) {
        System.out.println("Test case 2 failed");
      } else {
        System.out.println("Test case 2 passed");
      }
    
    int size3 = container3.getList().size();
    if (size3 != 1) {
      System.out.println("Incorrect ArrayList size, should be 1");
        return; // return here to avoid null pointer exception 
    }

    boolean hasErrorCase3 = false;

    // verify each word and count
    if ( !container3.getList().get(0).getWord().equals("o") ){
      System.out.println("Incorrect word at index 0, should be \"o\"");
      hasErrorCase3 = true;
    }
    if ( container3.getList().get(0).getCount() != 1 ){
      System.out.println("Incorrect count at index 0, should be 1");
      hasErrorCase3 = true;
    }

    if ( hasErrorCase3 ) {
        System.out.println("Test case 3 failed");
      } else {
        System.out.println("Test case 3 passed");
      }
        
    }
  
/**
 * testGetWordsFromFile() method should test the getWordsFromFile()
 * method to ensure that the method is correctly reading the 
 * right words and word count from the text file 
 * */
  public static void testGetWordsFromFile() throws IOException {
    // create a WordCountList, get words from test1.txt
    WordCountContainer container = new WordCountContainer();
    container.getWordsFromFile("test11.txt");

    WordCountContainer container2 = new WordCountContainer();
    container2.getWordsFromFile("test2.txt");

    WordCountContainer container3 = new WordCountContainer();
    container3.getWordsFromFile("test3.txt");

    /**
     * TESTING BELOW 
     *
     * */


    // verify the ArrayList has 3 items in it
    int size1 = container.getList().size();
    if (size1 != 2) {
      System.out.println("Incorrect ArrayList size, should be 2");
        return; // return here to avoid null pointer exception 
    }

    boolean hasErrorCase1 = false;

    // verify each word and count
    if ( !container.getList().get(0).getWord().equals("Cloud") ){
      System.out.println("Incorrect word at index 0, should be \"Cloud\"");
      hasErrorCase1 = true;
    }
    if ( container.getList().get(0).getCount() != 3 ){
      System.out.println("Incorrect count at index 0, should be 3");
      hasErrorCase1 = true;
    }

    if ( !container.getList().get(1).getWord().equals("word") ){
      System.out.println("Incorrect word at index 1, should be \"word\"");
      hasErrorCase1 = true;
    }
    if ( container.getList().get(1).getCount() != 1 ){
      System.out.println("Incorrect count at index 1, should be 1");
      hasErrorCase1 = true;
    }
    if ( hasErrorCase1 ) {
      System.out.println("Test case 1 failed");
    } else {
      System.out.println("Test case 1 passed");
    }

    // test case 2
    int size2 = container2.getList().size();
    if (size2 != 4) {
      System.out.println("Incorrect ArrayList size, should be 4");
        return; // return here to avoid null pointer exception
    }
    boolean hasErrorCase2 = false;

    // verify each word and count
    if ( !container2.getList().get(0).getWord().equals("make") ){
      System.out.println("Incorrect word at index 0, should be \"make\"");
      hasErrorCase2 = true;
    }

    if ( container2.getList().get(0).getCount() != 1 ){
      System.out.println("Incorrect count at index 0, should be 1");
      hasErrorCase2 = true;
    }

    if ( !container2.getList().get(1).getWord().equals("java") ){
      System.out.println("Incorrect word at index 1, should be \"java\"");
      hasErrorCase2 = true;
    }

    if ( container2.getList().get(1).getCount() != 1 ){
      System.out.println("Incorrect count at index 0, should be 1");
      hasErrorCase2 = true;
    }

    if ( !container2.getList().get(2).getWord().equals("great") ){
      System.out.println("Incorrect word at index 2, should be \"great\"");
      hasErrorCase2 = true;
    }

    if ( container2.getList().get(2).getCount() != 1 ){
      System.out.println("Incorrect count at index 2, should be 1");
      hasErrorCase2 = true;
    }

    if ( !container2.getList().get(3).getWord().equals("again") ){
      System.out.println("Incorrect word at index 3, should be \"again\"");
      hasErrorCase2 = true;
    }

    if ( container2.getList().get(3).getCount() != 1 ){
      System.out.println("Incorrect count at index 3, should be 1");
      hasErrorCase2 = true;
    }

    if ( hasErrorCase2 ) {
      System.out.println("Test case 2 failed");
    } else {
      System.out.println("Test case 2 passed");
    }

    // test case 3

    int size3 = container3.getList().size();
    if (size3 != 5) {
      System.out.println("Incorrect ArrayList size, should be 5");
      return; // return here to avoid null pointer exception
    }
    boolean hasErrorCase3 = false;

    // verify each word and count
    if ( !container3.getList().get(0).getWord().equals("LOOOOOOONNNNGGGG") ){
      System.out.println("Incorrect word at index 0, should be \"LOOOOOOONNNNGGGG\"");
      hasErrorCase3 = true;
    }

    if ( container3.getList().get(0).getCount() != 1 ){
      System.out.println("Incorrect count at index 0, should be 1");
      hasErrorCase3 = true;
    }

    if ( !container3.getList().get(1).getWord().equals("word1") ){
      System.out.println("Incorrect word at index 1, should be \"word1\"");
      hasErrorCase3 = true;
    }

    if ( container3.getList().get(1).getCount() != 3 ){
      System.out.println("Incorrect count at index 0, should be 3");
      hasErrorCase3 = true;
    }

    if ( !container3.getList().get(2).getWord().equals("!!!") ){
      System.out.println("Incorrect word at index 2, should be \"!!!\"");
      hasErrorCase3 = true;
    }

    if ( container3.getList().get(2).getCount() != 1 ){
      System.out.println("Incorrect count at index 2, should be 1");
      hasErrorCase3 = true;
    }

    if ( !container3.getList().get(3).getWord().equals("nextline") ){
      System.out.println("Incorrect word at index 3, should be \"nextline\"");
      hasErrorCase3 = true;
    }

    if ( container3.getList().get(3).getCount() != 1 ){
      System.out.println("Incorrect count at index 3, should be 1");
      hasErrorCase3 = true;
    }

    if ( !container3.getList().get(4).getWord().equals("1234") ){
      System.out.println("Incorrect word at index 4, should be \"1234\"");
      hasErrorCase3 = true;
    }

    if ( container3.getList().get(4).getCount() != 1 ){
      System.out.println("Incorrect count at index 4, should be 1");
      hasErrorCase3 = true;
    }

    if ( hasErrorCase3 ) {
      System.out.println("Test case 3 failed");
    } else {
      System.out.println("Test case 3 passed");
    } 

  }
}
