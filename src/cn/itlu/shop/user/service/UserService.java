package cn.itlu.shop.user.service;

import org.springframework.transaction.annotation.Transactional;

import cn.itlu.shop.user.dao.UserDao;
import cn.itlu.shop.user.vo.User;

/*
 * 用户模块业务层
 */
@Transactional
public class UserService {
	//注入UserDao
	private UserDao userDao = new UserDao();

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//按用户名查询用户的方法：
	public User findByUserName(String username){
		return userDao.findByUserName(username);
		
	}

}
