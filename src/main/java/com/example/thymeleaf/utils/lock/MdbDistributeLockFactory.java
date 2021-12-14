package com.example.thymeleaf.utils.lock;

public class MdbDistributeLockFactory{}

/*public class MdbDistributeLockFactory implements DistributeLockFactory {

    *//**
     * 缓存的命名空间
     *//*
    @Setter
    private int namespace;

    @Setter
    private MultiClusterTairManager mtairManager;

    @Override
    public DistributeLock getLock(String lockName) {
        return new MdbDistributeLock(mtairManager, namespace, lockName);
    }
}*/
