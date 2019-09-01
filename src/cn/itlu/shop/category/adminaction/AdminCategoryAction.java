package cn.itlu.shop.category.adminaction;

import java.util.List;

import cn.itlu.shop.category.service.CategoryService;
import cn.itlu.shop.category.vo.Category;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * 后台一级分类管理的action
 */
public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category>{

	//模型驱动使用的类
	private Category category = new Category();
	@Override
	public Category getModel() {
		// TODO Auto-generated method stub
		return category;
	}
	
	//注入一级分类的service
	private CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	//后台执行查询一级分类的方法
	public String findAll(){
		//查询所有一级分类
		List<Category> cList = categoryService.findAll();
		//将集合的数据显示到页面（值栈的方式）
		ActionContext.getContext().getValueStack().set("cList", cList);
		System.out.println(cList);
		return "findAll";
	}
	
	//后台保存以及分类的方法
	public String save(){
		//调用service进行保存
		categoryService.save(category);
		//页面跳转
		return "saveSuccess";
	}
	
	//后台
	public String delete(){
		//接受cid,可以使用模型驱动，删除一级分类，同时删除二级分类，必须先根据id查询再进行删除
		//先查询
		category = categoryService.findByCid(category.getCid());
		//删除
		categoryService.delete(category);
		//页面跳转
		return "deleteSuccess";
	}

}
