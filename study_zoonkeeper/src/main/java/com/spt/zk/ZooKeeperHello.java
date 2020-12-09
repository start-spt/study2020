package com.spt.zk;

import java.io.IOException;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

public class ZooKeeperHello {

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 300000, new DemoWatcher()); //连接zk server
        String node = "/app1";
        Stat stat = zk.exists(node, false); //检测/app1是否存在
        if (stat == null) {
            //创建节点
            String createResult = zk.create(node, "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println("创建节点,createResult:" + createResult);
        }
        //获取节点的值
        byte[] b = zk.getData(node, false, stat);
        System.out.println("获取节点的值:" + new String(b));
        zk.close();
    }
}