/*
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2013 JSQLParser
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 2.1 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-2.1.html>.
 * #L%
 */
package com.yunpayroll.formular.express;

import com.yunpayroll.formular.ExpressionVisitor;
import com.yunpayroll.formular.ParseException;


public class Subtraction extends BinaryExpression {

    @Override
    public Object accept(ExpressionVisitor expressionVisitor)throws ParseException  {
    	Object obj = getLeftExpression().accept(expressionVisitor);
    	Object obj1 = getRightExpression().accept(expressionVisitor);
    	if(obj instanceof Long &&obj1 instanceof Long) {
    		Long nobj = (Long)obj;
    		Long nobj1 = (Long)obj1;
    		return nobj-nobj1;
    	}else if(obj instanceof Number || obj1 instanceof Number) {
    		Number nobj = (Number)obj;
    		Number nobj1 = (Number)obj1;
    		return (nobj==null?0:nobj.doubleValue())-(nobj1==null? 0:nobj1.doubleValue());
    	}
    	return null;
    	
    
    	
    }

    @Override
    public String getStringExpression() {
        return "-";
    }
}
