package cn.itlu.shop.categorysecond.adminAction;

import java.util.List;

import cn.itlu.shop.category.service.CategoryService;
import cn.itlu.shop.category.vo.Category;
import cn.itlu.shop.categorysecond.service.CategorySecondService;
import cn.itlu.shop.categorysecond.vo.CategorySecond;
import cn.itlu.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * 后台二级分类管理的Action
 */
public class AdminCategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond>{
	
	//模型驱动使用的对象
	private CategorySecond categorySecond = new CategorySecond();

	@Override
	public CategorySecond getModel() {
		// TODO Auto-generated method stub
		return categorySecond;
	}
	//注入二级分类的service
	private CategorySecondService categorySecondService;

	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	
	//接收page
	private Integer page;
	
	
	public void setPage(Integer page) {
		this.page = page;
	}


	//查询二级分类的方法
	public String findAll(){
		PageBean<CategorySecond> pageBean = categorySecondService.findByPage(page);
		//将pageBean的数据保存到值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//注入一级分类
	private CategoryService categoryService;
	
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}


	//跳转到添加页面
	public String addPage(){
		//查询所有一级分类
		List<Category> clist = categoryService.findAll();
		//简化数据显示到页面的下拉列表中
		ActionContext.getContext().getValueStack().set("clist", clist);
		return "addPageSuccess";
	}
	

}
