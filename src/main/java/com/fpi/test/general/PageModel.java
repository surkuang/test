package com.fpi.test.general;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageModel<T> {

    private Long total;
    private List<T> entries = Lists.newArrayList();
}
