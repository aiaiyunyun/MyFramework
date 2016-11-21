package com.wbhhc.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wbhhc.beans.NodeAttributes;
import com.wbhhc.beans.TreeNode;
import com.wbhhc.domain.Syspage;
import com.wbhhc.myutils.HibernateUtilities;
import com.wbhhc.myutils.JsonUtilities;

@Component
public class PageService {
	@Autowired
	private SessionFactory sessionFactory;
	
	private final int MAX_LEVEL=2;
	
	@Transactional
	public String getPagesTree(){
		Session session = sessionFactory.getCurrentSession();
		List result=session.createQuery("from Syspage").list();
    	List<TreeNode> tree=fillTreeNode(BigDecimal.valueOf(0),1,result);
		String json=JsonUtilities.toJson(tree);
		
		return json;
	}
	
	public List getPageList(int total){
		Session session = HibernateUtilities.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql="from Syspage as p where 1=1 ";
		List result=session.createQuery(hql)
				.list();
		
		Object count=session.createQuery("select count(*) "+hql)
				.uniqueResult();
		
		total=Integer.valueOf(count.toString());
		
		session.getTransaction().commit();
		return result;
	}
	
	
	private List<TreeNode> fillTreeNode(BigDecimal parentid,int level,List pagestable){
		List<TreeNode> tree=new ArrayList<TreeNode>();
		for (Object obj : pagestable) {
			Syspage page=(Syspage)obj;
			if (page.getParentid().equals(parentid)) {
				TreeNode node=new TreeNode();
				node.setId(page.getId());
				node.setText(page.getName());
				if(page.getPageurl()!=null && !page.getPageurl().isEmpty()){
					NodeAttributes attr=new NodeAttributes();
					attr.setUrl(page.getPageurl());
					attr.setTitle(page.getName());
					node.setAttributes(attr);
				}
				if (level<MAX_LEVEL) {
					node.setChildren(fillTreeNode(page.getId(),level+1,pagestable));
				}
				tree.add(node);
			}
		}
		return tree;
	}
}
