package com.wofeng.articlemanagement.baseDao;

import tk.mybatis.mapper.common.*;

/**
 * @author yueyueyue
 * @date 2019/4/15 16:31
 * Description: article-management
 */

public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
    //TODO
    //FIXME 特别注意，该接口不能被扫描到，否则会出错
}
