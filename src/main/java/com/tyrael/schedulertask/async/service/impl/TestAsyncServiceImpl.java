package com.tyrael.schedulertask.async.service.impl;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import com.tyrael.schedulertask.async.service.TestAsyncService;
import com.tyrael.schedulertask.common.DelayElement;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.DelayQueue;

@Service
public class TestAsyncServiceImpl implements TestAsyncService {
    
    private static final Logger LOG = LoggerFactory.getLogger(TestAsyncServiceImpl.class);
    
    @Async("getExecutor")
    @Override
    public String testNotice(int[] taskDelayMill) throws InterruptedException, IOException {

        LOG.warn(Thread.currentThread().getName() + "   -------正在异步执行任务------" + new Date());

        DelayQueue delayQueue = new DelayQueue();

        //数组的length大小就是额外需要发送的通知数
        int taskSum = taskDelayMill.length;

        //将每一次发送通知的间隔时间都对应创建一个延迟设置类,放入延迟队列delayQueue里
        for (int i = 0; i < taskSum; i++) {
            delayQueue.put(new DelayElement(taskDelayMill[i]));
        }

        LOG.warn("开始时间：" + DateFormat.getDateTimeInstance().format(new Date()));

        while (!delayQueue.isEmpty()) {
            
            // 执行延迟任务
            LOG.warn("现在执行延迟任务,调用业务接口");

            //模拟调用API,通知使用方开始执行任务,得到执行任务的结果 成功或失败
            String result = getNoticeResult();

            LOG.warn("使用方运行的结果是：" + result);
            if (!result.equals("success")) {

                // TODO 执行任务
                LOG.warn("任务执行中：" + delayQueue.take());
            } else {

                break;
            }
        }

        //查询任务执行的结果

        LOG.warn("通知任务不需要再发,使用方运行的结果已经确定");

        LOG.warn("结束时间：" + DateFormat.getDateTimeInstance().format(new Date()));

        return "success";
    }


    //模拟通知执行的结果
    public String getNoticeResult() throws IOException {
        //模拟调用通知发货API接口,获取返回结果
        String[] strs = {"success", "-error-", "--error--", "-error--"};
        return RandomStr(strs);
    }

    //随机返回字符串数组中的字符串
    public static String RandomStr(String[] strs) {
        int random_index = (int) (Math.random() * strs.length);
        return strs[random_index];
    }

}
