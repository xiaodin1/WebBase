package com.fibbery.framework.service;

import com.fibbery.framework.exception.BizException;
import com.fibbery.framework.mybatis.ui.Page;

/**
 * 通用service
 * Created by jiangnenghua on 2016/8/16.
 */
public interface BaseService<T>{

    /**
     * 添加一条记录
     * @param record
     * @throws BizException
     */
    void add(T record) throws BizException;

    /**
     * 根据Key删除一条记录
     * @param key
     * @throws BizException
     */
    void delete(String key) throws BizException;

    /**
     * 根据key更新一条记录
     * @param record
     * @throws BizException
     */
    void modify(T record) throws BizException;

    /**
     * 根据key获取一条记录
     * @param key
     * @return
     * @throws BizException
     */
    T get(String key) throws BizException;

    /**
     * 删除所有记录
     * @throws BizException
     */
    void deleteAll() throws BizException;

    /**
     * 获取所有记录
     * @return
     */
    Page<T> listAll() throws BizException;

    /**
     * 验证记录的新增或者更新是否合法
     */
    boolean isValid(T record) throws BizException;

    //TODO 需要创建codition类,里面存放对应的过滤条件来进行解析
}
