package com.teckbook.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "books")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id // 主キー
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB側で自動採番
    private Long id;

    @Embedded
    private ISBN isbn;

    private String title;
    private String author;
    private String publisher;
    private LocalDate purchaseDate;
    private String Category;

    @Embedded
    private PurchaseInfo purchaseInfo;

    @Enumerated(EnumType.STRING)
    private ReadingStatus readingStatus;

    private Integer pageCount;
    private String notes;

    // ビジネスロジック
    public void changeReadingStatus(ReadingStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("Reading status cannot be null");
        }
        this.readingStatus = newStatus;
    }

    public void updateNotes(String newNotes) {
        this.notes = newNotes;
    }
}
