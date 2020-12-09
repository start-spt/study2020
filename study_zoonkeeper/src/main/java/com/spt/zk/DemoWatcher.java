package com.spt.zk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

public class  DemoWatcher  implements Watcher {
         @Override
         public  void  process(WatchedEvent event) {
             System.out.println( "----------->" );
             System.out.println( "path:"  + event.getPath());
             System.out.println( "type:"  + event.getType());
             System.out.println( "stat:"  + event.getState());
             System.out.println( "<-----------" );
         }
     }