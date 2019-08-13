package cn.itlu.shop.user.dao;



import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itlu.shop.user.vo.User;

/*
 * 用户模块持久层
 */
public class UserDao extends HibernateDaoSupport{
	//按名称查询是否有该用户：
	public User findByUserName(String username){
		String hql = "from User where username=?0";
		
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, username);
		if(list != null && list.size() >0){
			return list.get(0);
		}
		return null;
		
	}
	

}
