package com.tyrael.schedulertask.response;

public class SendHttpResponse {
    private static final long serialVersionUID = 4396631675960516918L;

    private Long taskId;

    private Integer taskStatus;

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "SendHttpResponse{" +
                "taskId=" + taskId +
                ", TaskStatus=" + taskStatus +
                '}';
    }
}
