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
	
    //注册用户数据存入数据库
	public void save(User user) {
		
		this.getHibernateTemplate().save(user);
		
	}

	//根据激活码查询永用户
	public User findByCode(String code) {
		// TODO Auto-generated method stub
		String hql = "from User where code=?0";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql,code);
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	//修改用户转态的方法
	public void update(User existUser) {
		this.getHibernateTemplate().update(existUser);
		
	}

	//用户登录方法
	public User login(User user) {
		String hql = "from User where username=?0 and password=?1 and state=?2";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, user.getUsername(),user.getPassword(),1);
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	

}
