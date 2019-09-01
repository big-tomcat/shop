package cn.itlu.shop.adminuser.action;

import org.apache.struts2.ServletActionContext;

import cn.itlu.shop.adminuser.service.AdminUserService;
import cn.itlu.shop.adminuser.vo.AdminUser;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * 后台登录的Action
 */
public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser>{

	//模型驱动使用的对象
	private AdminUser adminUser = new AdminUser();

	@Override
	public AdminUser getModel() {
		// TODO Auto-generated method stub
		return adminUser;
	}

	//注入Service
	private AdminUserService adminUserService;

	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	
	//后台登录的方法
	public String login(){
		//调用service完成登录
		AdminUser existAdminUser = adminUserService.login(adminUser);
		if(existAdminUser == null){
			//登录失败
			this.addActionError("亲!您的账号或密码错误");
			return "loginFail";
		}else {
			//登录成功
			ServletActionContext.getRequest().getSession().setAttribute("existAdminUser",existAdminUser);
			return "loginSuccess";
		}
	}
	
	

}
