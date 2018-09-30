package com.yunpayroll.formular;

import java.util.List;
import java.util.Map;

import com.yunpayroll.formular.express.SelectExpressionItem;

public class UpdateFromAnotherPeriod extends SelectExpressionItem{
	
	private List<Map<String,String>>  parameters;

	public List<Map<String, String>> getParameters() {
		return parameters;
	}

	public void setParameters(List<Map<String, String>> parameters) {
		this.parameters = parameters;
	}
	
	@Override
	public Object accept(ExpressionVisitor expressionVisitor) throws ParseException  {
		
		return null;
	}
	@Override
	public String toString() {
		return    "UpdateFromAnotherPeriod:"+parameters;
	}
}
