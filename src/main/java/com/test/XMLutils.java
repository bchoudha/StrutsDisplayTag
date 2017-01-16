package com.test;

import java.io.File;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * utilitaires pr les transformations xml
 */
public class XMLutils {

	static {
		// getDocumentBF();
	}

	public static final String ENTETEXML = "<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>";

	public static final String genericHTMLxsl = "HTMLmaquette";

	/**
	 * DocumentBuilderFactory for XML processing
	 */
	protected static DocumentBuilderFactory dfactory = null;

	/**
	 * Performs an XSLT transformation of a String-based XML flow. Uses
	 * Templates class to optimize the stylesheet parsing. Should any exception
	 * be raised, the returned value is exception.toString().
	 * 
	 * @param pXMLdata
	 *            is the XML data to be transformed
	 * @param pXSLFilePath
	 *            is the path to the XSL stylesheet file
	 * @return The transformation result, as a String
	 */
	public static String XSLT(String pXMLdata, String pXSLFilePath) {
		/*
		 * ndd 26/02/2004 : arrêter d'utiliser os.name ! // selon l'os il faut
		 * mettre ou non un "/" devant String os =
		 * String.valueOf(System.getProperty("os.name")); if
		 * (os.toLowerCase().indexOf("wind") == -1) { pXSLFilePath = "/" +
		 * pXSLFilePath; }
		 */
		// pXMLdata is converted into a Source
		Reader XMLreader = new StringReader(pXMLdata);
		Source xmlSource = new StreamSource(XMLreader);

		Writer myResult = new StringWriter();

		// The stylesheet is converted into a Source
		Source xsltSource = new StreamSource(pXSLFilePath);

		// Instanciation of a TransformerFactory
		TransformerFactory transFact = TransformerFactory.newInstance();

		// the Templates class is used, allowing the XSL stylesheet caching
		try {
			Templates cachedXSLT = transFact.newTemplates(xsltSource);
			Transformer trans = cachedXSLT.newTransformer();

			trans.transform(xmlSource, new StreamResult(myResult));
		} catch (Exception e) {
			// J20Log.error("Impossible d'appliquer la transformation XSL",e);
			return e.toString();
		}

		return myResult.toString();
	}

	/**
	 * Performs an XSLT transformation of a file-based XML flow. Uses Templates
	 * class to optimize the stylesheet parsing. Should any exception be raised,
	 * the returned value is exception.toString().
	 * 
	 * @param pXMLdata
	 *            is the XML data file to be transformed
	 * @param pXSLFilePath
	 *            is the path to the XSL stylesheet file
	 * @return The transformation result, as a String
	 */
	public static String XSLTfromFile(String pXMLFilePath, String pXSLFilePath) {
		/*
		 * ndd 26/02/2004 : arrêter d'utiliser os.name ! // selon l'os il faut
		 * mettre ou non un "/" devant String os =
		 * String.valueOf(System.getProperty("os.name")); if
		 * (os.toLowerCase().indexOf("wind") == -1) { pXSLFilePath = "/" +
		 * pXSLFilePath; }
		 */
		// pXMLdata is converted into a Source
		File xmlFile = new File(pXMLFilePath);
		Source xmlSource = new StreamSource(xmlFile);

		Writer myResult = new StringWriter();

		// The stylesheet is converted into a Source
		Source xsltSource = new StreamSource(pXSLFilePath);

		// Instanciation of a TransformerFactory
		TransformerFactory transFact = TransformerFactory.newInstance();

		// the Templates class is used, allowing the XSL stylesheet caching
		try {
			Templates cachedXSLT = transFact.newTemplates(xsltSource);
			Transformer trans = cachedXSLT.newTransformer();

			trans.transform(xmlSource, new StreamResult(myResult));

		} catch (Exception e) {
			// J20Log.error("Impossible d'appliquer la transformation",e);
			return e.toString();
		}

		return myResult.toString();
	}

	/**
	 * Performs an XSLT transformation resulting in a String. Uses Templates
	 * class to optimize the stylesheet parsing. Should any exception be raised,
	 * the returned value is exception.toString(). ndd 19/05/2004 :
	 * encapsulation de l'accès au XSL avec le J20ExternalAccessor.
	 * 
	 * @param pDOM
	 *            is the XML data to be transformed
	 * @param pXSLFilePath
	 *            is the name of the XSL stylesheet file
	 * @return The transformation result, as a String
	 */
	public static String XSLTFromDocToString(Document pDOM,
			String pXSLFilePath, String path) {
		return XSLTFromDocToString(pDOM, pXSLFilePath, null, path);
	}

