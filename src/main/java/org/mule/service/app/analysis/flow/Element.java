package org.mule.service.app.analysis.flow;

import java.util.List;
import java.util.UUID;

public class Element {

	private UUID id;

	private String name;

	private String type;

	private List<String> attributes;

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setAttributes(List<String> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		// Print Json representation
		return super.toString();
	}
}
