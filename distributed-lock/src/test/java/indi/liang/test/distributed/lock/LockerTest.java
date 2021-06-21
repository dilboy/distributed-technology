package indi.liang.test.distributed.lock;

import org.junit.Test;

import indi.liang.distributed.lock.Locker;
import indi.liang.distributed.lock.zk.ZKLocker;

/**
 * @author L.liang
 * @date 2021/6/21
 * @time 10:09 上午
 */
public class LockerTest {

    @Test
    public void testLock() throws Exception {
        final Locker locker = new ZKLocker();
        locker.lock("test");
    }

}
