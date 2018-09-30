package com.yunpayroll.formular.func;

import com.yunpayroll.formular.ExpressionVisitor;
import com.yunpayroll.formular.FuncCommand;
import com.yunpayroll.formular.ParseException;
import com.yunpayroll.formular.express.Expression;
import com.yunpayroll.formular.express.ExpressionList;

public class ConcatFunc implements FuncCommand{

	@Override
	public Object execute(ExpressionVisitor expressionVisitor,
			ExpressionList parameters) throws ParseException {
		StringBuilder sb = new StringBuilder();
		for(Expression expression : parameters.getExpressions()){
			Object obj = expression.accept(expressionVisitor);
			sb.append( obj==null?"":obj.toString() );
		}
		return sb.toString();
	}

}
