import java.util.HashMap;

public class Graph {
    
    HashMap<String, Double> distances = new HashMap<>();
    HashMap<String, Double> times = new HashMap<>();
    Edge[] distanceEdges = new Edge[14];
    Edge[] timeEdges = new Edge[14];

    public Graph(){
;
        distanceEdges[0] = new Edge("home", "High_Quality_Shirt", 5);
        distanceEdges[1] = new Edge("High_Quality_Shirt",  "home", 5);
        distanceEdges[2] = new Edge("home",  "High_Quality_Pants", 4);
        distanceEdges[3] = new Edge("High_Quality_Pants", "home", 4);
        distanceEdges[4] = new Edge("High_Quality_Shirt", "Pants_And_Shirts", 3);
        distanceEdges[5] = new Edge("Pants_And_Shirts", "High_Quality_Shirt", 3);
        distanceEdges[6] = new Edge("High_Quality_Pants", "High_Quality_Shirt", 6);
        distanceEdges[7] = new Edge("High_Quality_Shirt", "High_Quality_Pants", 6);
        distanceEdges[8] = new Edge("Pants_And_Shirts", "High_Quality_Pants", 5);
        distanceEdges[9] = new Edge("High_Quality_Pants", "Pants_And_Shirts", 5);
        distanceEdges[10] = new Edge("Pants_And_Shirts", "Shoe_Store", 2);
        distanceEdges[11] = new Edge("Shoe_Store", "Shoe_Store", 2);
        distanceEdges[12] = new Edge("Underwear_Shirt_Store", "Everything_Store", 3);
        distanceEdges[13] = new Edge("Everything_Store", "Underwear_Shirt_Store", 3);

        timeEdges[0] = new Edge("home", "High_Quality_Shirt", 10);
        timeEdges[1] = new Edge("High_Quality_Shirt",  "home", 10);
        timeEdges[2] = new Edge("home",  "High_Quality_Pants", 3);
        timeEdges[3] = new Edge("High_Quality_Pants", "home", 3);
        timeEdges[4] = new Edge("High_Quality_Shirt", "Pants_And_Shirts", 4);
        timeEdges[5] = new Edge("Pants_And_Shirts", "High_Quality_Shirt", 4);
        timeEdges[6] = new Edge("High_Quality_Pants", "High_Quality_Shirt", 2);
        timeEdges[7] = new Edge("High_Quality_Shirt", "High_Quality_Pants", 2);
        timeEdges[8] = new Edge("Pants_And_Shirts", "High_Quality_Pants", 1);
        timeEdges[9] = new Edge("High_Quality_Pants", "Pants_And_Shirts", 1);
        timeEdges[10] = new Edge("Pants_And_Shirts", "Shoe_Store", 9);
        timeEdges[11] = new Edge("Shoe_Store", "Shoe_Store", 9);
        timeEdges[12] = new Edge("Underwear_Shirt_Store", "Everything_Store", 6);
        timeEdges[13] = new Edge("Everything_Store", "Underwear_Shirt_Store", 6);
        

    }

    private void bellmanFord(String src) {
        
        distances.put("home", (double) Integer.MAX_VALUE);
        distances.put("High_Quality_Shirt", (double)Integer.MAX_VALUE);
        distances.put("High_Quality_Pants", (double)Integer.MAX_VALUE);
        distances.put("Pants_And_Shirts", (double)Integer.MAX_VALUE);
        distances.put("Shoe_Store", (double)Integer.MAX_VALUE);
        distances.put("Underwear_Shirt_Store", (double)Integer.MAX_VALUE);
        distances.put("Everything_Store", (double)Integer. MAX_VALUE);
        times.put("home", (double) Integer.MAX_VALUE);
        times.put("High_Quality_Shirt", (double)Integer.MAX_VALUE);
        times.put("High_Quality_Pants", (double)Integer.MAX_VALUE);
        times.put("Pants_And_Shirts", (double)Integer.MAX_VALUE);
        times.put("Shoe_Store", (double)Integer.MAX_VALUE);
        times.put("Underwear_Shirt_Store", (double)Integer.MAX_VALUE);
        times.put("Everything_Store", (double)Integer. MAX_VALUE);

        distances.put(src,0.0);
        
        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                String u = distanceEdges[j].source;
                String v = distanceEdges[j].destination;
                double weight = distanceEdges[j].weight;
                if (distances.get(u) != Integer.MAX_VALUE && distances.get(u) + weight < distances.get(v))
                    distances.put(v, distances.get(u) + weight);
            }
        }

        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                String u = timeEdges[j].source;
                String v = timeEdges[j].destination;
                double weight = timeEdges[j].weight;
                if (times.get(u) != Integer.MAX_VALUE && times.get(u) + weight < times.get(v))
                    times.put(v, times.get(u) + weight);
            }
        }
        
    }
    

    public void setData(Store start, Store[] allStores){
        bellmanFord(start.toString());

        for (int i=0;i<6;i++){
            Store currStore = allStores[i];
            currStore.setDistance(distances.get(currStore.toString()));
            currStore.setTime(times.get(currStore.toString()));

        }
        
    }

    public void setData(String start, Store[] allStores){
        bellmanFord(start.toString());

        for (int i=0;i<6;i++){
            Store currStore = allStores[i];
            currStore.setDistance(distances.get(currStore.toString()));
            currStore.setTime(times.get(currStore.toString()));

        }
        
    }

    

    

    public double homeDistance(){
        return distances.get("home");
    }

    public double homeTime(){
        return times.get("home");
    }

    

    
}
