package com.web.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class PremissionForHospitalUtil {

	// private static final String basePath = "";

	private static File createFile(int my_id, int other_id) {
		String path = Thread.currentThread().getContextClassLoader()
				.getResource("").toString();
		System.out.println("file path before  = " + path);
		path = path.replace("file:", "");
		path = path.replace("classes/", "");
		path = path.substring(1);

		System.out.println("file path = " + path);
		return new File(path + "/premissionDescription/"
				+ String.valueOf(my_id) + "_" + String.valueOf(other_id)
				+ ".xml");
	}

	public static boolean createPremissionFile(int my_id, int other_id) {
		try {
			// NewXML newXml=new NewXML();
			File file = createFile(my_id, other_id);

			if (file.exists()) {
				return false;
			}

			file.createNewFile();
			// document = new SAXReader().read(file);
			Document document = DocumentHelper.createDocument();
			document.addElement("premissions");
			saveToFile(file, document);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * (non-Java doc)
	 * 
	 * @see com.test.XmlOper#writeToFile()
	 */

	public static boolean saveToFile(File file, Document document) {
		try {
			XMLWriter writer = new XMLWriter(new OutputStreamWriter(
					new FileOutputStream(file), "UTF-8"));
			writer.write(document);
			writer.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.test.XmlOp#iteratorElement(org.dom4j.Element)
	 */

	@SuppressWarnings("unchecked")
	public static Map<String, Boolean> iteratorPremissions(int my_id,
			int other_id) {
		// File file = new File(basePath + String.valueOf(my_id) + "_"
		// + String.valueOf(other_id) + ".xml");
		File file = createFile(my_id, other_id);
		Document document;
		try {
			document = new SAXReader().read(file);
			Map<String, Boolean> premissions = new HashMap<String, Boolean>();
			Element rootElement = document.getRootElement();
			for (Iterator<Element> iterator = rootElement.elementIterator(); iterator
					.hasNext();) {
				Element element = iterator.next();
				premissions.put(element.attribute("name").getText(), Boolean
						.parseBoolean(element.attribute("value").getText()));
			}
			return premissions;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.test.XmlOper#getElementByName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Boolean> getPremissionByName(int my_id,
			int other_id, String premissionName) {
		File file = createFile(my_id, other_id);
		Document document;
		try {
			document = new SAXReader().read(file);
			Map<String, Boolean> map = new HashMap<String, Boolean>();
			Element rootElement = document.getRootElement();
			List<Element> list = rootElement.elements("property");

			for (Iterator<Element> iterator = list.iterator(); iterator
					.hasNext();) {
				Element element = iterator.next();
				if (premissionName.equals(element.attribute("name").getText())) {
					map.put(premissionName, Boolean.parseBoolean(element
							.attribute("value").getText()));
				}
			}
			return map;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.test.XmlOper#addElementToXml(java.lang.String, java.lang.String)
	 */
	public static boolean addPremissions(int my_id, int other_id,
			Map<String, Boolean> premissions) {
		File file = createFile(my_id, other_id);
		Document document;
		try {
			document = new SAXReader().read(file);
			Element rootElement = document.getRootElement();
			// Element property = rootElement.addElement("property");
			Set<String> namesSet = premissions.keySet();

			for (String string : namesSet) {
				// System.out.println("name: " + string + "value"
				// + String.valueOf(map.get(string)));
				Element property = rootElement.addElement("property");
				property.addAttribute("name", string);
				property.addAttribute("value",
						String.valueOf(premissions.get(string)));

			}
			// XMLWriter writer = new XMLWriter(new FileWriter(file));
			return saveToFile(file, document);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.test.XmlOper#removeElement(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public static boolean removePremission(int my_id, int other_id,
			Set<String> premissionNames) {
		File file = createFile(my_id, other_id);
		Document document;
		try {
			document = new SAXReader().read(file);
			Element rootElement = document.getRootElement();
			List<Element> list = rootElement.elements("property");

			for (Iterator<Element> iterator = list.iterator(); iterator
					.hasNext();) {
				Element element = iterator.next();

				for (String name : premissionNames) {
					if (name.equals(element.attribute("name").getText())) {
						rootElement.remove(element);
					}
				}
			}
			return saveToFile(file, document);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.test.XmlOper#editElement(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public static boolean editPremissions(int my_id, int other_id,
			Map<String, Boolean> premissions) {
		File file = createFile(my_id, other_id);
		Document document;
		try {
			document = new SAXReader().read(file);
			Element rootElement = document.getRootElement();
			List<Element> list = rootElement.elements("property");
			Set<String> premissionNames = premissions.keySet();

			for (Iterator<Element> iterator = list.iterator(); iterator
					.hasNext();) {
				Element element = iterator.next();

				for (String string : premissionNames) {
					if (string.equals(element.attribute("name").getText())) {
						Attribute attribute = element.attribute("value");
						attribute.setText(String.valueOf(premissions
								.get(string)));
						break;
					}
				}
			}
			return saveToFile(file, document);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		System.out
				.println(PremissionForHospitalUtil.createPremissionFile(1, 3));
	}
}
