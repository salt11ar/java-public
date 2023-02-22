package listAndArrays;

import java.util.HashMap;


/**
Given two strings A and B, write a function that returns true if any substring of A is an anagram of B.

Examples:

A       B       result
redfin	friend	true
redfin	nerd	  false
redfin	find	  true
measure	seam	  true
measure	resume	false
*/

class AnagramsStrings {
	public static void main (String[] args) {
		System.out.println("Hello Java");
    
    System.out.println("#1 "+ "redfin "+ "friend");
    System.out.println("result: "+ anagrams("redfin", "friend"));
    
    System.out.println("#2 "+ "measure "+ "seam");
    System.out.println("result: "+ anagrams("measure", "seam"));
    
	}
  
  public static Boolean anagrams(String aWord, String bWord){
    
    if( bWord.length() > aWord.length())
      return false;

      for(int j=0; j< aWord.length()-1 ; j++)
      //for(int k=j+1;  k < bWord.length()-1 ; k++)
          {
            String sub = aWord.substring(j,bWord.length());
            if( compare(sub, bWord) )  // comparing each substring with B 
              return true;
          }
      return false;
  }
  
  public static Boolean compare(String aWord, String bWord )
  {
    
    //order boths strings and compare equal 
    
    HashMap<Character,Integer> aMap = new HashMap<Character,Integer>();
    HashMap<Character,Integer> bMap = new HashMap<Character,Integer>();
        
    for(int i  = 0; i< aWord.length() ; i++)
    {
      Character thechar = aWord.charAt(i);
      if(aMap.containsKey(thechar))
      {
        aMap.put(thechar, aMap.get(thechar)+1 );
      }
      else 
      {
        aMap.put(thechar, 1 );
      }
    }

    for(int i  = 0; i< bWord.length() ; i++)
    {
      Character thechar = bWord.charAt(i);
      if(bMap.containsKey(thechar))
      {
        bMap.put(thechar, bMap.get(thechar)+1 );
      }
      else 
      {
        bMap.put(thechar, 1 );
      }
    }
    
    if(aMap.equals(bMap))
      return true;
    else 
      return false;  
    
    
  }
}

 