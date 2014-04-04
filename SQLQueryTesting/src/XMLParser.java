import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Classe per parsejar un XML amb la informació de connexió de les bases de
 * dades
 * 
 * @author Adrià i Gerard
 * 
 */
public class XMLParser {

	String path, tagName;
	Document doc;
	NodeList nodeList;

	/**
	 * Construcció de la connexió per a la posterior lectura del XML
	 */
	public void build() {
		try {
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.parse(getClass().getResourceAsStream(path));
			doc.getDocumentElement().normalize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagValue(String etiqueta, Element item) {
		NodeList llistat = item.getElementsByTagName(etiqueta).item(0)
				.getChildNodes();
		Node valor = (Node) llistat.item(0);
		return valor.getNodeValue();
	}

	// Mètode per obtenir la IP corresponent a la Base de dades sel·leccionada
	// al ComboBox
	public String getIP(String databaseName) {
		nodeList = doc.getElementsByTagName(tagName);
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element item = (Element) node;
				if ((getTagValue("name", item).equals(databaseName))) {
					return getTagValue("ip", item);
				}
			}
		}
		return "";
	}

	// Mètode per obtenir el Port corresponent a la Base de dades sel·leccionada
	// al ComboBox
	public String getPort(String databaseName) {
		nodeList = doc.getElementsByTagName(tagName);
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element item = (Element) node;
				if ((getTagValue("name", item).equals(databaseName))) {
					return getTagValue("port", item);
				}
			}
		}
		return "";
	}

	// Mètode per obtenir totes les bases de dades
	public ArrayList<String> getDatabaseNames() {
		ArrayList<String> result = new ArrayList<String>();
		nodeList = doc.getElementsByTagName(tagName);
		result.add("Escull una DB");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element item = (Element) node;
				result.add(getTagValue("name", item));
			}
		}
		return result;
	}
}
