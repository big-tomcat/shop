package cn.itlu.shop.user.service;

import org.springframework.transaction.annotation.Transactional;

import cn.itlu.shop.user.dao.UserDao;
import cn.itlu.shop.user.vo.User;
import cn.itlu.shop.utils.MailUtils;
import cn.itlu.shop.utils.UUIDUtils;

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
	
    //业务层完成用户注册代码
	public void save(User user) {
		//将数据存入数据库
		user.setState(0);//0代表用户未激活  1代表用户已经激活
		String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);
		//发送激活邮件
		MailUtils.sendMail(user.getEmail(), code);
		
	}
	
    //业务层根据激活码查询用户
	public User findByCode(String code) {
		// TODO Auto-generated method stub
		return userDao.findByCode(code);
	}

	//修改用户的状态的方法
	public void update(User existUser) {
		userDao.update(existUser);
		
	}

	//用户登录的方法
	public User login(User user) {
		
		return userDao.login(user);
	}

}
