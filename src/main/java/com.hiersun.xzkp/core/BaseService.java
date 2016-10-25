package com.hiersun.xzkp.core;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hiersun.xzkp.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * date 2016/10/25 15:40
 *
 * @author Leon yang_xu@hiersun.com
 * @version V1.0
 */
public abstract class BaseService<M, PK> {

    @Autowired
    private Mapper<M> mapper;


    public int add(M m){
        return mapper.insert(m);
    }

    public int delete(PK id){
        return mapper.deleteByPrimaryKey(id);
    }

    public int deleteByProperties(M m){
        return mapper.delete(m);
    }

    public int update(M m){
        return mapper.updateByPrimaryKeySelective(m);
    }

    public M findById(PK id){
        return mapper.selectByPrimaryKey(id);
    }

    public M findByProperties(M m){
        return mapper.selectOne(m);
    }

    public List<M> findByExample(Example example){
        return mapper.selectByExample(example);
    }

    public List<M> findAll(){
        return mapper.selectAll();
    }

    public List<M> findListByProperties(M m){
        return mapper.select(m);
    }

    public Page<M> findPage(Page<M> page){
        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<M> list = mapper.selectAll();
        PageInfo<M> pageInfo = new PageInfo(list);
        return installPage(pageInfo, list, page);
    }

    private Page<M> installPage(PageInfo<M> pageInfo, List<M> list, Page<M> page){
        page.setList(list);
        page.setHasNext(pageInfo.isHasNextPage());
        page.setHasPrev(pageInfo.isHasPreviousPage());
        page.setNext(pageInfo.getNextPage());
        page.setPrev(pageInfo.getPrePage());
        page.setTotalCount(pageInfo.getTotal());
        page.setTotalPageCount(pageInfo.getPages());
        return page;
    }
}
