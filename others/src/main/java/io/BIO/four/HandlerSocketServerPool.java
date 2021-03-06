package io.BIO.four;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HandlerSocketServerPool {
    private ExecutorService executorService;

    public HandlerSocketServerPool(int maxThreadNum,int queueSize){
        /**
         * 利用线程池实现对应的socket
         */
        executorService = new ThreadPoolExecutor(3,
                                                    maxThreadNum,
                                                120,
                                                TimeUnit.SECONDS,
                                                new ArrayBlockingQueue<Runnable>(queueSize));

    }

    public void execute(Runnable target){
        executorService.execute(target);
    }
}
