package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import utils.PageResult;

public interface ICommonDAO {
	Serializable add(Object o);//添加
	void del(Class clazz,Serializable id);//删除
	void update(Object o);//修改
	Object find(Class clazz,Serializable id);//根据主键查找
	List find(String hql);//不带分页的查找
	List find(String hql,PageResult pageResult);//带分页的查找(hql)
	List find(DetachedCriteria dcr, PageResult pageResult);//带分页的查询(Criteria)
	Object execProc(String procName);//调用存储过程的查找
}
