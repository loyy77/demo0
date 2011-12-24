package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import utils.PageResult;

public interface ICommonDAO {
	Serializable add(Object o);//���
	void del(Class clazz,Serializable id);//ɾ��
	void update(Object o);//�޸�
	Object find(Class clazz,Serializable id);//������������
	List find(String hql);//������ҳ�Ĳ���
	List find(String hql,PageResult pageResult);//����ҳ�Ĳ���(hql)
	List find(DetachedCriteria dcr, PageResult pageResult);//����ҳ�Ĳ�ѯ(Criteria)
	Object execProc(String procName);//���ô洢���̵Ĳ���
}
