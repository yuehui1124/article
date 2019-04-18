package com.wofeng.articlemanagement.baseDao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * 基础服务实现类
 * <p>
 *
 * @author yueyueyu
 * @date
 */
@Slf4j
public class SimpleServiceImpl<T, ID> implements IBaseService<T, ID> {

    @Autowired
    private Mapper<T> mapper;

    @Override
    public Boolean save(T entity) {
        log.debug("执行添加：{}", entity);
        Boolean flag = false;
        try {
            int result = this.mapper.insertSelective(entity);
            flag = result > 0;
            log.debug("添加成功：{}", flag);
        } catch (Exception e) {
            log.error("添加失败，{}", e.getMessage());
        }
        return flag;
    }

    @Override
    public BusinessMessage<Void> saveExt(T entity) {
        log.debug("执行添加：{}", entity);
        BusinessMessage<Void> message = new BusinessMessage<>();
        try {
            int result = this.mapper.insertSelective(entity);
            boolean flag = result > 0;
            message.setSuccess(flag);
            log.debug("添加成功：{}", flag);
        } catch (Exception e) {
            log.error("添加失败，{}", e.getMessage());
            message.setMsg("添加失败，请重试");
        }
        return message;
    }

    @Override
    public Boolean delete(Object id) {
        log.debug("执行删除：{}", id);
        Boolean flag = false;
        try {
            int result = this.mapper.deleteByPrimaryKey(id);
            flag = result > 0;
            log.debug("删除成功：{}", flag);
        } catch (Exception e) {
            log.error("删除失败，{}", e.getMessage());
        }
        return flag;
    }

    @Override
    public BusinessMessage<Void> deleteExt(Object id) {
        log.debug("执行删除：{}", id);
        BusinessMessage<Void> message = new BusinessMessage<>();
        try {
            int result = this.mapper.deleteByPrimaryKey(id);
            boolean flag = result > 0;
            message.setSuccess(flag);
            log.debug("删除成功：{}", flag);
        } catch (Exception e) {
            log.error("删除失败，{}", e.getMessage());
            message.setMsg("删除失败，请重试");
        }
        return message;
    }

    @Override
    public Boolean update(T entity) {
        log.debug("执行更新：{}", entity);
        Boolean flag = false;
        try {
            int result = this.mapper.updateByPrimaryKeySelective(entity);
            flag = result > 0;
            log.debug("更新成功：{}", flag);
        } catch (Exception e) {
            log.error("更新失败，{}", e.getMessage());
        }
        return flag;
    }

    @Override
    public BusinessMessage<Void> updateExt(T entity) {
        log.debug("执行更新：{}", entity);
        BusinessMessage<Void> message = new BusinessMessage<>();
        try {
            int result = this.mapper.updateByPrimaryKeySelective(entity);
            boolean flag = result > 0;
            message.setSuccess(flag);
            log.debug("更新成功：{}", flag);
        } catch (Exception e) {
            log.error("更新失败，{}", e.getMessage());
            message.setMsg("更新失败，请重试");
        }
        return message;
    }

    @Override
    public T findById(Object id) {
        log.debug("执行查询：{}", id);
        T t = null;
        try {
            t = this.mapper.selectByPrimaryKey(id);
            log.debug("查询成功：{}", t);
        } catch (Exception e) {
            log.error("查询失败，参数{}，{}", id, e.getMessage());
        }
        return t;
    }

    @Override
    public BusinessMessage<T> findByIdExt(Object id) {
        log.debug("执行查询：{}", id);
        BusinessMessage<T> message = new BusinessMessage<>();
        try {
            T user = this.mapper.selectByPrimaryKey(id);
            message.setSuccess(true);
            message.setData(user);
            log.debug("查询成功：{}", user);
        } catch (Exception e) {
            log.error("查询失败，主键{}，{}", id, e.getMessage());
            message.setMsg("查询失败，请重试");
        }
        return message;
    }

