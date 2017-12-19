package org.mule.service.app.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tree<T> {
	Logger logger = LoggerFactory.getLogger(getClass());

	private TreeNode<T> root = null;

	public Tree() {
	};

	public Tree(TreeNode<T> root) {
		this.root = root;
	}

	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}

	public boolean hasRoot() {
		return this.root == null;
	}

	public TreeNode<T> getRoot() {
		return root;
	}

	public void print() {
		root.print();
	}
}
