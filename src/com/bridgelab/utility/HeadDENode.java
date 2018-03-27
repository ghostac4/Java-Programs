package com.bridgelab.utility;

/**
 * Purpose : Head node class for double ended queue
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 * @param <T> is a generic type
 */
public class HeadDENode<T> {

	private DENode<T> firstNode;
	
	public void setFirstNode(DENode<T> firstNode){
		this.firstNode = firstNode;
	}
	
	public DENode<T> getFirstNode(){
		return firstNode;
	}
}
