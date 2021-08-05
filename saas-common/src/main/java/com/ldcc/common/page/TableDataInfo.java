package com.ldcc.common.page;

import lombok.Data;

import java.util.List;

/**
 * @author wwg
 * @version jdk1.8
 * @description 表格分页数据封装
 * @create 2021-08-05 09:50
 **/
@Data
public class TableDataInfo {
    private static final long serialVersionUID = 1L;

    /** 总记录数 */
    private long total;

    /** 列表数据 */
    private List<?> rows;

    /** 消息状态码 */
    private int code;

    /** 消息内容 */
    private String msg;

}
