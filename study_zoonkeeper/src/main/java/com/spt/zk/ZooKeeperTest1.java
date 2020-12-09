package com.spt.zk;

import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author: start-spt
 * @Create: 2020/12/5 21:33
 */
public class ZooKeeperTest1 {

    public static void main(String[] args) throws IOException {
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183", 300000, new DemoWatcher());//连接zk server
        if (!zk.getState().equals(ZooKeeper.States.CONNECTED)) {
            while (true) {
                if (zk.getState().equals(ZooKeeper.States.CONNECTED)) {
                    break;
                }
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
