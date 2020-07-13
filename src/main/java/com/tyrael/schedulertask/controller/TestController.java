package com.tyrael.schedulertask.controller;


import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import com.tyrael.schedulertask.async.service.TestAsyncService;
import com.tyrael.schedulertask.request.IncreaseTaskRetryCountRequest;
import com.tyrael.schedulertask.response.SendHttpResponse;
import com.tyrael.schedulertask.retry.service.TestRetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

    @Autowired
    TestAsyncService testAsyncService;


    @Autowired
    TestRetryService testRetryServiceImpl;

    @RequestMapping("/testAsyncNotice")
    public SendHttpResponse testAsyncNotice(@RequestBody IncreaseTaskRetryCountRequest request) throws Exception {
        LOG.warn("通知使用方开始执行！");
        Long taskId = request.getTaskId();
        System.out.println(taskId);

        int[] taskArrays = new int[]{2000, 5000, 5000};
        testAsyncService.testNotice(taskArrays);
        LOG.warn("已经开始通知,异步执行通知");
        SendHttpResponse sendHttpResponse = new SendHttpResponse();
        sendHttpResponse.setTaskId(request.getTaskId());
        sendHttpResponse.setTaskStatus(200);
        System.out.println(sendHttpResponse.toString());
        return sendHttpResponse;

    }


    @GetMapping("/testRetry")
    public String testRetry() throws Exception {
        LOG.warn("通知使用方开始执行！");
        int code = 0;

        int result = testRetryServiceImpl.dignifiedTest(code);
        return "result：" + result;
    }
}
