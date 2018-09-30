
package com.yunpayroll.formular.express;

import com.yunpayroll.formular.ExpressionVisitor;
import com.yunpayroll.formular.ParseException;


public class Addition extends BinaryExpression {

    @Override
    public Object accept(ExpressionVisitor expressionVisitor) throws ParseException  {
    	Object obj = getLeftExpression().accept(expressionVisitor);
    	Object obj1 = getRightExpression().accept(expressionVisitor);
    	if(obj instanceof Long &&obj1 instanceof Long) {
    		Long nobj = (Long)obj;
    		Long nobj1 = (Long)obj1;
    		return nobj+nobj1;
    	}else if(obj instanceof String || obj1 instanceof Long) {
    		return (obj==null?"":obj.toString())+(obj1==null? "":obj1.toString());
    	}else if(obj instanceof Number || obj1 instanceof Number) {
    		Number nobj = (Number)obj;
    		Number nobj1 = (Number)obj1;
    		return (nobj==null?0:nobj.doubleValue())+(nobj1==null? 0:nobj1.doubleValue());
    	}
    	return null;
    	
    }

    @Override
    public String getStringExpression() {
        return "+";
    }
}
