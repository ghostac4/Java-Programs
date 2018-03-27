package com.bridgelab.designpattern.behavioraldesignpatterns;

/**
 * Purpose : Implementation of Observer Design Pattern 
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 24-03-2018
 */
public class ObserverPatternTest {

	public static void main(String[] args) {
		
		MyTopic myTopic = new MyTopic();
		
		Observer obs1 = new MyTopicSubscriber("obs1");
		Observer obs2 = new MyTopicSubscriber("obs2");
		Observer obs3 = new MyTopicSubscriber("obs3");
		
		myTopic.register(obs1);
		myTopic.register(obs2);
		myTopic.register(obs3);
		
		obs1.setSubject(myTopic);
		obs2.setSubject(myTopic);
		obs3.setSubject(myTopic);
		
		obs1.update();
		
		myTopic.postMessage("Hello");
		
	}

}
