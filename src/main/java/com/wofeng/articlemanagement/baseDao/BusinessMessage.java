package com.wofeng.articlemanagement.baseDao;

import lombok.Data;

/**
 * Created by SongpoLiu on 2017/7/10.
 */
@Data
public class BusinessMessage<T> {

    private Integer code;

    private String msg;

    private Boolean success;

    private T data;

}
