package com.cs.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XMLUtils {

	// static Logger logger = LogManager.getLogger(XMLUtils.class.getName());

	public static String readFileString(File file) {
		String result = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = null;
			while ((s = br.readLine()) != null) {
				result += s + "\n";
			}
			br.close();

			// if (result.contains("<CTCapture")) {
			// result = result.replace("<CTCapture", "<CTCapture
			// xmlns='http://www.cargosmart.com/DCM/CTCapture.xsd'");
			// }

		} catch (Exception e) {

		}
		return result;
	}

	public static Object xmlToBean(String xmlPath, Class<?> load) throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(load);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Object object = unmarshaller.unmarshal(new File(xmlPath));
		return object;
	}

}