	public static String XSLTFromDocToString(Document pDOM,
			String pXSLFilePath, Hashtable pParams, String path) {

		StringWriter bOut = new StringWriter();

		// XSLT

		String relativeDirectory = "/" + pXSLFilePath + ".xsl";
		// Templates cachedXSLT =
		// J20ExternalAccessor.getInstance().getTemplates(relativeDirectory);

		Transformer trans;
		try {
			String finalPath = "/WEB-INF/ExampleXML.xsl";
			if(path!=null && !"".equals(path)){
				finalPath = path;
			}
			trans = TransformerFactory.newInstance().newTransformer(
					new StreamSource(path));
			if (pParams != null) {
				Enumeration lesParams = pParams.keys();
				while (lesParams.hasMoreElements()) {
					String paramName = (String) lesParams.nextElement();
					trans.setParameter(paramName, pParams.get(paramName));
				}
			}
			trans.transform(new DOMSource(pDOM), new StreamResult(bOut));
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bOut.toString();

	}

	/**
	 * Performs an XSLT transformation resulting in a String. The default HTML
	 * stylesheet is used. Uses Templates class to optimize the stylesheet
	 * parsing. Should any exception be raised, the returned value is
	 * exception.toString().
	 * 
	 * @param pDOM
	 *            is the XML data to be transformed
	 * @return The transformation result, as a String
	 */
	public static String XSLTFromDocToHTML(Document pDOM, String path) {
		return XSLTFromDocToHTML(pDOM, null,path);
	}

	/**
	 * Performs an XSLT transformation resulting in a String. The default HTML
	 * stylesheet is used. Uses Templates class to optimize the stylesheet
	 * parsing. Should any exception be raised, the returned value is
	 * exception.toString().
	 * 
	 * @param pDOM
	 *            is the XML data to be transformed
	 * @return The transformation result, as a String
	 */
	public static String XSLTFromDocToHTML(Document pDOM, Hashtable pParams,
			String path) {
		return XSLTFromDocToString(pDOM, genericHTMLxsl, pParams, path);
	}

	/**
	 * Converts a String containing an XML element, into an hashtable . The
	 * element is expected to contain sub-elements named "item", each with an
	 * attribute "id". The hashtable returned is filled with items whose key is
	 * the "id" attribute, and whose value is the sub-element value.
	 * 
	 * @param pStringDom
	 *            is the XML data to be converted
	 * @return The conversion result, as a Hashtable
	 */
	public static Hashtable stringXMLtoHashtable(String pStringDom) {

		Hashtable pH = new Hashtable();

		try {
			// 1-Chargement du XML
			InputSource in = new InputSource(new StringReader(pStringDom));
			Document dom = XMLutils.getDocumentBF().newDocumentBuilder()
					.parse(in);
			// Document dom =
			// getDocumentBF().newDocumentBuilder().parse(pStringDom);

			Element laRacine = dom.getDocumentElement();
			NodeList laListeItems = laRacine.getElementsByTagName("item");
			Element lItem;

			// 2-Parcours des éléments représentant les items de donnée
			for (int i = 0; i < laListeItems.getLength(); i++) {
				lItem = (Element) laListeItems.item(i);
				String laVal = lItem.getFirstChild().getNodeValue();
				pH.put(lItem.getAttribute("id"), (laVal == null ? "" : laVal));
			}
		} catch (Exception e) {
			// J20Log.error("stringXMLtoHashtable: BAD !!!",e);
		}
		return pH;
	}

	/**
	 * Converts an hashtable into a String containing an XML element. Each
	 * element of the hashtable is added into the result String, as an element
	 * named "item" whose value is the hashtable element value, and with an
	 * attribute "id" whose value is the hashtable element key value.
	 * 
	 * @param pHash
	 *            is the Hashtable to be converted
	 * @return The conversion result, as an XML String
	 */
	public static String hashtableToStringXML(Hashtable pHash) {

		StringBuffer leResultat = new StringBuffer(500);

		leResultat.append(ENTETEXML).append("<data>");

		Enumeration lesCles = pHash.keys();
		while (lesCles.hasMoreElements()) {
			String uneCle = (String) lesCles.nextElement();
			String uneValeur = (String) pHash.get(uneCle);
			leResultat.append("<item id=\"").append(uneCle).append("\">")
					.append(uneValeur).append("</item>");
		}
		leResultat.append("</data>");

		return leResultat.toString();
	}

	public static DocumentBuilderFactory getDocumentBF() {
		if (dfactory == null) {
			System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
					"org.apache.xerces.jaxp.DocumentBuilderFactoryImpl");
			dfactory = DocumentBuilderFactory.newInstance();
		}
		return dfactory;
	}

	private static String XMLexceptionString(Exception e) {
		return ENTETEXML + "<error>" + e.toString() + "</error>";
	}
}