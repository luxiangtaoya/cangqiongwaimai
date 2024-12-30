package com.sky.context;

/**
 * BaseContext类提供了线程安全的上下文管理，主要用于在跨不同操作或服务调用的环境中
 * 传递和存取特定于线程的数据。这对于需要在不同操作之间保持数据隔离的场合特别有用，
 * 例如在Web服务中为每个请求分配唯一的标识符。
 */
public class BaseContext {

    // 使用ThreadLocal来存储每个线程独有的数据，这里的数据类型为Long。
    public static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    /**
     * 设置当前线程的ID。
     * @param id 需要设置的线程ID。
     */
    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    /**
     * 获取当前线程的ID。
     * @return 当前线程的ID，如果未设置则返回null。
     */
    public static Long getCurrentId() {
        return threadLocal.get();
    }

    /**
     * 移除当前线程的ID。
     * 这是为了避免内存泄漏，特别是在长时间运行的应用中，
     * 当线程结束时，应该清理掉线程本地存储中的数据。
     */
    public static void removeCurrentId() {
        threadLocal.remove();
    }

}
