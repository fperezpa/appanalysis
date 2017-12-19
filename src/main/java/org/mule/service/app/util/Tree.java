package org.mule.service.app.util;

public class Tree<T> {

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
	
	@Override
	public String toString() {
		return super.toString();
	}

}
