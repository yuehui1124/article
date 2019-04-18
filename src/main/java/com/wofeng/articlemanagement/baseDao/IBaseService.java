package com.wofeng.articlemanagement.baseDao;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 基础服务接口
 * <p>
 * Created by
 */
@Service
public interface IBaseService<T, ID> {

    /**
     * 添加
     *
     * @param entity 实体信息
     * @return 执行结果 1：成功 0：失败
     */
    Boolean save(T entity);

    /**
     * 添加
     *
     * @param entity 实体信息
     * @return 业务消息
     */
    BusinessMessage<Void> saveExt(T entity);

    /**
     * 删除
     *
     * @param id 实体标识
     * @return 执行结果 1：成功 0：失败
     */
    Boolean delete(Object id);

    /**
     * 删除
     *
     * @param id 实体标识
     * @return 业务消息
     */
    BusinessMessage<Void> deleteExt(Object id);

    /**
     * 更新
     *
     * @param entity 实体信息
     * @return 执行结果 1：成功 0：失败
     */
    Boolean update(T entity);

    /**
     * 更新
     *
     * @param entity 实体信息
     * @return 业务消息
     */
    BusinessMessage<Void> updateExt(T entity);

    /**
     * 根据主键查询
     * 支持联合主键查询
     *
     * @param id 实体标识
     * @return 实体
     */
    T findById(Object id);

    /**
     * 根据主键查询
     * 支持联合主键查询
     *
     * @param id 实体标识
     * @return 包含实体的业务消息
     */
    BusinessMessage<T> findByIdExt(Object id);

    /**
     * 条件查询
     * 通常应用于联合主键或组合条件查询一个结果
     * 当查询结果大于1个时，查询方法会抛异常
     *
     * @param entity 实体参数
     * @return 实体
     */
    T findOne(T entity);

    /**
     * 条件查询
     * 通常应用于联合主键或组合条件查询一个结果
     * 当查询结果大于1个时，查询方法会抛异常
     *
     * @param entity 实体参数
     * @return 包含实体的业务消息
     */
    BusinessMessage<T> findOneExt(T entity);

    /**
     * 列表查询-不支持排序
     *
     * @param entity 实体参数
     * @return 实体集合
     */
    List<T> findList(T entity);

    /**
     * 列表查询-不支持排序
     *
     * @param entity 实体参数
     * @return 包含实体集合的业务消息
     */
    BusinessMessage<List<T>> findListExt(T entity);

    /**
     * 列表查询-支持排序
     *
     * @param example 通用参数
     * @return 实体集合
     */
    List<T> findList(Example example);

    /**
     * 列表查询-支持排序
     *
     * @param example 通用参数
     * @return 包含实体集合的业务消息
     */
    BusinessMessage<List<T>> findListExt(Example example);

    /**
     * 分页查询-支持排序
     *
     * @param page    页码，从1开始
     * @param size    大小，每页数据量
     * @param example 通用参数
     * @return 分页信息
     */
    PageInfo<T> findPage(Integer page, Integer size, Example example);

    /**
     * 分页查询-支持排序
     *
     * @param page    页码，从1开始
     * @param size    大小，每页数据量
     * @param example 通用参数
     * @return 包含分页信息的业务消息
     */
    BusinessMessage<PageInfo<T>> findPageExt(Integer page, Integer size, Example example);
}
