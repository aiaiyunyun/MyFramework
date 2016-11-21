package com.wbhhc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.wbhhc.beans.NodeAttributes;
import com.wbhhc.beans.TreeNode;
import com.wbhhc.domain.Syspage;
import com.wbhhc.myutils.JsonUtilities;
import com.wbhhc.service.PageService;
import com.wbhhc.service.mvctestservice;




@Controller
@SessionAttributes("/views/test/mvctest")
public class testcontrollers {
	private Logger logger = LoggerFactory.getLogger(testcontrollers.class);
	
	@Autowired
	mvctestservice serv;
	
	@Autowired
	PageService pageService;
	
    @RequestMapping(value="/views/test/mvctest")
    public ModelAndView gohome() throws Exception
    {
    	logger.info("gohome was been run!");
        ModelAndView mav = new ModelAndView("mvctest");

        mav.addObject("name", serv.getName());
        return mav;
    }
    
    @RequestMapping(value="/views/test/menutree")
    public ModelAndView getMenuTree(HttpServletRequest request, HttpServletResponse response,Object handler) 
    		throws IOException{
		PrintWriter out=response.getWriter();
		out.write(pageService.getPagesTree());
		out.flush();
    	return null;
    }
    

}
