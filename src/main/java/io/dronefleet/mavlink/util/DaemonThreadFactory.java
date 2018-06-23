package io.dronefleet.mavlink.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class DaemonThreadFactory implements ThreadFactory {

    public static final ThreadFactory defaultFactory() {
        return new DaemonThreadFactory(Executors.defaultThreadFactory());
    }

    private final ThreadFactory superFactory;

    public DaemonThreadFactory(ThreadFactory superFactory) {
        this.superFactory = superFactory;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = superFactory.newThread(r);
        t.setDaemon(true);
        return t;
    }
}
