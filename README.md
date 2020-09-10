#Summary
1.The WordCountContainer was approached in a Test Driven Development process 
which invloved writing and implementing tests against the methods in the
WordCountContainer class before the WordCountContainer
class methods were implemented.The idea behind this style 
of writing code makes for more roubust code, with less errors and 
bugs. We can write our code and test as our methods as we go along to check
progress. This alsom allows us to split a large project into smaller more
manageble sections (espeically useful in the industry when a project involves
more than one developer at a time on a specific project, and the development is
occuring at different stages in different speeds) and test each section 
individually. This will ensure the overall program is free of logical errors
and bugs.

2.
	a. WordCountContainerTester.java: this file was disigned to implement 
	testing code against the code written for the WordCount program. The 
	WordCountContainerTester.java file will have various tests that will 
	ensure the program in WordCount and WordCountContainer is operating
	at its best capacity with the least amount of errors or holes.

	b. WordCountContainer.java: this file is designed to hold in memory all
	of the WordCount words that are passed as input into the WordCount 
	program. The WordCountContainer is just that, a container for all the 
	words in the WordCount program. a List of all the words. various 
	operations can be performed on the list of words in the container. 
	A short list of operations that can be performed on the list of words
	is: the ability to read a text file, store the words in the text file, 
	count the amount of words and the frequency of each word, write the 
	words to a new file, remove specific words from the list of words, and
	find the top N words in the text file. 

	c. .txt files: The text files, such as test1.txt, topNword.txt etc. 
	were all created for use in the WordCountContainer and 
	WordCountContainerRunner and WordCountContainerTester classes
	designed to only consist of a sequence of words (or lack thereof)
	which will be read from the programs, and used for various methods
	in the program. 


#Commands 

Questions about Vim:
1. go to the first line and type "d5d"
2. hjkl
3. position cursor where you want to begin cutting. then press v to select 
characters or uppercase V to select whole lines, or Ctrl-v to select rectangular
blocks then move cursor to the end of where you want to cut and press d to cut.
4. esc u to undo, and Ctrl-r to redo

Questions about Linux:
1. rm -r directoryname 
2. -A list all entries, -b uses time of last modification
-e displays the mode, 
3. use the mv command old-file-name new-file-name
4.cd..
5. find . -name '*.csv' -exec cp --parents \{\} /target \;
6.rm -rf dirname

# word_analysis_java
