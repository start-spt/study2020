import org.I0Itec.zkclient.ZkClient;
import org.junit.Test;

/**
 * @Author: start-spt
 * @Create: 2020/12/5 21:44
 */
public class ZooKeeperTest {
    @Test
    public void testZkClient(){
        ZkClient zkClient=new ZkClient("127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183");
        String node="/app2";
        if(!zkClient.exists(node)){
            zkClient.createPersistent(node,"hello zk");
        }
        System.out.println((String) zkClient.readData(node));
    }
}
