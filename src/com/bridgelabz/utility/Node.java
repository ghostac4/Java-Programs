package com.bridgelab.utility;

/**
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 * @param <T> is a generic type
 */
public class Node<T> {
	private T t;
	private Node<T> nextNode;
	
	public void setNextNode(Node<T> nextNode){
		this.nextNode = nextNode;
	}
	
	public Node<T> getNextNode(){
		return nextNode;
	}
	
	public void setData(T data){
		this.t= data;
	}
	
	public T getData(){
		return t;
	}
}
