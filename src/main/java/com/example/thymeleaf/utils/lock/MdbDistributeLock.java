package com.example.thymeleaf.utils.lock;

public class MdbDistributeLock {
}

/*
public class MdbDistributeLock implements DistributeLock {

    */
/**
 * 锁的命名空间
 * <p>
 * 锁对应的缓存key
 * <p>
 * 锁的唯一标识，保证可重入，以应对put成功，但是返回超时的情况
 * <p>
 * 是否持有锁。true：是
 * <p>
 * 缓存实例
 * <p>
 * 判断是否需要重试
 *
 * @param resultCode 缓存的返回码
 * @return true：不用重试
 *//*

    private final int namespace;

    */
/**
 * 锁对应的缓存key
 *//*

    private final String lockName;

    */
/**
 * 锁的唯一标识，保证可重入，以应对put成功，但是返回超时的情况
 *//*

    private final String lockId;

    */
/**
 * 是否持有锁。true：是
 *//*

    private boolean locked;

    */
/**
 * 缓存实例
 *//*

    private final TairManager tairManager;

    public MdbDistributeLock(TairManager tairManager, int namespace, String lockCacheKey) {

        this.tairManager = tairManager;
        this.namespace = namespace;
        this.lockName = lockCacheKey;
        this.lockId = UUID.randomUUID().toString();
    }

    @Override
    public boolean tryLock() {

        try {
            //获取锁状态
            Result<DataEntry> getResult = null;
            ResultCode getResultCode = null;
            for (int cnt = 0; cnt < DEFAULT_RETRY_TIMES; cnt++) {
                getResult = tairManager.get(namespace, lockName);
                getResultCode = getResult == null ? null : getResult.getRc();
                if (noNeedRetry(getResultCode)) {
                    break;
                }
            }

            //重入，已持有锁，返回成功
            if (ResultCode.SUCCESS.equals(getResultCode)
                    && getResult.getValue() != null && lockId.equals(getResult.getValue().getValue())) {
                locked = true;
                return true;
            }

            //不可获取锁，返回失败
            if (!ResultCode.DATANOTEXSITS.equals(getResultCode)) {
                log.error("tryLock fail code={} lock={} traceId={}", getResultCode, this, EagleEye.getTraceId());
                return false;
            }

            //尝试获取锁
            ResultCode putResultCode = null;
            for (int cnt = 0; cnt < DEFAULT_RETRY_TIMES; cnt++) {
                putResultCode = tairManager.put(namespace, lockName, lockId, MDB_CACHE_VERSION,
                        DEFAULT_EXPIRE_TIME_SEC);
                if (noNeedRetry(putResultCode)) {
                    break;
                }
            }
            if (!ResultCode.SUCCESS.equals(putResultCode)) {
                log.error("tryLock fail code={} lock={} traceId={}", getResultCode, this, EagleEye.getTraceId());
                return false;
            }
            locked = true;
            return true;

        } catch (Exception e) {
            log.error("DistributedLock.tryLock fail lock={}", this, e);
        }
        return false;
    }

    @Override
    public void unlock() {

        if (!locked) {
            return;
        }
        ResultCode resultCode = tairManager.invalid(namespace, lockName);
        if (!resultCode.isSuccess()) {
            log.error("DistributedLock.unlock fail lock={} resultCode={} traceId={}", this, resultCode,
                    EagleEye.getTraceId());
        }
        locked = false;
    }

    */
/**
 * 判断是否需要重试
 *
 * @param resultCode 缓存的返回码
 * @return true：不用重试
 *//*

    private boolean noNeedRetry(ResultCode resultCode) {
        return resultCode != null && !ResultCode.CONNERROR.equals(resultCode) && !ResultCode.TIMEOUT.equals(
                resultCode) && !ResultCode.UNKNOW.equals(resultCode);
    }

}
*/
