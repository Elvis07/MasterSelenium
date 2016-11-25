package com.cs.util;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.cs.bean.WebSuite;

public class Loader {

	public static WebSuite suite = null;
	public static int timeOut = 0;
	
	public static void loadSuite(String path) throws JAXBException, IOException {
		String xmlPath = System.getProperty("user.dir") + path;
		Object object = XMLUtils.xmlToBean(xmlPath, WebSuite.class);
		suite = (WebSuite) object;
		timeOut=suite.getCases().get(0).getTimeOut();
	}
}
