package com.bridgelab.utility;

/**
 * Purpose : Double ended node class for double ended queue
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 * @param <T> is generic type
 */
public class DENode<T> {

	private DENode<T> nextNode;
	private DENode<T> previousNode;
	private T t;

	public DENode<T> getNextNode() {
		return nextNode;
	}

	public DENode<T> getPreviousNode() {
		return previousNode;
	}

	public void setNextNode(DENode<T> nextNode) {
		this.nextNode = nextNode;
	}

	public void setPreviousNode(DENode<T> previousNode) {
		this.previousNode = previousNode;
	}

	public T getData() {
		return t;
	}

	public void setData(T t) {
		this.t = t;
	}
}
