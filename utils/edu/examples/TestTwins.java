package edu.examples;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TestTwins {
	
    /**
     * Complete the function below.
     * DO NOT MODIFY anything outside this method. 
     */
    static String[] twins(String[] a, String[] b) 
    {
        int num;
        
        if(a.length < b.length)
            num = a.length; 
        else 
            num = b.length; 
            
        // keep the lowest number of items 
        
        String[] res = new String[num]; 

        for( int i =0 ; i<  num  ; i++)
        {
            if (checkTwin(a[i],b[i]))
                res[i] = new String("Yes");
            else 
                res[i] = new String("No");
        }
        return res; 
        
    }

    static boolean checkTwin(String ai, String bi) 
    {

        if (ai.compareTo(bi)== 0)
            return true;

        if (ai.length() != bi.length()) 
            return false;
        
        byte[] barr = new byte[ai.length()];

        for(int i = 0 ; i < ai.length(); i++)
        {
            byte aux;
            //replace all evens and odds to see if the result is twin of b
            if(i+2 < ai.length())
            { 


                //inside len then replace chars
              barr = ai.getBytes();

              System.out.println("changing i "+ i +" with i+2 " + (i+2) );
              System.out.println("changing  "+ new Byte(barr[i]).toString() +" with i+2 " + new Byte(barr[i+2]).toString() );
              aux = barr[i+1];
              barr[i+1] = barr[i];
              barr[i] = aux;

              System.out.println("changed i "+ barr[i] +" with i+2" + barr[i+2] );
              
            }

        }
        System.out.println( new String(barr));
        if (barr.toString().equals(bi))
            return true;
        else 
            return false;
    }
    /**
     * DO NOT MODIFY THIS METHOD!
     */
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        String[] res;
        
        int _a_size = 0;
        _a_size = Integer.parseInt(in.nextLine().trim());
        String[] _a = new String[_a_size];
        String _a_item;
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            try {
                _a_item = in.nextLine();
            } catch (Exception e) {
                _a_item = null;
            }
            _a[_a_i] = _a_item;
        }
        
        
        int _b_size = 0;
        _b_size = Integer.parseInt(in.nextLine().trim());
        String[] _b = new String[_b_size];
        String _b_item;
        for(int _b_i = 0; _b_i < _b_size; _b_i++) {
            try {
                _b_item = in.nextLine();
            } catch (Exception e) {
                _b_item = null;
            }
            _b[_b_i] = _b_item;
        }
        
        res = twins(_a, _b);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }
        in.close();
    } 

}