package com.bridgelab.utility;

/**
 * Purpose : program for unordered list using linked list
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 20-03-2018
 * @param <T> is a generic type
 */
public class UnorderedList<T> {
	private HeadNode<T> headNode;
	
	/**
	 * constructor to initialize headnode
	 */
	public UnorderedList(){
		headNode = new HeadNode<T>();
	}
	
	/**
	 * function to add the node at the end of the list
	 * @param t is generic type
	 */
	public void add(T t){
		Node<T> currentNode = headNode.getFirstNode();
		if(currentNode == null){
			Node<T> node = new Node<T>();
			headNode.setFirstNode(node);
			node.setData(t);
		}else{
			while(!(currentNode.getNextNode()==null)){
				currentNode = currentNode.getNextNode();
			}
			Node<T> node = new Node<T>();
			currentNode.setNextNode(node);
			node.setData(t);
		}
	}
	
	/**
	 * function to remove the node from list
	 * @param t is generic type
	 */
	public void remove(T t){
		Node<T> currentNode = headNode.getFirstNode();
		if(!(currentNode == null)){
			if(currentNode.getData().equals(t)){
				currentNode.setData(null);
				headNode.setFirstNode(currentNode.getNextNode());
				currentNode.setNextNode(null);
			}else{
				while(!(currentNode.getNextNode() == null)){
					Node<T> previousNode = currentNode;
					currentNode = currentNode.getNextNode();
					if(currentNode.getData().equals(t)){
						currentNode.setData(null);
						previousNode.setNextNode(currentNode.getNextNode());
						currentNode.setNextNode(null);
					}
				}
			}
		}
	}
	
	/**
	 * function to search the element in the list
	 * @param t is a generic type
	 * @return true if the element is found else false
	 */
	public boolean search(T t){
		Node<T> currentNode = headNode.getFirstNode();
		if(!(currentNode == null)){
			if(currentNode.getData().equals(t)){
				return true;
			}else{
				while(!(currentNode.getNextNode() == null)){
					currentNode = currentNode.getNextNode();
					if(currentNode.getData().equals(t)){
						return true;
					}
				}
				return false;
			}
		}else
			return false;
	}
	
	/**
	 * function to check if the list is empty or not
	 * @return true if the list is empty else false
	 */
	public boolean isEmpty(){
		Node<T> currentNode = headNode.getFirstNode();
		if(currentNode == null)
			return true;
		return false;
	}
	
	/**
	 * function to get the size of the list
	 * @return number of size
	 */
	public int size(){
		Node<T> currentNode = headNode.getFirstNode();
		int sizeCount=0;
		if(!(currentNode == null)){
			sizeCount++;
			while(!(currentNode.getNextNode() == null)){
				currentNode = currentNode.getNextNode();
				sizeCount++;
			}
			return sizeCount;
		}else
			return sizeCount;
	}
	
	/**
	 * function to add the element at the end of the list
	 * @param t is generic type
	 */
	public void append(T t){
		Node<T> currentNode = headNode.getFirstNode();
		if(currentNode == null){
			Node<T> node = new Node<T>();
			headNode.setFirstNode(node);
			node.setData(t);
		}else{
			while(!(currentNode.getNextNode()==null)){
				currentNode = currentNode.getNextNode();
			}
			Node<T> node = new Node<T>();
			currentNode.setNextNode(node);
			node.setData(t);
		}
	}
	
	/**
	 * function to get the index position of the given element
	 * @param t is generic type
	 * @return number of the position
	 */
	public int index(T t){
		Node<T> currentNode = headNode.getFirstNode();
		int indexCount=-1;
		if(!(currentNode == null)){
			indexCount++;
			if(currentNode.getData().equals(t)){
				return indexCount;
			}else{
				while(!(currentNode.getNextNode() == null)){
					currentNode = currentNode.getNextNode();
					indexCount++;
					if(currentNode.getData().equals(t)){
						return indexCount;
					}
				}
				return indexCount;
			}
		}else
			return indexCount;
	}
	
	/**
	 * function to insert the element at the given position 
	 * @param position is a number at which the element is to be inserted
	 * @param t is ageneric type
	 */
	public void insert(int position,T t){
		Node<T> currentNode = headNode.getFirstNode();
		if(position==0){
			Node<T> node = new Node<T>();
			node.setNextNode(headNode.getFirstNode());
			headNode.setFirstNode(node);
			node.setData(t);
		}else{
			int indexCount=0;
			while(!(position == indexCount)){
				currentNode = currentNode.getNextNode();
				indexCount++;
			}
			Node<T> node = new Node<T>();
			node.setNextNode(currentNode.getNextNode());
			currentNode.setNextNode(node);
			node.setData(t);
		}
	}
	
	/**
	 * function to remove the element from the end of list
	 * @return T generic type
	 */
	public T pop(){
		Node<T> currentNode = headNode.getFirstNode();
		if(currentNode.getNextNode() == null){
			headNode.setFirstNode(null);
			T t = currentNode.getData();
			currentNode.setData(null);
			return t;
		}else{
			Node<T> previousNode=null;
			while(!(currentNode.getNextNode() == null)){
				previousNode = currentNode;
				currentNode = currentNode.getNextNode();
			}
			previousNode.setNextNode(null);
			T t = currentNode.getData();
			currentNode.setData(null);
			return t;
		}
	}
	
	/**
	 * function to remove the element from the given position
	 * @param position is number at which the element is to be removed
	 * @return T generic type
	 */
	public T pop(int position){
		Node<T> currentNode = headNode.getFirstNode();
		if(position==0){
			headNode.setFirstNode(currentNode.getNextNode());
			T t = currentNode.getData();
			currentNode.setData(null);
			currentNode.setNextNode(null);
			return t;
		}else{
			int indexCount=0;
			Node<T> previousNode=null;
			while(!(position == indexCount)){
				previousNode = currentNode;
				currentNode = currentNode.getNextNode();
				indexCount++;
			}
			previousNode.setNextNode(currentNode.getNextNode());
			T t = currentNode.getData();
			currentNode.setData(null);
			currentNode.setNextNode(null);
			return t;
		}
	}
	
	/**
	 * function to display the elements from the list
	 */
	public void display(){
		Node<T> currentNode = headNode.getFirstNode();
		if(!(currentNode == null)){
			System.out.print(currentNode.getData()+" ");
			while(!(currentNode.getNextNode() == null)){
				currentNode = currentNode.getNextNode();
				System.out.print(currentNode.getData()+" ");
			}
		}else{
			System.out.println("List is empty");
		}
	}
}