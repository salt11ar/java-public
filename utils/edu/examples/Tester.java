package edu.examples;

import java.io.IOException;
import java.util.Scanner;

public class Tester {
	
    /**
     * Complete the function below.
     * DO NOT MODIFY anything outside this method. 
     */
    static int[] balancedOrNot(String[] expressions, int[] maxReplacements) {
        
        int num = expressions.length; 
        int[] res = new int[num]; 
        System.out.println("num of expressions ="+ num);

        //for each expression
        for( int i =0 ; i<  num  ; i++)
        {
            //check next expression is balanced balanced
            //count number of < without > 
            int numOfUnbalanced = 0; 

            System.out.println("expression i = " + i  );
            System.out.println("len =" + ( expressions[i].length() ));

            for(int m =0 ; m <= expressions[i].length()-1 ; m++ )
            {
                if (expressions[i].charAt(m)  == '<' ) 
                { 

                    if (m+1 < expressions[i].length())
                        if(expressions[i].charAt(m+1) != '>')
                        {
                            //found a replacement 
                            System.out.println("found a replacement at position m " + m);
                            numOfUnbalanced++;
                        }
                    else
                    {
                            //found a replacement 
                            System.out.println("found a replacement at LAST POS m " + m);
                            numOfUnbalanced++;
                    }


                }

            }    
            System.out.println("num of replacements found = " + numOfUnbalanced);
            System.out.println("max = " +  maxReplacements[i]); 

            if( numOfUnbalanced > maxReplacements[i])
                res[i] = 0;
            else 
                res[i] = 1;
                 

        }
        
        return res;
    }

    /**
     * DO NOT MODIFY THIS METHOD!
     */
     public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int[] res;
        
        int _expressions_size = 0;
        _expressions_size = Integer.parseInt(in.nextLine().trim());
        String[] _expressions = new String[_expressions_size];
        String _expressions_item;
        for (int _expressions_i = 0; _expressions_i < _expressions_size; _expressions_i++) {
            try {
                _expressions_item = in.nextLine();
            } catch (Exception e) {
                _expressions_item = null;
            }
            _expressions[_expressions_i] = _expressions_item;
        }
        
        int _maxReplacements_size = 0;
        _maxReplacements_size = Integer.parseInt(in.nextLine().trim());
        int[] _maxReplacements = new int[_maxReplacements_size];
        int _maxReplacements_item;
        for (int _maxReplacements_i = 0; _maxReplacements_i < _maxReplacements_size; _maxReplacements_i++) {
            _maxReplacements_item = Integer.parseInt(in.nextLine().trim());
            _maxReplacements[_maxReplacements_i] = _maxReplacements_item;
        }
        
        res = balancedOrNot(_expressions, _maxReplacements);
        for (int res_i = 0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }
        in.close();
    }
}