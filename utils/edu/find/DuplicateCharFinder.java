

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateCharFinder {
	
	public void findIt(String str) {
		Map<Character, Integer> basemap = new HashMap<Character, Integer>();
        char[] charArray = str.toCharArray();
        for(Character ch: charArray) {
            if (basemap.containsKey(ch))
                basemap.put(ch, basemap.get(ch)+1);
            else
                basemap.put(ch, 1);
        }

        Set<Character> keys = basemap.keySet();
        for(Character ch : keys){
            if(basemap.get(ch) > 1 )
                System.out.println(ch + "  is " + basemap.get(ch) + " times");
        }

	}

	public static void main(String a[]) {
		DuplicateCharFinder dcf = new DuplicateCharFinder();
        String str = "Argentina is my country";
        System.out.println(str);
		dcf.findIt(str);

	}
}