import java.net.InetSocketAddress;

public class testExaple {


    public static void main(String[] args) {
        // Connecting to Memcached server on localhost
        MemcachedClient mcc = new MemcachedClient(new
                InetSocketAddress("127.0.0.1", 11211));
        System.out.println("Connection to server sucessfully");

        //not set data into memcached server
        System.out.println("set status:"+mcc.set("tutorialspoint", 900, "memcached").done);

        //Get value from cache
        System.out.println("Get from Cache:"+mcc.get("tutorialspoint"));
    }
    }
}
