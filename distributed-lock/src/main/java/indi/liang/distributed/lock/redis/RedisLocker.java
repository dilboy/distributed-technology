package indi.liang.distributed.lock.redis;

import java.util.concurrent.TimeUnit;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import indi.liang.distributed.lock.Locker;

/**
 * @author L.liang
 * @date 2021/6/21
 * @time 11:54 上午
 */
public class RedisLocker implements Locker {

    private static RedissonClient redisson;


    static {
        // 1. Create config object
        Config config = new Config();
        config
            .useSingleServer()
            .setAddress("redis://127.0.0.1:6379");
//            .useClusterServers()
            // use "rediss://" for SSL connection
//            .addNodeAddress("redis://127.0.0.1:6379");
        // 2. Create Redisson instance
        // Sync and Async API
        redisson = Redisson.create(config);
    }

    @Override
    public void lock(String lockKey) throws Exception {
        RLock lock = redisson.getLock("myLock");
        // or acquire lock and automatically unlock it after 10 seconds
        lock.lock(10, TimeUnit.SECONDS);

        // or wait for lock aquisition up to 100 seconds
        // and automatically unlock it after 10 seconds
        boolean res = lock.tryLock(100, 10, TimeUnit.SECONDS);
        if (res) {
            try {
            } finally {
                lock.unlock();
            }
        }
    }

    @Override
    public void release(String lockKey) {

    }

}
