package cn.jmo.hello.service;

import cn.jmo.hello.helper.PageResult;

import java.util.List;
import java.util.Map;

public interface BaseService<T>{

    /**
     * 插入和更新前判断数据唯一性
     **/
    int checkUnique(T t);
    /**
     * 添加对象
     **/
    int insert(T t);
    /**
     * 添加对象,并检查唯一性
     */
    int insertWithCheck(T t);
    /**
     * 更新对象
     **/
    int update(T t);

    /**
     * 更新对象,检查唯一性
     */
    int updateWithCheck(T t);
    /**
     * 删除之前判断数据关联性，是否可删
     **/
    int checkDelete(long id);
    /**
     * 根据主键id删除对象
     **/
    int deleteById(long id);
    /**
     * 根据id返回对象
     **/
    T getById(long id);
    /**
     * 根据pid返回一组对象
     **/
    T listByPid(long pid);
    /**
     * 列出所有对象
     */
    List<T> listAll();
    /**
     * 参数查询
     **/
    List<T> queryByParams(Map<String, Object> params);

    /**
     * 分页查询
     */
    List<T> queryByPage(Map<String, Object> params);

    /**
     * 数量查询
     */
    int countByPage(Map<String, Object> params);

    /**
     * 分页查询
     */
    PageResult<T> pageQuery(Map<String, Object> params);
}