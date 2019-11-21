import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

public class RedisClusterApp {
    public static void main(String[] args) {
        Set<HostAndPort> hostAndPorts = new HashSet<HostAndPort>();
        HostAndPort h1 = new HostAndPort("192.168.111.128", 6379);
        HostAndPort h2 = new HostAndPort("192.168.111.128", 6380);
        HostAndPort h3 = new HostAndPort("192.168.111.129", 6379);
        HostAndPort h4 = new HostAndPort("192.168.111.129", 6380);
        HostAndPort h5 = new HostAndPort("192.168.111.130", 6379);
        HostAndPort h6 = new HostAndPort("192.168.111.130", 6380);
        hostAndPorts.add(h1);
        hostAndPorts.add(h2);
        hostAndPorts.add(h3);
        hostAndPorts.add(h4);
        hostAndPorts.add(h5);
        hostAndPorts.add(h6);
        JedisCluster jedisCluster = new JedisCluster(hostAndPorts);
        String result = jedisCluster.set("company", "linewell");
        System.out.println("result:" + result);

        String value = jedisCluster.get("company");
        System.out.println("value :" + value);
    }
}
