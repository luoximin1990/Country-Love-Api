package com.marykay.country.love.api.contract.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.UUID;

/**
 * Created by yangliu on 2017/12/25.
 */
public class OutputMsg {
    private Date Time;
    private UUID TransationId;
    private String LogLevel;
    private String Application;
    private String ENV;
    private String GitHash;
    private String MessageBody;
    @JSONField(name = "Time", format = "yyyy-MM-dd HH:mm:ss")
    public Date getTime() {
        return Time;
    }
    public void setTime(Date time) {
        Time = time;
    }
    @JSONField(name = "TransationId")
    public UUID getTransationId() {
        return TransationId;
    }
    public void setTransationId(UUID transationId) {
        TransationId = transationId;
    }
    @JSONField(name = "LogLevel")
    public String getLogLevel() {
        return LogLevel;
    }
    public void setLogLevel(String logLevel) {
        LogLevel = logLevel;
    }
    @JSONField(name = "Application")
    public String getApplication() {
        return Application;
    }
    public void setApplication(String application) {
        Application = application;
    }
    @JSONField(name = "ENV")
    public String getENV() {
        return ENV;
    }
    public void setENV(String ENV) {
        this.ENV = ENV;
    }
    @JSONField(name = "GitHash")
    public String getGitHash() {
        return GitHash;
    }
    public void setGitHash(String gitHash) {
        GitHash = gitHash;
    }
    @JSONField(name = "MessageBody")
    public String getMessageBody() {
        return MessageBody;
    }
    public void setMessageBody(String messageBody) {
        MessageBody = messageBody;
    }
}