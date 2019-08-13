package cn.itlu.shop.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itlu.shop.user.service.UserService;
import cn.itlu.shop.user.vo.User;
/*
 * 用户模块Action的类
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	//模型驱动要使用的对象
	private User user = new User();
	//注入UserService
	private UserService userService ;
	
	public void setUser(User user) {
		this.user = user;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	/*
	 * 跳转到注册页面的方法
	 */
	public String registPage(){
		
		return "registPage";
	}
	/*
	 * ajax进行异步校验用户名的方法
	 */
	public String findByName() throws Exception{
		//调用service进行查询
		User existUser = userService.findByUserName(user.getUsername());
		//获得response对象，向页面输出
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		//判断
		if(existUser != null){
			//查询到该用户：用户名存在
			response.getWriter().println("<font color='red'>用户名已经存在</font>");
			
		}else{
			//没查询到该用户名：用户名可以使用
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}
		return NONE;
	}
	
	

}