    @Override
    public T findOne(T entity) {
        log.debug("执行查询：{}", entity);
        T t = null;
        try {
            t = this.mapper.selectOne(entity);
            log.debug("查询成功：{}", t);
        } catch (Exception e) {
            log.error("查询失败，参数{}，{}", entity, e.getMessage());
        }
        return t;
    }

    @Override
    public BusinessMessage<T> findOneExt(T entity) {
        log.debug("执行查询：{}", entity);
        BusinessMessage<T> message = new BusinessMessage<>();
        try {
            T t = this.mapper.selectOne(entity);
            message.setSuccess(true);
            message.setData(t);
            log.debug("查询成功：{}", t);
        } catch (Exception e) {
            log.error("查询失败，参数{}，{}", entity, e.getMessage());
            message.setMsg("查询失败，请重试");
        }
        return message;
    }

    @Override
    public List<T> findList(T entity) {
        log.debug("执行查询：{}", entity);
        List<T> list = new ArrayList<>();
        try {
            list = this.mapper.select(entity);
            log.debug("查询成功：{}", list);
        } catch (Exception e) {
            log.error("查询失败，参数{}，{}", entity, e.getMessage());
        }
        return list;
    }

    @Override
    public BusinessMessage<List<T>> findListExt(T entity) {
        log.debug("执行查询：{}", entity);
        BusinessMessage<List<T>> message = new BusinessMessage<>();
        try {
            List<T> list = this.mapper.select(entity);
            message.setSuccess(true);
            message.setData(list);
            log.debug("查询成功：{}", list);
        } catch (Exception e) {
            log.error("查询失败，参数{}，{}", entity, e.getMessage());
            message.setMsg("查询失败，请重试");
        }
        return message;
    }

    @Override
    public List<T> findList(Example example) {
        log.debug("执行查询：{}", example);
        List<T> list = new ArrayList<>();
        try {
            list = this.mapper.selectByExample(example);
            log.debug("查询成功：{}", list);
        } catch (Exception e) {
            log.error("查询失败，参数{}，{}", example, e.getMessage());
        }
        return list;
    }

    @Override
    public BusinessMessage<List<T>> findListExt(Example example) {
        log.debug("执行查询：{}", example);
        BusinessMessage<List<T>> message = new BusinessMessage<>();
        try {
            List<T> list = this.mapper.selectByExample(example);
            message.setSuccess(true);
            message.setData(list);
            log.debug("查询成功：{}", list);
        } catch (Exception e) {
            log.error("查询失败，参数{}，{}", example, e.getMessage());
            message.setMsg("查询失败，请重试");
        }
        return message;
    }

    @Override
    public PageInfo<T> findPage(Integer page, Integer size, Example example) {
        log.debug("执行查询：页码{}，大小{}，条件{}", page, size, example);
        PageInfo<T> pageInfo = new PageInfo<>();
        try {
            PageHelper.startPage(page, size);
            List<T> list = this.mapper.selectByExample(example);
            pageInfo = new PageInfo<>(list);
            log.debug("查询成功：{}", pageInfo);
        } catch (Exception e) {
            log.error("查询列表失败，参数{}，{}", example, e.getMessage());
        }
        return pageInfo;
    }

    @Override
    public BusinessMessage<PageInfo<T>> findPageExt(Integer page, Integer size, Example example) {
        log.debug("执行查询：页码{}，大小{}，条件{}", page, size, example);
        BusinessMessage<PageInfo<T>> message = new BusinessMessage<>();
        try {
            PageHelper.startPage(page, size);
            List<T> list = this.mapper.selectByExample(example);
            message.setSuccess(true);
            PageInfo<T> pageInfo = new PageInfo<>(list);
            message.setData(pageInfo);
            log.debug("查询成功：{}", pageInfo);
        } catch (Exception e) {
            log.error("查询列表失败，参数{}，{}", example, e.getMessage());
            message.setMsg("查询列表失败，请重试");
        }
        return message;
    }
}
