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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.wbhhc.beans.NodeAttributes;
import com.wbhhc.beans.TreeNode;
import com.wbhhc.domain.Syspage;
import com.wbhhc.myutils.JsonUtilities;
import com.wbhhc.service.PageService;
import com.wbhhc.service.mvctestservice;




@Controller
@RequestMapping("/views/test")
public class LoginLogoutControllers {
	private Logger logger = LoggerFactory.getLogger(LoginLogoutControllers.class);
 
    @RequestMapping(value = "/login")   
    public String getLogin( ){  

        return "login";   
  
    }   
    
    @RequestMapping(value = "/hello")   
    public String getHello( ){  

        return "mvctest";   
  
    }  
  

    @RequestMapping(value = "/home")   
    public String getHome() {    
  
        return "home";   
  
    } 

}
