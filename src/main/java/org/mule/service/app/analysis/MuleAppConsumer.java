package org.mule.service.app.analysis;

import java.nio.file.Path;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MuleAppConsumer implements Consumer<Path> {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void accept(Path t) {
		if (logger.isDebugEnabled()) {
			logger.debug(t.toString());
			// TODO: Implement functional logic
		}

	}

}
