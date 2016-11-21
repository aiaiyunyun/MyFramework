package com.wbhhc.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseRepository<T>
{
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
    
    public  void Save(T item)
    {
        try
        {
            getCurrentSession().save(item);
        }
        catch(Exception ex)
        {
            throw ex;
        }
    }
    public  void Update(T item)
    {
        try
        {
            getCurrentSession().saveOrUpdate(item);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }
    public  void delete(T item)
    {
        try
        {
            getCurrentSession().delete(item);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }
}