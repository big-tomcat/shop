package cn.itlu.shop.categorysecond.dao;

import java.util.List;





import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itlu.shop.categorysecond.vo.CategorySecond;
import cn.itlu.shop.utils.PageHibernateCallback;
/*
 * 二级分类管理的dao层类
 */
public class CategorySecondDao extends HibernateDaoSupport{

	//dao层的统计二级分类 的个数的方法
	public int findCount() {
		String hql = "select count(*) from CategorySecond";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list != null && list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}

	//dao层分页查询二级分类的方法
	public  List<CategorySecond> findByPage(int begin, int limit) {
		String hql = "from CategorySecond order by csid desc";
		List<CategorySecond> list = this.getHibernateTemplate().execute(new PageHibernateCallback<CategorySecond>(hql, null, begin, limit));
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}

	//dao层保存二级分类的方法
	public void save(CategorySecond categorySecond) {
		this.getHibernateTemplate().save(categorySecond);
		
	}

	//dao层的根据二级分类的id查询二级分类
	public CategorySecond findByCsid(Integer csid) {
		return this.getHibernateTemplate().get(CategorySecond.class, csid);
		
	}

	//dao层删除二级分类的方法
	public void delete(CategorySecond categorySecond) {
		this.getHibernateTemplate().delete(categorySecond);
		
	}

}
