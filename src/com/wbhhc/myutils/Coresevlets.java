package com.wbhhc.myutils;

public class Coresevlets {
	private String _responseHtml;

	public String get_responseHtml() {
		return _responseHtml;
	}

	public Coresevlets(String title,String context) {
		StringBuilder builder=new StringBuilder();
		builder.append("<html>\n<head>\n");
		builder.append("<meta http-equiv=\"Content-Type\" content=\"text/html;charset=gbk\">\n");
		builder.append("<title>"+title);
		builder.append("</title><head>\n<body>\n<form>");
		builder.append(context);
		builder.append("</form>\n</body></html>");
		this._responseHtml=builder.toString();
		
	}

}
