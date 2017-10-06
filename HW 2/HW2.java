/*Isaac Ng, HW2, This class will test my ability and sanity to write loops that manipulate strings in various ways*/

public class HW2{
  
//Checks whether the first x number of characters in the string are the same
  public static boolean samePrefix(String string1, String string2, int number){
    int i = 0;
    if (number > string1.length() || number > string2.length())
      return false;
    if (string1 == "" && string2 == "" && number == 0)
      return true;
    /*subgoal is to add i every time character matches, goal is to obtain i, precondition is that string must exist, must have data, must have character at index i*/
    while (string1.charAt(i) == string2.charAt(i)){
      i = i + 1;
      if (i == number)
        return true;
    }
    return false;
  }
  
//any spaces before the string are removed
  public static String trimSpacesFromFront(String string1){
    //the stringbuilder we store the new string in
    StringBuilder builder = new StringBuilder();
    int i = 0;
    //subgoal is to add 1 to the index until it hits the first non whitespace, goal is to return index, must not be string null, must be character space
    while (string1.charAt(i) == ' '){
      i = i + 1;
    }
    //subgoal is to increment index and append the associated character; goal is to get the completed stringbuilder, must be past spaces, not solely spaces
    for (;i < (string1.length()); i = i + 1){
      char c = string1.charAt(i);
      builder.append(c);
    }
    return builder.toString();
  }
  
//counts the number of words in the string
  public static int countWords (String string1) {
    //keeps track of number of words
    int wordcount = 0;
    /*subgoal to add 1 to wordcount for each word depending on conditions; goal is to get the number of words, string must exist*/
    for (int i = 0; i < string1.length();){
      if (string1.charAt(i) != ' '){
        wordcount = wordcount + 1;
        //the two loops below advance i only if the conditions for a word are met
        while (i < string1.length() && string1.charAt(i) != ' ')
          i = i + 1;}
      else {
        while (i < string1.length() && string1.charAt(i) == ' ')
          i = i + 1;
      }
    }
    return wordcount;  
  }
  
//truncates the string to the desired length
  public static String truncate(String string1, int dlength){
    if (dlength > string1.length())
      return string1;
    //the stringbuilder we store the new string in
    StringBuilder builder = new StringBuilder();
    int i = 0;
    //subgoal is to add 1 to i and add space to stringbuilder, goal is to get stringbuilder, must not be string null, string must be less than dlength 
    while (string1.charAt(i) == ' '){
      builder.append(string1.charAt(i));
      i = i + 1;
    }
    //compensates for the number of spaces
    int offset = i;
    //subgoal is to add 1 to i and append the character at the index if it fulfills the conditions, goal is to get all the characters
    while (i < (dlength + offset) && i < string1.length()) {
      builder.append(string1.charAt(i));
      i = i + 1;
    }
    //this accounts for both return possibilities, where the string ends perfectly and where the string is too long
    if (i == string1.length())
      return builder.toString();
    else {
      //subgoal is to add 1 to index and append the character at that index, goal is to get the string even if it is past desired length, string must not bel null, string must be longer than dlength
      while (i < string1.length() && string1.charAt(i) != ' '){
        builder.append(string1.charAt(i));
        i = i + 1;
      }
      return builder.toString();
    }                  
  }
  
//this adds spaces in between the words to match the uesr input's desired length
  public static String padString(String string1, int dlength){
    //the stringbuilder we store the new string in
    StringBuilder builder = new StringBuilder();
    //counts spaces
    int spacecount = 0;
    //subgoal to add one to spacecount, goal is to get the total number of spacecount, must have spaces, not null
    for (int i = 0; i < string1.length(); i = i + 1){
      if (string1.charAt(i) == ' ')
        spacecount = spacecount + 1;
    }
    if (spacecount == 0)
      return string1;
    //number of extra spaces
    int space = dlength - string1.length();
    //how many spaces to add in between
    int base = space / spacecount;
    //is the extra spaces if uneven
    int extra = space % spacecount;
    //keeps track of which space we are on to help add on spaces to end later
    int pastspaces = 0;
    //subgoal is to add spaces when necessary depending on the if statements; goal is to get the full statement with proper spacing; not null string
    for (int i = 0; i < string1.length(); i = i + 1){
      if (string1.charAt(i) == ' '){
        //subgoal is to add the space in between the words; goal is to add all the spaces necessary to the starting amount of spaces; not null string, must be a space to start with
        for (int j = 0; j < base; j = j + 1)
          builder.append(' ');
        pastspaces = pastspaces + 1;
        //adds the extra spaces at the end
        if (pastspaces > spacecount - extra){
          builder.append(' ');
        } 
      }
      builder.append(string1.charAt(i));
    }    
    return builder.toString();
  }
  
//This prints String to the screen to have lines long as the user input, while not having the left and right most be whitespace, adds spaces to combat this
  public static void prettyPrint(String string1, int dlength){
    if (countWords(string1) > 0 && dlength > 0){
      //variable to determine whether there are any more words to add on
      boolean wordsleft = true;
      //subgoal is to add on each line according to desired width; goal is to print out the whole string; must fulfill the if statement above
      while(wordsleft && string1.length() > 0){
        //buidler1 is the line we print
        StringBuilder builder1 = new StringBuilder(); 
        //builder2 is the leftover words
        StringBuilder builder2 = new StringBuilder();
        builder1.append(truncate(string1, dlength));
        //the length of the to be printed string
        int stringlength = builder1.length();
        if (countWords(builder1.toString()) == 0){
          wordsleft = false;
        }
        //the index
        int i = stringlength;
        //subgoal is to add on the characters of the remaining string 1 by 1; goal is to get the remainig string; must have string
        while (i < string1.length()){
          builder2.append(string1.charAt(i));
          i = i + 1;
        }
        System.out.println(padString(builder1.toString(), dlength));
        string1 = trimSpacesFromFront(builder2.toString());
      }
    }
  }
  
  
//This checks whether the two strings are an anagram , disregarding any punctuation and returns a boolean value
  public static boolean isAnagram(String string1, String string2){
    //the stringbuilder we store the new string in
    StringBuilder builder1 = new StringBuilder();
    //the stringbuilder we store the new string in
    StringBuilder builder2 = new StringBuilder();
    //stores lower case string 1
    String lstring1 = string1.toLowerCase();
    //stores lowercase string 2
    String lstring2 = string2.toLowerCase();
    //subgoal is to append the character and increase i by 1; goal is to have only the characters/numbers of the string remaining as the new string, must not be null string
    for (int i = 0; i < string1.length(); i = i + 1){
      if (lstring1.charAt(i) >= 'a' && lstring1.charAt(i) <= 'z' || lstring1.charAt(i) >= '0' && lstring1.charAt(i) <= '9')
        builder1.append(lstring1.charAt(i));
    }
    //subgoal is to append the character and increase j by 1; goal is to have only the characters/numbers of the string remaining as the new string, must not be null string
    for (int j = 0; j < string2.length(); j = j + 1){
      if (lstring2.charAt(j) >= 'a' && lstring2.charAt(j) <= 'z' || lstring2.charAt(j) >= '0' && lstring2.charAt(j) <= '9')
        builder2.append(lstring2.charAt(j));
    }
    //store the string to be compared 
    String anagram1 = builder1.toString();
    //store the other string to b ecompared
    String anagram2 = builder2.toString();
    if (anagram1.length() != anagram2.length())
      return false;
    int[] array1 = new int[36];
    //subgoal to loop through and append a zero to the respective subunit; goal is to initialize a array comprising only zeroes, array must be created
    for (int k = 0; k < array1.length; k = k + 1)
      array1[k] = 0;
    /*subgoal is to step through string and check if the character fits the parameter and then adding 1 to the respective index; 
     * goal is to return an array that has numbers in it corresponding to how many times the character showed up; 
     * no null arrays, this is for string 1*/
    for (int l = 0; l < anagram1.length(); l = l + 1){
      //adds 1 in respective index for letter
      if (anagram1.charAt(l) >= 'a' && anagram1.charAt(l) <= 'z'){
        int index = anagram1.charAt(l) - 'a';
        array1[index] = array1[index] + 1;
      }
      //adds 1 in respective index for number
      if (anagram1.charAt(l) >= '0' && anagram1.charAt(l) <= '9'){
        int index = anagram1.charAt(l) - '0' + 26;
        array1[index] = array1[index] + 1 ;
      }
    }
    int[] array2 = new int[36];
    //subgoal to loop through and append a zero to the respective subunit; goal is to initialize a array comprising only zeroes, array must be created
    for (int m = 0; m < array1.length; m = m + 1)
      array1[m] = 0;
    /*subgoal is to step through string and check if the character fits the parameter and then adding 1 to the respective index; 
     * goal is to return an array that has numbers in it corresponding to how many times the character showed up; 
     * no null arrays, this is for string 2*/
    for (int n = 0; n < anagram1.length(); n = n + 1){
      //adds 1 in respective index for letter
      if (anagram2.charAt(n) >= 'a' && anagram2.charAt(n) <= 'z'){
        int index = anagram2.charAt(n) - 'a';
        array2[index] = array2[index] + 1;
      }
      //adds 1 in respective index for number
      if (anagram2.charAt(n) >= '0' && anagram2.charAt(n) <= '9'){
        int index = anagram2.charAt(n) - '0' + 26;
        array2[index] = array2[index] + 1;
      }
    }
    //subgoal is to loop through array and compare elements; goal is to determine whether the arrays match up and return true or false; no null arrays, must be sorted arrays
    for (int o = 0; o < array1.length; o = o + 1){
      if (array1[o] == array2[o])
        return true;
    }
    return false;
  }
}