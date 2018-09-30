package com.yunpayroll.formular;

import java.util.List;
import java.util.Map;

import com.yunpayroll.formular.express.SelectExpressionItem;

public class PKExpressItem extends SelectExpressionItem{
	
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
		return   "PKExpressItem:"+parameters;
	}
}
