package com.teckbook.domain.model;

import lombok.Getter;

@Getter
public enum ReadingStatus {
    UNREAD("未読"),
    READING("読みかけ"),
    COMPLETED("読了");

    private final String displayName;

    ReadingStatus(String displayName) {
        this.displayName = displayName;
    }
}
