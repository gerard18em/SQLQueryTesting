import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser {

	String path, tagName;
	Document doc;
	NodeList nodeList;

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

	public String getIP(String databaseName) {
		nodeList = doc.getElementsByTagName(tagName);
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element item = (Element) node;
				if((getTagValue("name", item).equals(databaseName))){
					return getTagValue("ip", item);
				}
			}
		}
		return "";
	}

	public String getPort(String databaseName) {
		nodeList = doc.getElementsByTagName(tagName);
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element item = (Element) node;
				if((getTagValue("name", item).equals(databaseName))){
					return getTagValue("port", item);
				}
			}
		}
		return "";
	}

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
