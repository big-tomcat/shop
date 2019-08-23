package cn.itlu.shop.order.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itlu.shop.order.vo.Order;
import cn.itlu.shop.utils.PageHibernateCallback;

/*
 * 订单模块持久层代码
 */
public class OrderDao extends HibernateDaoSupport{

	//dao层的保存订单的方法
	public void save(Order order) {
		this.getHibernateTemplate().save(order);
		
	}

	//dao层的我的订单的个数统计
	public Integer findByCountUid(Integer uid) {
		String hql = "select count(*) from Order o where o.user.uid = ?0";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql, uid);
		if(list != null && list.size() > 0 ){
			return list.get(0).intValue();
		}
		return null;
	}

	//dao层的我的订单的查询
	public List<Order> findByPageUid(Integer uid, Integer begin, Integer limit) {
		String hql = "from Order o where o.user.uid=?0 order by ordertime desc";
		//分页查询用execute方法
		List<Order> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, new Object[]{uid}, begin, limit));
		return list;
	}

	//持久层：根据订单的id查询订单的方法
	public Order findByOid(Integer oid) {
		return this.getHibernateTemplate().get(Order.class, oid);
	}

	//dao层的修改订单的操作
	public void update(Order currOrder) {
		this.getHibernateTemplate().update(currOrder);
		
	}

	
	

}
