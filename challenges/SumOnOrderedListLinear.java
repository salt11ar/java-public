import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * solution should be O (askldfjaskldfjñklñjkl)
 */
public class SumOnOrderedListLinear {
    
    public static void main(String[] args)
    {
        //input array is ordered 
        List<Integer> list = Arrays.asList(1,2,3,4);
       
        boolean b = sol(list, 3); 
        System.out.println(b);
    }

    public static boolean sol(List<Integer> input, int x)
    {
     
        //TODO change to set
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(Integer i : input)
        {
            map.put(i, i);
        }
        
        for(int i = 0; i< input.size()-1; i++){
            Integer substract = x - input.get(i) ;
            if(map.containsKey(substract))
                return true;
        }

        return false;

    }
}
