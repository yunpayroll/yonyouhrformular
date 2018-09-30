package com.yunpayroll.formular.func;

import com.yunpayroll.formular.ExpressionVisitor;
import com.yunpayroll.formular.FuncCommand;
import com.yunpayroll.formular.ParseException;
import com.yunpayroll.formular.express.Expression;
import com.yunpayroll.formular.express.ExpressionList;

public class Substring implements FuncCommand{

	public Substring() {
	}
	@Override
	public Object execute(ExpressionVisitor expressionVisitor,ExpressionList parameters)throws ParseException {
		if(parameters.getExpressions()==null ||parameters.getExpressions().size()!=3) {
			throw new ParseException();
		}
		// TODO 参数校验
		Object express1 = parameters.getExpressions().get(0).accept(expressionVisitor);
		Object express2 = parameters.getExpressions().get(1).accept(expressionVisitor);;
		Object express3 = parameters.getExpressions().get(2).accept(expressionVisitor);;
		if(express1!=null  && express2 instanceof Long && express3 instanceof Long ) {
			String rst = express1.toString();
			if( rst.length() >((Long)express3).intValue()) {
				return rst.substring(((Long)express2).intValue()-1 , ((Long)express3).intValue() );
			} else {
				return "";
			}
			
		}
		return null;	
	}

}
