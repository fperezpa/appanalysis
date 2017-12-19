package org.mule.service.app.analysis;

import org.junit.Test;
import org.mule.service.app.util.Tree;
import org.mule.service.app.util.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TreeTest {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void printTree() {
		Tree<String> tree = new Tree<String>();
		TreeNode<String> node1 = new TreeNode<String>("Ramon");
		TreeNode<String> node2 = new TreeNode<String>("Daniel");
		TreeNode<String> node3 = new TreeNode<String>("Enzo");
		TreeNode<String> node4 = new TreeNode<String>("Beto");
		TreeNode<String> node5 = new TreeNode<String>("Guillermo");
		TreeNode<String> node6 = new TreeNode<String>("Ramiro");
		TreeNode<String> node7 = new TreeNode<String>("Juan");
		node1.addChild(node2);
		node1.addChild(node3);
		node3.addChild(node4);
		node3.addChild(node6);
		node4.addChild(node5);
		node4.addChild(node7);
		tree.setRoot(node1);
		tree.print();
	}

}
