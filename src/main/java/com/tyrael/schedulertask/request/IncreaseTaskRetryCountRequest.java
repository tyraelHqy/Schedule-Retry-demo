package com.tyrael.schedulertask.request;

import com.sun.istack.internal.NotNull;

public class IncreaseTaskRetryCountRequest {

    private static final long serialVersionUID = 919228090314692208L;

    private Long taskId;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
}
