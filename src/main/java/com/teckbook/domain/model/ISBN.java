package com.teckbook.domain.model;

@Embeddable
public record ISBN(String code) {
    // コンストラクターでバリデーション
    public ISBN {
        // nullチェック, 13桁かどうか、始まりが 978 or 979 であること
        if(code == null) {
            throw new IllegalArgumentException("ISBN code cannot be null");
        }

        if(!code.matches("^(978|979)\\d{10}$")) {
            throw new IllegalArgumentException("ISBN must be 13 digits starting with 978 or 979, but got: " + codet );
        }
    }
}
