package com.wbhhc.myutils;

import javax.servlet.http.Cookie;

public class LongLivedCookie extends Cookie {
	public static final int SECONDS_PER_YEAR=60*60*24*365;

	public LongLivedCookie(String name,String value) {
		// TODO Auto-generated constructor stub
		super(name,value);
		setMaxAge(SECONDS_PER_YEAR);
	}

}
