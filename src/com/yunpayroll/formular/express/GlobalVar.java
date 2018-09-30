package com.yunpayroll.formular.express;

import java.util.Stack;

import com.yunpayroll.formular.ExpressionVisitor;

public class GlobalVar implements Expression {
	private String stringValue;
	private Object value;
	
	public GlobalVar(String image) {
		this.stringValue = image;
	}

	@Override
	public Object accept(ExpressionVisitor expressionVisitor) {
		return value;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return stringValue==null ? "": stringValue;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
