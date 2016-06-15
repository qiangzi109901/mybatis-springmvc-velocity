package cn.jmo.hello.service.impl;

import cn.jmo.hello.dao.BaseDao;
import cn.jmo.hello.helper.AppHelper;
import cn.jmo.hello.helper.PageResult;
import cn.jmo.hello.service.BaseService;
import org.apache.commons.collections4.MapUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by qiangzi on 16/6/10.
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    private BaseDao<T> baseDao;
    private String daoname;

    public BaseServiceImpl(){
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        Class<T> beanCls = (Class) params[0];
        if(beanCls != null){
            String beanname = beanCls.getSimpleName();
            daoname = beanname.substring(0,beanname.lastIndexOf("DO")) + "Dao";
        }
    }

    protected BaseDao<T> getBaseDao(){
        if(baseDao == null){
            baseDao = (BaseDao<T>) AppHelper.getBean(daoname);
        }
        return baseDao;
    }

    @Override
    public int checkUnique(T t) {
        return getBaseDao().checkUnique(t);
    }

    @Override
    public int insert(T t) {
        return getBaseDao().insert(t);
    }

    @Override
    public int insertWithCheck(T t) {
        int u = checkUnique(t);
        if(u >= 1){
            return -2;
        }
        return insert(t);
    }

    @Override
    public int update(T t) {
        return getBaseDao().update(t);
    }

    @Override
    public int updateWithCheck(T t) {
        int u = checkUnique(t);
        if(u>=1){
            return -2;
        }
        return update(t);
    }

    @Override
    public int checkDelete(long id) {
        return getBaseDao().checkDelete(id);
    }

    @Override
    public int deleteById(long id) {
        return getBaseDao().deleteById(id);
    }

    @Override
    public T getById(long id) {
        return getBaseDao().getById(id);
    }

    @Override
    public T listByPid(long pid) {
        return getBaseDao().listByPid(pid);
    }

    @Override
    public List<T> listAll() {
        return getBaseDao().listAll();
    }

    @Override
    public List<T> queryByParams(Map<String, Object> params) {
        return getBaseDao().queryByParams(params);
    }

    @Override
    public List<T> queryByPage(Map<String, Object> params) {
        return getBaseDao().queryByPage(params);
    }

    @Override
    public int countByPage(Map<String, Object> params) {
        return getBaseDao().countByPage(params);
    }

    @Override
    public PageResult<T> pageQuery(Map<String, Object> params) {
        PageResult<T> rst = new PageResult<>();
        int page = MapUtils.getIntValue(params, "page", 1);
        int pageSize = MapUtils.getIntValue(params, "pageSize", 10);
        rst.setPage(page);
        rst.setPageSize(pageSize);
        params.put("offset", rst.getOffset());
        params.put("pageSize", pageSize);

        int total = countByPage(params);
        rst.setTotal(total);
        if(total == 0){
            rst.setData(null);
        }
        else{
            List<T> data = queryByPage(params);
            rst.setData(data);
        }
        return rst;
    }
}
