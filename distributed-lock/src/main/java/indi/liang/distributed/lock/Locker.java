package indi.liang.distributed.lock;

/**
 * @author L.liang
 * @date 2021/6/18
 * @time 10:30 上午
 */
public interface Locker {

    void lock(String lockKey) throws Exception;

    void release(String lockKey);

}
