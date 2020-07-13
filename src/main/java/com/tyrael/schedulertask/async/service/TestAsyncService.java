package com.tyrael.schedulertask.async.service;

import java.io.IOException;

public interface TestAsyncService {
    String testNotice(int[] taskDelayMill) throws InterruptedException, IOException;
}
