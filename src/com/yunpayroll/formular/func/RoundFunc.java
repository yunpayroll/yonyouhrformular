package com.yunpayroll.formular.func;

import java.math.BigDecimal;
import java.util.List;

import com.yunpayroll.formular.ExpressionVisitor;
import com.yunpayroll.formular.FuncCommand;
import com.yunpayroll.formular.ParseException;
import com.yunpayroll.formular.express.Expression;
import com.yunpayroll.formular.express.ExpressionList;

public class RoundFunc implements FuncCommand {

	@Override
	public Object execute(ExpressionVisitor expressionVisitor,
			ExpressionList parameters) throws ParseException {
		List<Expression> expList = parameters.getExpressions();
		if(expList==null ||expList.size()!=2 ) {
			throw new  ParseException("function round expept 2 paramters" );
		}
		Object v= expList.get(0).accept(expressionVisitor);
		Object v2=expList.get(1).accept(expressionVisitor);
		
		if(v instanceof Number && v2 instanceof Long ) {
			BigDecimal bg = new BigDecimal( ((Number)v).doubleValue() );
			double f1 = bg.setScale( ((Long)v2).intValue(), BigDecimal.ROUND_HALF_UP).doubleValue();
			return f1;
		}
		
		
		return null;
	}

}
