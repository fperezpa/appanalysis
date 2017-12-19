package org.mule.service.app.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TreeNode<T> {
	Logger logger = LoggerFactory.getLogger(getClass());
	private T data;
	private TreeNode<T> parent;
	private List<TreeNode<T>> children = new ArrayList<TreeNode<T>>();
	private int level = 0;

	public TreeNode(T data) {
		this.data = data;
	}

	public void addChild(TreeNode<T> node) {
		node.setParent(this);
		node.level = this.level + 1;
		children.add(node);
	}

	public TreeNode<T> getParent() {
		return parent;
	}

	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void print() {
		logger.info("Data:" + level + ":" + String.join("", Collections.nCopies(level, " ")) + data);
		for (TreeNode<T> each : children) {
			each.print();
		}
	}

}
