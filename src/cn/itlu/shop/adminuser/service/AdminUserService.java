package cn.itlu.shop.adminuser.service;

import cn.itlu.shop.adminuser.dao.AdminUserDao;
import cn.itlu.shop.adminuser.vo.AdminUser;

/*
 * 后台登录业务层的类
 */
public class AdminUserService {
	//注入dao
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	//业务层登录的方法
	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
	}
	

}
