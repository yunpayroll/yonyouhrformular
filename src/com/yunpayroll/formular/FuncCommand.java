package com.yunpayroll.formular;

import com.yunpayroll.formular.express.ExpressionList;

public interface FuncCommand {
	Object execute( ExpressionVisitor expressionVisitor,ExpressionList parameters) throws ParseException;
}
