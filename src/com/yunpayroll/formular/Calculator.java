package com.yunpayroll.formular;

import java.io.StringReader;

import com.yunpayroll.formular.express.SelectExpressionItem;

public class Calculator {
	
	private Parser parser = new Parser(new StringReader(""));
	private SelectExpressionItem item ;
	
	public SelectExpressionItem parse( String formular) throws ParseException {
		StringReader reader = new StringReader(formular);
		parser.ReInit(reader);
		item = parser.Statement();
		return item;
	}
	
	public Object getValue(SelectExpressionItem item ) throws ParseException {
		return item.accept(null);
	}
	
	
}
