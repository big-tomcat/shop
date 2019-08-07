package cn.itlu.shop.index.action;

import com.opensymphony.xwork2.ActionSupport;

/*
 * 首页访问action
 */
public class IndexAction extends ActionSupport{
	/*
	 * 执行的访问首页的方法
	 */
	public String execute(){
		System.out.println("index.action.......");
		return "index";
	}

}
