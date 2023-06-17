package com.iot.dodo.springboot.starter.common.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author lwh
 * @date 2023-06-11 21:12:35
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 5496082923762898412L;


    /**
     * 当前页
     */
    private Long pageNo;

    /**
     * 每页显示条数
     */
    private Long pageSize;

    /**
     * 总数
     */
    private Long total;

    /**
     * 查询数据列表
     */
    private List<T> records = Collections.emptyList();

    public PageResponse(long pageNo, long pageSize, long total) {
        if (pageNo > 1) {
            this.pageNo = pageNo;
        }
        this.pageSize = pageSize;
        this.total = total;
    }

    public PageResponse<T> setRecords(List<T> records) {
        this.records = records;
        return this;
    }

}