# distributed lock
## zk locker
zookeeper 的 好伴侣curator 有提供基于 zookeeper的一些列分布式工具（依赖其CP特性），其中就包含了分布式锁的实现，而且不只是分布式锁，还是分布式可重入锁以及分布式读写锁等，但是碍于zk的强CP特性，性能可能会稍有影响，所以还需要根据实际场景来选择使用。
## redis locker 
