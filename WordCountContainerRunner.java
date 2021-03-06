/*  WordCountContainerRunner
 *  Author: Alan Kuo
 *  Date: 04/08/2018
 *
 *  Class to test a WordCountContainer. The class expects two command line arguments:
 *  argument[0] is filename
 *  argument[1] is N, where N is the number of mostly occurring words to print
 *  argument[2] is file|console, where output will be directed
 *  Note that it expects a file with common word occurrences named "commonWords.txt"
 *
 */


import java.util.*;
import java.io.*;
public class WordCountContainerRunner {

  // method to test the WordCountContainer
  public static void main ( String[] args) throws IOException {
    // ensure numbers of parameters
  	if(args.length!=3){
  		System.out.println("Usage: java WordCountContainerRunner nameOfInputFile numberOfTopNWords {file|console} ");
  		return;
  	}
    // getting arguments and creating wcl
  	String filename = args[0];
  	String number = args[1];
  	String option = args[2];
    WordCountContainer w = new WordCountContainer();
    int n = 10;

    // checking parameter types
    try{
      w.getWordsFromFile(filename);
    }
    catch(FileNotFoundException e){
      System.out.println("The file you entered does not exist!!");
      return;
    }
    try {
      n = Integer.parseInt(number);
    } 
    catch (NumberFormatException e) {
      System.out.println("Please pass in a valid number!");
      return;
    }
    if(!option.equals("file")&&(!option.equals("console"))){
      System.out.println("Please pass in the correct output options as third parameter!");
      return;
    }

    // reading, removing words, and outputting
    System.out.println("Reading in File: " + filename);
    
    System.out.println("Removing common words");
    w.removeCommon("commonWords.txt");
    
    boolean printToFile = option.equals("file")?true:false; 
    
    System.out.println("Printing the top " + n + " words " + (printToFile==true?"in a file named myOutput.out.":"on console."));
    w.list = w.topNWords(n);
    w.outputWords(printToFile);
    
  }

}
