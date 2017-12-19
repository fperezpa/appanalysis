package org.mule.service.app.analysis;

import java.io.IOException;
import java.nio.file.Path;
import java.util.function.Consumer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.mule.service.app.analysis.flow.Element;
import org.mule.service.app.util.Tree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MuleAppConsumer implements Consumer<Path> {

	Logger logger = LoggerFactory.getLogger(getClass());
	DocumentBuilder db;
	private Tree<Element> tree = null;

	public MuleAppConsumer(Tree<Element> elements) throws ParserConfigurationException {
		this.tree = elements;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		db = dbf.newDocumentBuilder();
	}

	@Override
	public void accept(Path t) {
		if (logger.isDebugEnabled()) {
			logger.debug(t.toString());
		}
		try {
			Document doc = db.parse(t.toFile());
			doc.getDocumentElement().normalize();
			if (logger.isDebugEnabled()) {
				logger.debug("Root element :" + doc.getDocumentElement().getNodeName());
			}
			NodeList nFlows = doc.getElementsByTagName("flow");
			for (int temp = 0; temp < nFlows.getLength(); temp++) {

				Node flow = nFlows.item(temp);

				NodeList nElements = flow.getChildNodes();
				for (int temp2 = 0; temp2 < nElements.getLength(); temp2++) {
					Node element = nElements.item(temp2);
					if (element.getNodeType() == Node.ELEMENT_NODE) {
						org.w3c.dom.Element eElement = (org.w3c.dom.Element) element;
						if (logger.isDebugEnabled()) {
							logger.debug(
									"Element :" + eElement.getNodeName() + ":id:" + eElement.getAttribute("doc:id"));
						}
					}
				}
			}
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
	}

}
