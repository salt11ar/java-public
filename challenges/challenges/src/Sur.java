public class Sur {


  public static void main(String[] args) {
      //int n=529;  //max 2147483647
    int nResult = solution1(529);
  System.out.println("Result: " + nResult);
     
       nResult = solution1(-999);
       nResult = solution1(268);
      System.out.println("Result: " + nResult);
    
       nResult = solution2(111);
      System.out.println("Result: " + nResult);
    

    }

/*de un numero convertido a binario saca el numero de partes iguales */
  static public int solution2(int n)
  {

    int[] d = new int[Integer.toBinaryString(n).length()];

    int len= Integer.toBinaryString(n).length();
    
    System.out.println("input strlen: "+ len);

    int l = 0;
    int p;
    while (n > 0) {
        d[l] = n % 2;
        n /= 2;
        l++;
    }
    for (p = 1; p < l+1 ; ++p) {
        int i;
        boolean ok = true;
        for (i = 0; i < l - p; ++i) {
            if (d[i] != d[i + p]) {
                ok = false;
                break;
            }
        }
        if (ok) {
            return p;
        }
    }
    return -1;

  }

  static public int solution1(int n)
  {

    int i = 0;
    int max = 0;
    char five='5';
    int inti;
    int beginIndex = 0;
    int endIndex=0;
    int nSignMultiply =1;
    int strlen;
    String str;

    
    System.out.println("input integer: "+ n);
    //System.out.println("five: "+ five);
    //cycle by inserting 5 from -1 pos to len +1

    String strOriginal= Integer.toString(n);
    System.out.println("strOriginal: "+ strOriginal);
    strlen = strOriginal.length();
    System.out.println("input strlen: "+ strlen);

//remove  the sign if negative
    if(n <0 )
    {
      System.out.println("n negative ");
      str = strOriginal.substring(1, strlen);   //erase sign
      nSignMultiply = -1;
      
      String strMax= five+str ;
      max =  nSignMultiply * Integer.parseInt(strMax);

    }
    else
    {
      System.out.println("n positive ");
      str = strOriginal;
      nSignMultiply = 1;
    }

    strlen = str.length();
    System.out.println("str: "+ str);
    System.out.println("new strlen: "+ strlen);


    
    String stri;
    String firststr;
    String secondstr;

    i = 0;

    while (i < strlen+1  )
    {
      System.out.println("i: "+ i);


      if(i ==0 ) //if cero copy in front
      {
        stri= five+str ;
        System.out.println("stri: "+ stri);
        
        inti =  nSignMultiply *  Integer.parseInt(stri);
        System.out.println("inti: "+ inti);  
      }
      else if(i > strlen -1) //if reached last char copy in the back
      {
        stri= str + five ;
        System.out.println("stri: "+ stri);
        
        inti =  nSignMultiply * Integer.parseInt(stri);
        System.out.println("inti: "+ inti);  
        //break;
      }
      else // we put the five in the middle
      {
        beginIndex = 0;
        endIndex=strlen-1;
        firststr = str.substring(beginIndex, i); 
        secondstr = str.substring(i, endIndex+1);
        
        stri= firststr+five+secondstr ;

        System.out.println("stri: "+ stri);
        
        inti =  nSignMultiply *  Integer.parseInt(stri);
        System.out.println("inti: "+ inti);  

      }

      if(inti > max )
      {
        System.out.println("new max, previous: "+ max+ "new: "+ inti);
        max = inti;
      }
  
      i++;      

    }

    return max;
    

  }

  static public int solution(int N)
  {
    int n=N;
    int maxGap = 0;
    int i = 0;
    int igap= 0;

    System.out.println("input integer: "+ n);
    //convert to binary 
    String str = Integer.toBinaryString(n);
    System.out.println("input string: "+ str);
    int strlen = str.length();
    System.out.println("input strlen: "+ strlen);

    //find first 1 

    int firstIndex = str.indexOf('1');
    System.out.println("1st i: "+ firstIndex);
    System.out.println("1st char: "+ str.charAt(i));
   
    i = firstIndex+1;

    while (i < strlen -1 )
    {
      igap=0; //reset for next gap loop
      System.out.println("start loop... ");

        while (str.charAt(i) == '0' )
        {
          System.out.println("i: "+ i);
          System.out.println("char: "+ str.charAt(i));
          i++;
          igap++;
          //System.out.println("igap: "+ igap);

          if(i > strlen-1)      
            break; //exit from cero detection if no more chars
          
        }

        System.out.println("break on loop for ceros, i:"+ i);

        if(i > strlen-1)  
        {
          System.out.println("breaking..." );
          break;
        }
        
        if (str.charAt(i) =='1')
        {
          System.out.println("gap valid, cause found a 1 at: " +i);
          if(igap>maxGap )
          {
            System.out.println("new maxgap, previous: "+ maxGap+ "new: "+ igap);
            maxGap = igap;
          }
       
        }
        else
        {
          System.out.println("not 1. breaking..." );
          break;
        }
        
        //ṕerf improvement
        //seek to next 1 before a cero 
        //i = str.indexOf('0');

        i++;

    }

    
    System.out.println("Result: " + maxGap);
    return maxGap; 

  }



   
}


