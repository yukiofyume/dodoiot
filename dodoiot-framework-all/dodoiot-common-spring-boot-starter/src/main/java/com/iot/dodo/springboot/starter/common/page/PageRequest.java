package com.iot.dodo.springboot.starter.common.page;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author lwh
 * @date 2023-06-11 21:08:52
 */
@Data
public class PageRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -9221585284631648283L;
    private Long pageNo;

    private Long pageSize;
}