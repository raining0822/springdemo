package com.hiersun.xzkp.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * date 2016/10/25 18:26
 *
 * @author Leon yang_xu@hiersun.com
 * @version V1.0
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
