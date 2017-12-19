package org.mule.service.app.analysis;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.mule.service.app.analysis.flow.Element;
import org.mule.service.app.util.Tree;

public class Analyzer {

	static Properties properties = new Properties();

	public Analyzer() {
		loadProperties();
	}

	private void loadProperties() {
		try {
			properties.load(Analyzer.class.getResourceAsStream("tool.properties"));
		} catch (IOException e) {
			System.out.println("Could not load properties: " + e.getMessage());
			System.exit(-1);
		}
	}

	public void run(File proyectDir) throws IOException, ParserConfigurationException {
		Tree<Element> flowTree = new Tree<Element>();
		Files.walk(proyectDir.toPath()).filter(new MuleAppPredicate()).forEach(new MuleAppConsumer(flowTree));
	}

	public static void main(String[] args) throws IOException, ParserConfigurationException, ParseException {
		CommandLineParser parser = new DefaultParser();
		Options options = new Options();

		Option muleappOption = Option.builder("d").argName("directory").hasArg(true).desc("Mule 4 App Directory Folder")
				.build();
		options.addOption(muleappOption);
		CommandLine cmd = parser.parse(options, args);

		Analyzer analysis = new Analyzer();
		if (cmd.hasOption("d")) {
			File fileDir = new File(cmd.getOptionValue("d"));
			if (fileDir.isDirectory()) {
				analysis.run(fileDir);
			}
		} else {
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("analizer", options);
		}

	}

}
