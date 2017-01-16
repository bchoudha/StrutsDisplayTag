package com.test;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.gson.Gson;

/**
 * The Class SearchAction.
 */
public class XSLTAction extends org.apache.struts.action.Action implements
		Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant SUCCESS. */
	private final static String SUCCESS = "success";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// callJSON(form,response);
		/*
		 * Document d = null; //String s = "org.apache.xerces.dom.DocumentImpl";
		 * String s = "com.renaultvi.j20lean.lib.DocumentImplLean"; try { d =
		 * (Document) Class.forName(s).newInstance(); } catch
		 * (InstantiationException e) {
		 * System.out.println("Erreur à la création d'un Document"); } catch
		 * (IllegalAccessException e) {
		 * System.out.println("Erreur à la création d'un Document"); } catch
		 * (ClassNotFoundException e) {
		 * System.out.println("Erreur à la création d'un Document"); }
		 */

		//createDOM1(request, response);
		createDOM2(request, response);
		// return d;
		return mapping.findForward(SUCCESS);
	}

	/**
	 * Creates the dom.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws FactoryConfigurationError
	 *             the factory configuration error
	 * @throws TransformerFactoryConfigurationError
	 *             the transformer factory configuration error
	 */
	private void createDOM1(HttpServletRequest request,
			HttpServletResponse response) throws FactoryConfigurationError,
			TransformerFactoryConfigurationError {
		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("company");
			doc.appendChild(rootElement);

			// staff elements
			Element staff = doc.createElement("Staff");
			rootElement.appendChild(staff);

			// set attribute to staff element
			Attr attr = doc.createAttribute("id");
			attr.setValue("1");
			staff.setAttributeNode(attr);

			// shorten way
			// staff.setAttribute("id", "1");

			// firstname elements
			Element firstname = doc.createElement("firstname");
			firstname.appendChild(doc.createTextNode("yong"));
			staff.appendChild(firstname);

			// lastname elements
			Element lastname = doc.createElement("lastname");
			lastname.appendChild(doc.createTextNode("mook kim"));
			staff.appendChild(lastname);

			// nickname elements
			Element nickname = doc.createElement("nickname");
			nickname.appendChild(doc.createTextNode("mkyong"));
			staff.appendChild(nickname);

			// salary elements
			Element salary = doc.createElement("salary");
			salary.appendChild(doc.createTextNode("100000"));
			staff.appendChild(salary);

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			/*
			 * Transformer transformer = transformerFactory.newTransformer();
			 * DOMSource source = new DOMSource(doc); StreamResult result = new
			 * StreamResult(System.out);
			 * 
			 * transformer.transform(source, result);
			 */
			request.setAttribute("DOM", doc);

			System.out.println("File saved!");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}
	}

	/**
	 * Creates the dom.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws FactoryConfigurationError
	 *             the factory configuration error
	 * @throws TransformerFactoryConfigurationError
	 *             the transformer factory configuration error
	 */
	private void createDOM2(HttpServletRequest request,
			HttpServletResponse response) throws FactoryConfigurationError,
			TransformerFactoryConfigurationError {
		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("people");
			doc.appendChild(rootElement);

			addPerson1(doc, rootElement);
			addPerson2(doc, rootElement);

			// write the content into xml file
			/*
			 * TransformerFactory transformerFactory = TransformerFactory
			 * .newInstance();
			 * 
			 * Transformer transformer = transformerFactory.newTransformer();
			 * DOMSource source = new DOMSource(doc); StreamResult result = new
			 * StreamResult(System.out);
			 * 
			 * transformer.transform(source, result);
			 */
			request.setAttribute("DOM", doc);
			getClass().getClassLoader().getResourceAsStream("Web-INF/web.xml");

			System.out.println("File saved!!!!!!");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}
	}

	/**
	 * Adds the person1.
	 * 
	 * @param doc
	 *            the doc
	 * @param rootElement
	 *            the root element
	 */
	private void addPerson1(Document doc, Element rootElement) {
		// staff elements
		Element person = doc.createElement("person");
		rootElement.appendChild(person);

		// set attribute to staff element
		Attr attr = doc.createAttribute("id");
		attr.setValue("1");
		person.setAttributeNode(attr);

		// shorten way
		// staff.setAttribute("id", "1");

		// firstname elements
		Element firstname = doc.createElement("name");
		firstname.appendChild(doc.createTextNode("Peter"));
		person.appendChild(firstname);

		// lastname elements
		Element lastname = doc.createElement("age");
		lastname.appendChild(doc.createTextNode("54"));
		person.appendChild(lastname);
	}

	/**
	 * Adds the person2.
	 * 
	 * @param doc
	 *            the doc
	 * @param rootElement
	 *            the root element
	 */
	private void addPerson2(Document doc, Element rootElement) {
		// staff elements
		Element person = doc.createElement("person");
		rootElement.appendChild(person);

		// set attribute to staff element
		Attr attr = doc.createAttribute("id");
		attr.setValue("2");
		person.setAttributeNode(attr);

		// shorten way
		// staff.setAttribute("id", "1");

		// firstname elements
		Element firstname = doc.createElement("name");
		firstname.appendChild(doc.createTextNode("Patricia"));
		person.appendChild(firstname);

		// lastname elements
		Element lastname = doc.createElement("age");
		lastname.appendChild(doc.createTextNode("50"));
		person.appendChild(lastname);
	}

	/**
	 * Call JSON.
	 * 
	 * @param form
	 *            the form
	 * @param response
	 *            the response
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void callJSON(ActionForm form, HttpServletResponse response)
			throws IOException {
		UserForm userForm = (UserForm) form;
		ActorData actorData = new ActorData();
		ArrayList<ActorData> actorList = actorData.loadData();
		// String userId = userForm.getUserId();
		String userName = userForm.getUserName();
		// String userEmail = userForm.getEmailId();
		ArrayList<ActorData> listClone = new ArrayList<ActorData>();
		for (ActorData obj : actorList) {
			if (userName != null) {
				if (obj.getUserName() != null
						&& obj.getUserName().toLowerCase()
								.contains(userName.toLowerCase())) {
					listClone.add(obj);
				}
			}
		}
		String json = new Gson().toJson(listClone);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}
}
