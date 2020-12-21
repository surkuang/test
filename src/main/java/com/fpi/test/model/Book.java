package com.fpi.test.model;

import lombok.*;

import java.util.Date;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Book {

    @NonNull
    private Integer id;

    @NonNull
    private Integer price;

    @NonNull
    private String name;

    @NonNull
    private String info;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

}
