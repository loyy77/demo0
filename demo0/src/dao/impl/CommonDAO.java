package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import utils.PageResult;
import dao.ICommonDAO;

public class CommonDAO extends HibernateDaoSupport implements ICommonDAO {

	/**
	 * ���
	 */
	@Override
	public Serializable add(Object o) {
		return this.getHibernateTemplate().save(o);
	}
	/**
	 * ɾ��
	 */
	@Override
	public void del(Class clazz,Serializable id) {
		this.getHibernateTemplate().delete(this.find(clazz, id));
	}
	/**
	 * ���ô洢
	 */
	@Override
	public Object execProc(String procName) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * ����Id��ѯ
	 * @param clazz
	 * @param id
	 * @return
	 */
	@Override
	public Object find(Class clazz, Serializable id) {
		return this.getHibernateTemplate().get(clazz, id);
	}
	/**
	 * ����ҳ�Ĳ�ѯ(hql)
	 */
	@Override
	public List find(String hql, PageResult pageResult) {
		if (null==hql){
			return null;
		}
		Session session=this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(pageResult.getFirstRec());
		query.setMaxResults(pageResult.getPageSize());
		List ret = query.list();
	
		/**
		 * ������빦��: ������������ļ�¼����
		 * "from PetInfo",
		 * "select pet from PetInfo pet",
		 * "from PetInfo order by petStrength",
		 * "select pet from PetInfo pet order by pet.petStrength",
		 * "from OrderDetail",
		 * "from Order ",
		 * "from Order as order"
		 */
		//ɾ��select xx
		String t_hql=hql.toLowerCase();
		t_hql=hql.substring(t_hql.indexOf("from"));
		String t_hql_2=t_hql.toLowerCase();
		//ɾ��order by
		int index_order=t_hql_2.indexOf(" order ");
		int index_by=t_hql_2.indexOf(" by ");
		if( index_order>-1 &&  index_by>-1 && (index_order<index_by) )
			t_hql=t_hql.substring(0, t_hql_2.indexOf(" order "));
		//���ӾۺϺ���
		t_hql = "select count(*) " + t_hql;
		//������������ļ�¼����
		int recordCount=(Integer)session.createQuery(t_hql).uniqueResult();
		pageResult.setRecordCount(recordCount);
		return ret;
		
	}
	/**
	 * ������ҳ�Ĳ�ѯ
	 */
	@Override
	public List find(String hql) {
		return this.getHibernateTemplate().find(hql);
	}
	/**
	 * ����
	 */
	@Override
	public void update(Object o) {
		this.getHibernateTemplate().update(o);
	}
	/**
	 * ����ҳ�Ĳ�ѯ(criteria)
	 */
	@Override
	public List find(DetachedCriteria dcr, PageResult pageResult) {
		List list = null;
		try {
			Criteria cr=dcr.getExecutableCriteria(this.getSession());
			cr.setFirstResult((pageResult.getPageNo() - 1) * pageResult.getPageSize());
			cr.setMaxResults(pageResult.getPageSize());
			list=cr.list();
			
			//����ҳ��
			cr.setProjection(Projections.rowCount());
			cr.setFirstResult(0); //���뽫ָ���ƻؽ������ͷ.����NullPointer�쳣.
			int count = (Integer) cr.uniqueResult();
			pageResult.setRecordCount(count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;	
		}

	
}
