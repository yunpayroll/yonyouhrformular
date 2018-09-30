package com.yunpayroll.formular;

import com.yunpayroll.formular.express.SelectExpressionItem;

public class StringExpress extends SelectExpressionItem{
	
	private String  parameters;
	
	

	 
	
	public String getParameters() {
		return parameters;
	}
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
	
	@Override
	public Object accept(ExpressionVisitor expressionVisitor) throws ParseException  {
		
		return parameters;
	}
	@Override
	public String toString() {
		return   "StringExpress:"+parameters;
	}
}
