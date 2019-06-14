package com.gaoxi.test.nettysocket;

public enum ChatResponseTypeEnum {

    TEXT("Text"),
    RECOMMEND("Recommend"),
    KNOWLEDGE("Knowledge");

    public String type;

    private ChatResponseTypeEnum(String type) {
        this.type = type;
    }
}
