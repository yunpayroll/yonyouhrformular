
package com.yunpayroll.formular.express;

import com.yunpayroll.formular.ExpressionVisitor;
import com.yunpayroll.formular.ParseException;


public class AndExpression extends BinaryExpression {

    public AndExpression(Expression leftExpression, Expression rightExpression) {
        setLeftExpression(leftExpression);
        setRightExpression(rightExpression);
    }

    @Override
    public Object accept(ExpressionVisitor expressionVisitor) throws ParseException  {
    	Object obj = getLeftExpression().accept(expressionVisitor);
    	Object obj1 = getRightExpression().accept(expressionVisitor);
    	if(obj instanceof Boolean &&obj1 instanceof Boolean) {
    		Boolean nobj = (Boolean)obj;
    		Boolean nobj1 = (Boolean)obj1;
    		return nobj&&nobj1;
    	}
    	throw new ParseException("不支持的类型");
    }

    @Override
    public String getStringExpression() {
        return "AND";
    }
}
