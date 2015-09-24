package securiteL3; 
/**
* Created by ByTeK on 10/03/15.
*/


import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class Dawg {

  private static final int CHILD_BIT_SHIFT = 5;
  private static final int CHILD_INDEX_BIT_MASK = 0X003FFFE0;
  private static final int LETTER_BIT_MASK = 0X0000001F;
  private static final int END_OF_WORD_BIT_MASK = 0X00800000;
  private static final int END_OF_LIST_BIT_MASK = 0X00400000;
  private static final int INPUT_SIZE_LIMIT = 100;
  private static final char LOWER_IT = 32;

  private int numberOfNodes;

  private int[] theDawgArray;
  char[] uneLettre = {'a','c','d','l','m','n','o','s','t','y'};

  public Dawg() throws Exception {

    //DataInputStream dawgDataFile = new DataInputStream(new BufferedInputStream(getClass().getResourceAsStream("Traditional_Dawg_For_Word-List.dat")));
    DataInputStream dawgDataFile = new DataInputStream(new BufferedInputStream(new FileInputStream("./securiteL3/Traditional_Dawg_For_Word-List.dat")));
    numberOfNodes = endianConversion(dawgDataFile.readInt());
    theDawgArray = new int[numberOfNodes];

    for (int x = 0; x < numberOfNodes; x++) {
      theDawgArray[x] = endianConversion(dawgDataFile.readInt());
    }
    dawgDataFile.close();
  }

  private int endianConversion(int thisInteger) {
    return ((thisInteger & 0x000000ff) << 24) + ((thisInteger & 0x0000ff00) << 8) + ((thisInteger & 0x00ff0000) >>> 8) + ((thisInteger & 0xff000000) >>> 24);
  }

  // These methods are used to extract information from the "theDawgArray" nodes.
  private char nodeLetter(int index) {
    return (char)((theDawgArray[index]&LETTER_BIT_MASK) + 'A');
  }
  private boolean nodeEndOfWord(int index) {
    return ((theDawgArray[index]&END_OF_WORD_BIT_MASK) != 0);
  }
  private int nodeNext(int index) {
    return ((theDawgArray[index]&END_OF_LIST_BIT_MASK) == 0)? (index + 1): 0;
  }
  private int nodeChild(int index) {
    return ((theDawgArray[index]&CHILD_INDEX_BIT_MASK)>>>CHILD_BIT_SHIFT);
  }

  private boolean searchForStringRecurse(String thisString, int position, int thisIndex) {
    int currentIndex = thisIndex;
    char currentChar = thisString.charAt(position);
    while ( currentIndex != 0 ) {
      if ( currentChar > nodeLetter(currentIndex) ) {
        currentIndex = nodeNext(currentIndex);
      }
      else if ( currentChar < nodeLetter(currentIndex) ) {
         return false;
      }
      else if ( thisString.length() == (position + 1) ) {
        if ( nodeEndOfWord(currentIndex) ) {
          return true;
        }
        else {
          return false;
        }
      }
      else {
        return searchForStringRecurse(thisString, position + 1, nodeChild(currentIndex));
      }
    }
    return false;
  }

  public boolean searchForStringB(String toSearchFor) {
    if(toSearchFor.length()==0) return true;
    if(toSearchFor.length()==1){
      for(char c : uneLettre)
        if(c == toSearchFor.charAt(0))return true;
      return false;
    }
    String upperString = toSearchFor.toUpperCase();
    return searchForStringRecurse(upperString, 0, (upperString.charAt(0) - 'A' + 1));
  }


  private String searchForPatternRecurseB(String emptyPattern, int position, int thisIndex, char[] thePattern, int[] tally) {
    int currentIndex = thisIndex;
    StringBuilder addThisMessage = new StringBuilder();
    char currentChar = emptyPattern.charAt(position);
    while ( currentIndex != 0 ) {
      if ( currentChar == '?') {
        thePattern[position] = nodeLetter(currentIndex);
        thePattern[position] += LOWER_IT;
        if ( (position == (emptyPattern.length() - 1)) ) {
          if ( nodeEndOfWord(currentIndex) ) {
            tally[0] += 1;
            addThisMessage.append(new String(thePattern, 0, position + 1) + "\n");
          }
        }
        else {
          addThisMessage.append(searchForPatternRecurseB(emptyPattern, position + 1, nodeChild(currentIndex), thePattern, tally));
        }
        currentIndex = nodeNext(currentIndex);
      }
      else if ( currentChar > nodeLetter(currentIndex) ) {
        currentIndex = nodeNext(currentIndex);
      }
      else if ( currentChar < nodeLetter(currentIndex) ) {
        break;
      }
      else if ( (position == (emptyPattern.length() - 1)) ) {
        if ( nodeEndOfWord(currentIndex) ) {
          thePattern[position] = nodeLetter(currentIndex);
          tally[0] += 1;
          return new String(thePattern, 0, position + 1) + "\n";

        }
        break;
      }
      else {
        thePattern[position] = nodeLetter(currentIndex);
        return searchForPatternRecurseB(emptyPattern, position + 1, nodeChild(currentIndex), thePattern, tally);
      }
    }
    return addThisMessage.toString();
  }


  public String[] searchForPatternB(String thisPattern) {
    //System.out.println("|||"+thisPattern+"||||");
    if(thisPattern.length()==0) return "".split("");
    if(thisPattern.length()==1){
      StringBuilder res = new StringBuilder();
      for(char c : uneLettre) {
        if (c == thisPattern.charAt(0) || thisPattern.charAt(0) == '?') res.append(c+" ");
      }
      return res.toString().split(" ");
    }
    int[] counter = new int[1];
    StringBuilder holder = new StringBuilder();
    String upperString = thisPattern.toUpperCase();
    //String traversalResult = "";
    char[] runningPattern = new char[upperString.length()];
    counter[0] = 0;
    if ( upperString.charAt(0) != '?' ) holder.append(searchForPatternRecurseB(upperString, 0, (upperString.charAt(0) - '@'), runningPattern, counter));
    else holder.append(searchForPatternRecurseB(upperString, 0, 1, runningPattern, counter));
    //traversalResult += counter[0] + " Words fit:\n\n";
    //traversalResult += holder;
    return  holder.toString().toLowerCase().split("\n");
  }
}
