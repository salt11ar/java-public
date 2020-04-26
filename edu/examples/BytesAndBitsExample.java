/**
 * 
 */
package edu.examples;

import java.lang.*;
import java.io.*;
import java.util.*;

/**
 * @author stomasini 05/06/2012
 *
 */

public interface Ship {
    void go();
}

public class MarineShip implements Ship {
    public void go() {
        System.out.println("Sea surface");
    }
}

public class Submarine extends MarineShip{
    public void go() {
        System.out.println("Underwater");
    }
}


public class BytesAndBitsExample
{

	/**
	 * 
	 */
	public BytesAndBitsExample()
	{
		// TODO Auto-generated constructor stub
	}

	public static String removeZero(String str)
    {
        // Count trailing zeros
        int i = 0;
        while (str.charAt(i) == '0')
            i++;
 
        // Convert str into StringBuffer as Strings
        // are immutable.
        StringBuffer sb = new StringBuffer(str);
 
        // The  StringBuffer replace function removes
        // i characters from given index (0 here)
        sb.replace(0, i, "");
 
        return sb.toString();  // return in String
    }
 
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
			MarineShip submarine = new Submarine();
			((Submarine)submarine).go();
	 
//			Byte yesno = new Byte("0x01");
//			System.out.println( "yesno: "+ yesno.toString( )); 
		
			byte[] arrayofBytes = new byte[] { 0x11, 0x11, (byte) 0xAA, (byte) 0xBB }; // 286370491
			
			byte[] bcd = new byte[]{0x10, 0x01, 0x11}; 
			
			System.out.println("arrayofBytes: "+ arrayofBytes);
			System.out.println("bcd: "+ bcd);
			
			Byte b1 = Byte.decode("10");
			Byte bequal1 = Byte.valueOf("10");
			Byte b2 = Byte.valueOf((byte)0x01);
			Byte b3 = Byte.decode("0x05");
			Byte b4 = Byte.valueOf("A", 16);
			
			System.out.println("b1: "+ b1);
			System.out.println("bequal1: "+ bequal1);
			System.out.println("b2: "+ b2);
			System.out.println("b3: "+ b3);
			System.out.println("b4: "+ b4);
			System.out.println("b4 int value: "+ b4.intValue());
			System.out.println("compare b1 and b4 : ");
			
			 // This is a string in which a character
    // to be searched.
    String str = "GeeksforGeeks is a computer science portal";
 
    // Returns index of first occurrence of character.
    int firstIndex = str.indexOf('s');
    System.out.println("First occurrence of char 's'" +
                       " is found at : " + firstIndex);
 
    // Returns index of last occurrence specified character.
    int lastIndex = str.lastIndexOf('s');
    System.out.println("Last occurrence of char 's' is" +
                       " found at : " + lastIndex);
 
    // Index of the first occurrence of specified char
    // after the specified index if found.
    int first_in = str.indexOf('s', 10);
    System.out.println("First occurrence of char 's'" +
                       " after index 10 : " + first_in);
 
    int last_in = str.lastIndexOf('s', 20);
    System.out.println("Last occurrence of char 's'" +
                     " after index 20 is : " + last_in);
 
    // gives ASCII value of character at location 20
    int char_at = str.charAt(20);
    System.out.println("Character at location 20: " +
                                             char_at);
 
	String test = "software";

	CharSequence seq = "soft";
	boolean bool = test.contains(seq);
	System.out.println("Found soft?: " + bool);
		
	
	String strzero = "00000123569";
	strzero = removeZero(strzero);
	System.out.println(strzero);
	StringBuffer sb = new StringBuffer(strzero);
	System.out.println( "reversed: " + sb.reverse().toString());

	str = "geekss@for@geekss";
	String [] arrOfStr = str.split("@", 2);

	for (String a : arrOfStr)
		System.out.println(a);
	
	char[] chrArray = str.toCharArray();

	for (char var : chrArray) {
		System.out.print(var);
	}

	System.out.println( " ");


	String input = "Geeks For Geeks";
	char[] hello = input.toCharArray();
	List<Character> trial1 = new ArrayList<>();
	
	Bag b;
	b.add()
	

	for (char c: hello)
		trial1.add(c);

	Collections.reverse(trial1);
	ListIterator li = trial1.listIterator();
	while (li.hasNext())
		System.out.print(li.next());
			}






	
}
