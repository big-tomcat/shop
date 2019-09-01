package cn.itlu.shop.adminuser.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itlu.shop.adminuser.vo.AdminUser;

/*
 * 后台登录dao类
 */
public class AdminUserDao extends HibernateDaoSupport{

	//dao层登陆的方法
	public AdminUser login(AdminUser adminUser) {
		String hql = "from AdminUser where username = ?0 and password = ?1";
		List<AdminUser> list = (List<AdminUser>) this.getHibernateTemplate().find(hql, adminUser.getUsername(),adminUser.getPassword());
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

}
