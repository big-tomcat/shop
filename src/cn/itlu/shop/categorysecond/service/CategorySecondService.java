package cn.itlu.shop.categorysecond.service;

import java.util.List;

import cn.itlu.shop.categorysecond.dao.CategorySecondDao;
import cn.itlu.shop.categorysecond.vo.CategorySecond;
import cn.itlu.shop.utils.PageBean;
/*
 * 二级分类管理的业务层类
 */
public class CategorySecondService {
	//注入二级分类dao
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

	//业务层分页查询二级分类的方法
	public PageBean<CategorySecond> findByPage(Integer page) {
		PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示记录数
		int limit = 10;
		pageBean.setLimit(limit);
		//设置总记录数
		int totalCount = categorySecondDao.findCount();
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		//设置每页显示数据集合
		int begin = (page - 1)*limit;
		
		List<CategorySecond> list = categorySecondDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}
	

}
