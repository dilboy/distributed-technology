package indi.liang.distributed.lock.redis;

import indi.liang.distributed.lock.Locker;

/**
 * @author L.liang
 * @date 2021/6/21
 * @time 11:54 上午
 */
public class RedisLocker implements Locker {

    @Override
    public void lock(String lockKey) throws Exception {

    }

    @Override
    public void release(String lockKey) {

    }

}
