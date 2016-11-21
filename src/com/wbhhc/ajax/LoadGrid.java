package com.wbhhc.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.annotations.reflection.XMLContext;
import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wbhhc.beans.GridBean;
import com.wbhhc.myutils.HibernateUtilities;
import com.wbhhc.myutils.JsonUtilities;
import com.wbhhc.service.PageService;

/**
 * Servlet implementation class LoadGrid
 */
public class LoadGrid extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int pageSize;
	
	private int pageIndex;
	
	private String parentId;
       
    public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public LoadGrid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		this.setPageSize(Integer.valueOf(request.getParameter("rows")));
		this.setPageIndex(Integer.valueOf(request.getParameter("page")));
		this.setParentId(request.getParameter("parentid"));
		
		int total=5;
		PageService serv=new PageService();
		
		List rows=serv.getPageList(total);
		
		GridBean grid=new GridBean();
		grid.setRows(rows);
		grid.setTotal(total);
		
		String json=JsonUtilities.toJson(grid, new String[]{"subsystem","sysroles","sysoperates","sysrolepageopts"});
		
		PrintWriter out=response.getWriter();
		out.println(json);
	}
	
	private List getRows(int total){
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		String hql="from Syspage as p where 1=1 ";
		if (this.getParentId()!=null && !this.getParentId().isEmpty()) {
			hql+=" and p.parentid="+this.getParentId();
		}
		List result=session.createQuery(hql)
				.setFirstResult((this.getPageIndex()-1)*this.getPageSize())
				.setMaxResults(this.getPageSize())
				.list();
		
		Object count=session.createQuery("select count(*) "+hql)
				.uniqueResult();
		
		total=Integer.valueOf(count.toString());
		
		session.getTransaction().commit();
		return result;
	}

}
