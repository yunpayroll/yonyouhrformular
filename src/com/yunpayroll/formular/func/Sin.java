package com.yunpayroll.formular.func;

import com.yunpayroll.formular.ExpressionVisitor;
import com.yunpayroll.formular.FuncCommand;
import com.yunpayroll.formular.ParseException;
import com.yunpayroll.formular.express.Expression;
import com.yunpayroll.formular.express.ExpressionList;

public class Sin implements FuncCommand{

	public Sin() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Object execute(ExpressionVisitor expressionVisitor,ExpressionList parameters)throws ParseException {
		if(parameters.getExpressions()==null ||parameters.getExpressions().size()!=1) {
			throw new ParseException();
		}
		Expression express = parameters.getExpressions().get(0);
		Object obj = express.accept(expressionVisitor);
		return Math.sin(((Number)obj).doubleValue());
	}

}
