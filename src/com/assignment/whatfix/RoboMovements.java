package com.assignment.whatfix;

import java.util.HashMap;
import java.util.Map;

import com.assignment.whatfix.pojo.ChildPositions;
import com.assignment.whatfix.pojo.Node;
import com.assignment.whatfix.pojo.Tree;

public class RoboMovements {
	
	static String right = "RIGHT";
	static String left = "LEFT";
	static String up = "UP";
	static String down = "DOWN";
	static int total = 0;

	public static void main(String[] args) {

		int n = 4;
		int i = 1, j = 1;

		Tree<String> t = new Tree<String>();
		Node<String> root = new Node<String>(i + "" + j, "null");

		t.setRootElement(root);
		treeform(root, i, j, n, t);

		System.out.println(total);

	}

	public static void treeform(Node<String> parent, int i, int j, int n,
			Tree<String> t) {

		HashMap<String, ChildPositions> hm = findChildSteps(i, j, n);

		for (Map.Entry<String, ChildPositions> entry : hm.entrySet()) {

			ChildPositions value = entry.getValue();
			int x = value.i;
			int y = value.j;
			String data = x + "" + y;
			Node<String> child = new Node<String>(data, parent.getPath());

			if (!child.getPath().contains("," + data + ",")) {

				parent.addChild(child);

				if (data.equals(n + "" + n)) {
					total++;
				} else {
					treeform(child, x, y, n, t);
				}

			}

		}
	}

	public static HashMap<String, ChildPositions> findChildSteps(int i, int j,
			int n) {
		// TODO Auto-generated method stub
		HashMap<String, ChildPositions> chp = new HashMap<String, ChildPositions>();

		ChildPositions cpr = sideStep(i, j, n, "right");

		if (cpr != null) {
			chp.put(right, cpr);
		}

		ChildPositions cpl = sideStep(i, j, n, "left");

		if (cpl != null) {
			chp.put(left, cpl);
		}

		ChildPositions cpU = verticalStep(i, j, n, "up");

		if (cpU != null) {
			chp.put(up, cpU);
		}

		ChildPositions cpd = verticalStep(i, j, n, "down");

		if (cpd != null) {
			chp.put(down, cpd);
		}

		return chp;
	}

	public static ChildPositions sideStep(int i, int j, int n, String type) {

		int tj = 0;

		if (type.equals("right")) {

			tj = j + 1;

			if (tj <= n) {
				return new ChildPositions(i, tj);
			} else {
				return null;
			}

		} else {

			tj = j - 1;

			if (tj >= 1) {
				return new ChildPositions(i, tj);
			} else {
				return null;
			}

		}

	}

	public static ChildPositions verticalStep(int i, int j, int n, String type) {

		int ti = 0;

		if (type.equals("up")) {

			ti = i - 1;

			if (ti >= 1) {
				return new ChildPositions(ti, j);
			} else {
				return null;
			}

		} else {

			ti = i + 1;

			if (ti <= n) {
				return new ChildPositions(ti, j);
			} else {
				return null;
			}

		}

	}

}
