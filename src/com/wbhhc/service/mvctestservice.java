package com.wbhhc.service;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import com.wbhhc.domain.*;


@Transactional
@Component
public class mvctestservice {
	@Autowired
	private SessionFactory sessionFactory;
	
	public String getName() throws Exception{
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		Sysrole role =new Sysrole();
		Sysuser user=new Sysuser();
		
		session.load(role, BigDecimal.valueOf(1));
		
		session.load(user,BigDecimal.valueOf(2));
		user.getSysroles().add(role);
		
        Syspage pages=(Syspage)session.get(Syspage.class, BigDecimal.valueOf(1));
        session.getTransaction().rollback();
		return "this is service layer,can I help you."+pages.getName();
	}
	
	public List getPagesTree(){
		Session session = sessionFactory.getCurrentSession();
		List result=session.createCriteria(Syspage.class).list();
		return result;
	}
}
