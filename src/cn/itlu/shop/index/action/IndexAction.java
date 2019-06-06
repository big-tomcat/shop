package cn.itlu.shop.index.action;

import com.opensymphony.xwork2.ActionSupport;

/*
 * ��ҳ����action
 */
public class IndexAction extends ActionSupport{
	/*
	 * ִ�еķ�����ҳ�ķ���
	 */
	public String execute(){
		System.out.println("index.action.......");
		return "index";
	}
	
	

}
