package com.assignment.whatfix.pojo;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

	public T data;
	public String path;
	public List<Node<T>> children;

	public Node() {
		super();
	}

	public Node(T data, String path) {
		this();
		setData(data);
		setPath(path + "," + data);
	}

	public List<Node<T>> getChildren() {
		if (this.children == null) {
			return new ArrayList<Node<T>>();
		}
		return this.children;
	}

	public void setChildren(List<Node<T>> children) {
		this.children = children;
	}

	public int getNumberOfChildren() {
		if (children == null) {
			return 0;
		}
		return children.size();
	}

	public void addChild(Node<T> child) {
		if (children == null) {
			children = new ArrayList<Node<T>>();
		}
		children.add(child);
	}

	public void insertChildAt(int index, Node<T> child)
			throws IndexOutOfBoundsException {
		if (index == getNumberOfChildren()) {
			// this is really an append
			addChild(child);
			return;
		} else {
			children.get(index); // just to throw the exception, and stop here
			children.add(index, child);
		}
	}

	public void removeChildAt(int index) throws IndexOutOfBoundsException {
		children.remove(index);
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{").append(getData().toString()).append(",[");
		int i = 0;
		for (Node<T> e : getChildren()) {
			if (i > 0) {
				sb.append(",");
			}
			sb.append(e.getData().toString());
			i++;
		}
		sb.append("]").append("}");
		return sb.toString();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
