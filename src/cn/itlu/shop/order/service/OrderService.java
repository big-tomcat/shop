package cn.itlu.shop.order.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itlu.shop.order.dao.OrderDao;
import cn.itlu.shop.order.vo.Order;
import cn.itlu.shop.utils.PageBean;

/*
 * 订单模块的业务层代码
 */
@Transactional
public class OrderService {
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	//保存订单业务层代码
	public void save(Order order) {
		orderDao.save(order);
		
	}

	//我的订单的业务层代码
	public PageBean<Order> findByPageUid(Integer uid, Integer page) {
		PageBean<Order> pageBean = new PageBean<Order>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示的记录数
		Integer limit = 5;
		pageBean.setLimit(limit);
		//设置总的记录数
		Integer totalCount = null;
		totalCount = orderDao.findByCountUid(uid);
		pageBean.setTotalCount(totalCount);
		//设置总的页数:
		Integer totalPage = null;
		//总记录数除以页数取余为零，则总页数等于总记录数除以每页显示的记录数
		if(totalCount%limit == 0){
			totalPage = totalCount / limit;
		}else {//否则，总页数 等于 总记录数 除以 每页显示记录数 再加一
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		//设置每页显示数据集合
		Integer begin = (page -1)*limit;
		List<Order> list = orderDao.findByPageUid(uid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	//业务层：根据订单的id查询订单的方法
	public Order findByOid(Integer oid) {
		return orderDao.findByOid(oid);
	}

	//业务层：修改订单的操作
	public void update(Order currOrder) {
		orderDao.update(currOrder);
		
	}
	

}
