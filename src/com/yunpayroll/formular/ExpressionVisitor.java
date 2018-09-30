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
 * but WITHOUT ANY WARRANTYthrows ParseException ; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-2.1.html>.
 * #L%
 */
package com.yunpayroll.formular ;

import com.yunpayroll.formular.express.Addition;
import com.yunpayroll.formular.express.AndExpression;
import com.yunpayroll.formular.express.BitwiseAnd;
import com.yunpayroll.formular.express.BitwiseOr;
import com.yunpayroll.formular.express.BitwiseXor;
import com.yunpayroll.formular.express.CaseExpression;
import com.yunpayroll.formular.express.CastExpression;
import com.yunpayroll.formular.express.Column;
import com.yunpayroll.formular.express.Concat;
import com.yunpayroll.formular.express.DateTimeLiteralExpression;
import com.yunpayroll.formular.express.DateValue;
import com.yunpayroll.formular.express.Division;
import com.yunpayroll.formular.express.DoubleValue;
import com.yunpayroll.formular.express.EqualsTo;
import com.yunpayroll.formular.express.Function;
import com.yunpayroll.formular.express.GreaterThan;
import com.yunpayroll.formular.express.GreaterThanEquals;
import com.yunpayroll.formular.express.HexValue;
import com.yunpayroll.formular.express.IsNullExpression;
import com.yunpayroll.formular.express.LongValue;
import com.yunpayroll.formular.express.MinorThan;
import com.yunpayroll.formular.express.MinorThanEquals;
import com.yunpayroll.formular.express.Modulo;
import com.yunpayroll.formular.express.Multiplication;
import com.yunpayroll.formular.express.NotEqualsTo;
import com.yunpayroll.formular.express.NotExpression;
import com.yunpayroll.formular.express.NullValue;
import com.yunpayroll.formular.express.OrExpression;
import com.yunpayroll.formular.express.Parenthesis;
import com.yunpayroll.formular.express.SelectExpressionItem;
import com.yunpayroll.formular.express.SignedExpression;
import com.yunpayroll.formular.express.StringValue;
import com.yunpayroll.formular.express.Subtraction;
import com.yunpayroll.formular.express.TimeKeyExpression;
import com.yunpayroll.formular.express.TimeValue;
import com.yunpayroll.formular.express.TimestampValue;
import com.yunpayroll.formular.express.WhenClause;


public interface ExpressionVisitor {

	Object visit(SelectExpressionItem selectItem)throws ParseException ;
	
	Object visit(Function function)throws ParseException ;

	Object visit(AndExpression andExpression)throws ParseException ;

	Object visit(OrExpression orExpression)throws ParseException ;

	Object visit(IsNullExpression isNullExpression)throws ParseException ;

	Object visit(NotExpression notExpression)throws ParseException ;

	Object visit(Column column)throws ParseException ;

	Object visit(LongValue longValue)throws ParseException ;

	Object visit(Concat concat)throws ParseException ;

	Object visit(Addition addition)throws ParseException ;

	Object visit(BitwiseAnd bitwiseAnd)throws ParseException ;

	Object visit(BitwiseOr bitwiseOr)throws ParseException ;

	Object visit(BitwiseXor bitwiseXor)throws ParseException ;

	Object visit(Division division)throws ParseException ;

	Object visit(Modulo modulo)throws ParseException ;

	Object visit(Multiplication multiplication)throws ParseException ;

	Object visit(Subtraction subtraction)throws ParseException ;

	Object visit(WhenClause whenClause)throws ParseException ;

	Object visit(CaseExpression caseExpression)throws ParseException ;

	Object visit(DateTimeLiteralExpression dateTimeLiteralExpression)throws ParseException ;

	Object visit(CastExpression castExpression)throws ParseException ;

	Object visit(TimestampValue timestampValue)throws ParseException ;

	Object visit(TimeValue timeValue)throws ParseException ;

	Object visit(DateValue dateValue)throws ParseException ;

	Object visit(StringValue stringValue)throws ParseException ;

	Object visit(HexValue hexValue)throws ParseException ;

	Object visit(DoubleValue doubleValue)throws ParseException ;

	Object visit(NullValue nullValue)throws ParseException ;

	Object visit(Parenthesis parenthesis)throws ParseException ;

	Object visit(NotEqualsTo notEqualsTo)throws ParseException ;

	Object visit(GreaterThan greaterThan)throws ParseException ;

	Object visit(EqualsTo equalsTo)throws ParseException ;

	Object visit(MinorThan minorThan)throws ParseException ;

	Object visit(MinorThanEquals minorThanEquals)throws ParseException ;

	Object visit(GreaterThanEquals greaterThanEquals)throws ParseException ;

	Object visit(TimeKeyExpression timeKeyExpression)throws ParseException ;

	Object visit(SignedExpression signedExpression)throws ParseException ;




}
