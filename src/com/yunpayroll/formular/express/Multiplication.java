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


public class Multiplication extends BinaryExpression {

    @Override
    public Object accept(ExpressionVisitor expressionVisitor)throws ParseException  {
    	Object left = this.getLeftExpression().accept(expressionVisitor);
    	Object right = this.getRightExpression().accept(expressionVisitor);
    	
    	if( left instanceof Double && right instanceof Double ) {
    		return (Double)left*(Double)right;
    	} else if( left instanceof Long && right instanceof Long ) {
    		return (Long)left*(Long)right;
    	} else if( left instanceof Double && right instanceof Long ) {
    		return (Double)left*(Long)right;
    	} else if( left instanceof Long && right instanceof Double ) {
    		return (Long)left*(Double)right;
    	}
    	
    	
        return null;
    }

    @Override
    public String getStringExpression() {
        return "*";
    }
}
