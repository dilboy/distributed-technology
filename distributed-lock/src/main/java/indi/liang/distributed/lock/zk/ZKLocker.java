package indi.liang.distributed.lock.zk;

import java.util.concurrent.TimeUnit;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import indi.liang.distributed.lock.Locker;

/**
 * @author L.liang
 * @date 2021/6/18
 * @time 10:40 上午
 */
public class ZKLocker implements Locker {

    static CuratorFramework client;

    private static String zookeeperConnectionString = "localhost:2181";

    static {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory.newClient(zookeeperConnectionString, retryPolicy);
        client.start();
    }

    private String lockPath = "/lockPath";

    private long maxWait = 10;

    private TimeUnit waitUnit = TimeUnit.SECONDS;

    public void lock(String lockKey) throws Exception {
        InterProcessMutex lock = new InterProcessMutex(client, lockPath);
        if (lock.acquire(maxWait, waitUnit)) {
            try {
                // do some work inside of the critical section here
                System.out.println("locking ...............");
            } finally {
                lock.release();
            }
        }
    }

    @Override
    public void release(String lockKey) {

    }

}
