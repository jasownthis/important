package Cache;

import java.util.*;

public class Cache {

    class CacheNode{
        String key;
        String value;
        long timeToLive;

        public CacheNode(String key, String value, long timeToLive){
            this.key = key;
            this.value = value;
            this.timeToLive = timeToLive;
        }
    }

    private LinkedHashMap<String, CacheNode> cacheMap;
    private LinkedList<String> res;
    int maxCache = 10;

    Cache(){
        this.cacheMap = new LinkedHashMap<>();
        this.res = new LinkedList<>();
    }

    public void setCache(String key, String value, int timeToLive){
        long currentTime  = System.currentTimeMillis();
        long expiryTime = currentTime + timeToLive;

        CacheNode Node = new CacheNode(key, value, expiryTime);
        cacheMap.put(key, Node);
    }

    public String getCache(String key){
        if(!cacheMap.containsKey(key)) return null;

        CacheNode node = cacheMap.get(key);
        long currentTime  = System.currentTimeMillis();
        if(currentTime > node.timeToLive){
            cacheMap.remove(key);
            return null;
        }


        recentAccessed(key);
        return node.value;
    }

    public void recentAccessed(String key){
        res.remove(key);
        res.addFirst(key);
        if(res.size() > maxCache) res.removeLast();
    }

    public String[] getRecentlyUsed(){
        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Cache cache = new Cache();

        // Example usage
        cache.setCache("1", "Sam", 600);  // Expiry 600 seconds
        cache.setCache("2", "Anand", 1000);  // Expiry 1000 seconds

        System.out.println(cache.getCache("2"));  // Output: Anand

        // Simulate after 600 seconds (you'd need to wait 600 seconds to see this)
        System.out.println(cache.getCache("1"));  // Output: null (if more than 600 seconds have passed)

        // Recently accessed cache
        System.out.println(Arrays.toString(cache.getRecentlyUsed()));  // Output: [2]
    }
}
