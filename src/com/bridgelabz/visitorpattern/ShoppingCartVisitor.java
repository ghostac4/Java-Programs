package com.bridgelab.designpattern.behavioraldesignpatterns;

public interface ShoppingCartVisitor {

	int visit(Book book);
	int visit(Fruit fruit);
}
