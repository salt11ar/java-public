package edu.examples;

import java.util.Hashtable;
import java.util.Map;

public class HasTableExample {

    
        /* uses {@link MarineShip}
         * @see MarineShip
        */
        public static void main(String[] args) {
        Hashtable<Integer, String> table = new Hashtable<Integer, String>();
        
        table.put(1, "one");
        table.put(2, "two");
        table.put(3, "three");
        
        System.out.println("table: " + table);
        if (table.containsKey(2)){
            System.out.println("value found for: "+ table.get(2) );
        }

        for (Map.Entry<Integer, String> entry : table.entrySet()){
            System.out.println("key"+entry.getKey()+"="+entry.getValue());
        }
        //hashtable with more complex object MarineShip must implement equals and hashCode
        Hashtable<Integer, MarineShip> tablehouses = new Hashtable< Integer, MarineShip>();

        tablehouses.put(1, new MarineShip());
        tablehouses.get(1).go();

        
    }

}
    
