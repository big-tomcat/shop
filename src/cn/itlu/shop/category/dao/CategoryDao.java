package cn.itlu.shop.category.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itlu.shop.category.vo.Category;

/*
 * 一级分类的持久层对象
 */
public class CategoryDao extends HibernateDaoSupport{

	//Dao层的查询所有一级分类的方法
	public List<Category> findAll() {
		String hql = "from Category";
		List<Category> list = (List<Category>) this.getHibernateTemplate().find(hql);
		return list;
	}

	//dao层保存一级分类的方法
	public void save(Category category) {
		this.getHibernateTemplate().save(category);
		
	}

	//dao层根据cid查询一级分类的方法
	public Category findByCid(Integer cid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Category.class, cid);
	}

	//dao层的删除一级分类的方法
	public void delete(Category category) {
		this.getHibernateTemplate().delete(category);
		
	}

	//dao层修改一级分类的方法
	public void update(Category category) {
		this.getHibernateTemplate().update(category);
		
	}

}
