package com.iot.dodo.springboot.starter.database;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 持久层基本属性
 *
 * @author lwh
 * @date 2023-06-11 21:39:25
 */
@Data
public class BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -6396430723389421858L;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 删除标识
     */
    private Integer deleteFlag;
}