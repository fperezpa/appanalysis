package org.mule.service.app.analysis;

import java.io.IOException;
import java.nio.file.Path;
import java.util.function.Predicate;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class MuleAppPredicate implements Predicate<Path> {
	Logger logger = LoggerFactory.getLogger(getClass());

	DocumentBuilder db;

	public MuleAppPredicate() throws ParserConfigurationException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		db = dbf.newDocumentBuilder();
	}

	@Override
	public boolean test(Path t) {
		if (t.getFileName().toString().endsWith(".xml") && !t.toString().contains(Analyzer.properties.getProperty("mule.targetfolder"))) {
			try {
				Document doc = db.parse(t.toFile());
				String namespace = doc.getDocumentElement().getAttribute("xmlns");
				if (Analyzer.properties.getProperty("mule.namespace").equals(namespace))
					return true;
			} catch (SAXException | IOException e) {
				logger.error("Parsing document:" + t.getFileName().toString(), e);
			}
		}
		return false;
	}
}
