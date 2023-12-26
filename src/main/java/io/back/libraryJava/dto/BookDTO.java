package io.back.libraryJava.dto;

import lombok.Data;

@Data
public class BookDTO {

    private Long id;
    private String title;
    private Integer pageCount;
    private String author;
    private Integer price;
    private String imgUrl;
}
