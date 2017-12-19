package org.mule.service.app.util;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
	private T data;
	private TreeNode<T> parent;
	private List<TreeNode<T>> children = new ArrayList<TreeNode<T>>();

	public TreeNode(T data) {
		this.data = data;
	}

	public void addChild(TreeNode<T> node) {
		node.setParent(this);
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
}
