package com.tyrael.schedulertask.retry.service.impl;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import com.tyrael.schedulertask.retry.service.TestRetryService;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class TestRetryServiceImpl implements TestRetryService {

    private static final Logger LOG = LoggerFactory.getLogger(TestRetryServiceImpl.class);

    @Override
    @Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 2000, multiplier = 1.5))
    public int dignifiedTest(int code) throws Exception {

        LOG.warn("dignifiedTest被调用,时间：" + LocalTime.now());

        // TODO 模拟向使用方发送重试指令
        LOG.warn("向使用方发送重试指令");

        if (code == 0) {
            // TODO 模拟使用方超时
            LOG.warn("使用方超时");
            throw new Exception("情况不对头！");
        }

        // TODO 模拟使用方返回了结果
        LOG.warn("dignifiedTest被调用,情况对头了！");

        return 200;
    }

    @Recover
    public int recover(Exception e) {
        LOG.warn("回调方法执行！！！！");
        //记日志到数据库 或者调用其余的方法
        return 400;
    }

}