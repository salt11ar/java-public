import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * AgileEngine Challenge from codility
 * 
 * 
 */

public class UserStatsChallenge {

    public static void main(String[] args) {

        UserStats stats1 = new UserStats();
        stats1.setVisitCount(Optional.of(100L));
        UserStats stats2 = new UserStats();
        
        Map<String, UserStats> statsmap = new HashMap<String, UserStats>();
        statsmap.put("1", stats1);
        statsmap.put("2", stats1);
        statsmap.put("3", stats1);
        statsmap.put("4", stats2); // null visit count value 
             
        Map<String, UserStats> statsmap2 = new HashMap<String, UserStats>();
        statsmap.put("5", stats1);
        statsmap.put("6", stats1);
        
        Map<String, UserStats>[] stats = (Map<String, UserStats>[]) new HashMap<?,?>[2];
        stats[0] = statsmap;
        stats[1] = statsmap2;

        System.out.println("input" + statsmap);
        Map<Long, Long> result = count(stats);
        System.out.println("result= "+ result);
        
        
    }
    

    static Map<Long, Long> count(Map<String, UserStats>... visits) {
        Map<Long, Long> resultmap = new HashMap<Long, Long>();

        List<Map<String, UserStats>> aslist  = Arrays.asList(visits);
        System.out.println(aslist);

        if(visits == null || visits.length == 0) 
            return resultmap;
  
       for (Map<String,UserStats> themap : aslist) {
                 System.out.println(themap);
       }

                            
        Map<Long, Long> collect2 = aslist.stream()
                            .flatMap(m -> m.entrySet().stream())
                            .filter((t) -> t.getKey() != null)
                            .filter((t) -> t.getKey().isEmpty() == false)
                            .filter((t) -> t.getValue().getVisitCount() != null)
                            .filter( t -> t.getValue().getVisitCount().isPresent()) // filter empty  visitCount 
                            .collect(Collectors.toMap(k -> Long.parseLong( k.getKey()), v -> v.getValue().getVisitCount().get(), Long::sum));
                                 
        
       System.out.println(collect2);


        return collect2;
    }
}
