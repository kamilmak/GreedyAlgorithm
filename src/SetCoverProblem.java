import java.util.*;

public class SetCoverProblem {

    /*  Solving set-covering problem on the example of minimize the number of station and reach all listeners.

    Set of station and the region which is covered by this station.
    - s1: ID, NV , UT
    - s2: WA, ID, MT
    - s3: OR, NV, CA
    - s4: NV, UT
    - S5: CA, AZ

     */

    public static void main(String[] args) {
       Set <String>  areasLeft = new HashSet<>(Arrays.asList("ID", "NV", "UT", "WA", "MT", "OR", "CA", "AZ"));

        Map<String, Set<String>> stations = new LinkedHashMap<>();

       stations.put("setS1", new HashSet<> (Arrays.asList("ID", "NV", "UT")));
       stations.put("setS2", new HashSet<>(Arrays.asList("WA", "ID", "MT")));
       stations.put("setS3", new HashSet<>(Arrays.asList("OR", "NV", "CA")));
       stations.put("setS4", new HashSet<>(Arrays.asList("NV", "UT")));
       stations.put("setS5", new HashSet<>(Arrays.asList("CA", "AZ")));

       Set <String> finalStations = new HashSet<>();


       while (!areasLeft.isEmpty()){
           String bestStation = null;
           Set <String> areasCovered = new HashSet<>();

               for (Map.Entry<String, Set<String>> station : stations.entrySet()) {
                   Set<String> covered = new HashSet<>(areasLeft);
                   covered.retainAll(station.getValue());

                   if (covered.size() > areasCovered.size()){
                       bestStation = station.getKey();
                       areasCovered = covered;

               }
                   areasLeft.removeIf(areasCovered::contains);

                   if (bestStation != null){
                       finalStations.add(bestStation);
                   }
           }

       }
        System.out.println(finalStations);



    }}





