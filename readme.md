# 整个流程实现简单介绍
可以看到一直传递的接收参数是一个数组 taskArrays，

数组的元素就是每个通知任务发出的延迟时间， 可以看到我弄得是 2000，5000，5000 ；

那就是额外发3次，结合impl代码，

先判断队列里面的任务还有没有，有的话就回去执行。

第一次是延迟2秒发一次， 然后调用通知使用方执行接口，得到返回状态；

如果是success，那么就是使用方执行成功，可以直接结束；

如果不是success，我们继续调用 delayQueue.take() ，直到队列里面的任务都被执行完毕，也就是3次都发完。