package com.yunpayroll.formular;

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
import com.yunpayroll.formular.express.Expression;
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

public class SelectItemVisitorImpl implements ExpressionVisitor{
	
	private Parser parser;
	
	public SelectItemVisitorImpl(Parser parser) {
		this.parser = parser;
	}

	@Override
	public Object visit(SelectExpressionItem selectExpressionItem)throws ParseException {
		return selectExpressionItem.accept(this);
	}


	@Override
	public Object visit(Function function)throws ParseException {
		return function.accept(this);
	}

	@Override
	public Object visit(AndExpression andExpression)throws ParseException {
		return andExpression.accept(this);
	}

	@Override
	public Object visit(OrExpression orExpression) throws ParseException{
		 
		return orExpression.accept(this);
	}

	@Override
	public Object visit(IsNullExpression isNullExpression) throws ParseException {
	
		return 	isNullExpression.accept(this);
	}

	@Override
	public Object visit(NotExpression notExpression)throws ParseException {
		
		return  notExpression.accept(this);
	}

	@Override
	public Object visit(Column column)throws ParseException{
		return column.accept(this);
	}

	@Override
	public Object visit(LongValue longValue)throws ParseException{
		
		return longValue.accept(this);
	}

	@Override
	public Object visit(Concat concat)throws ParseException{
		return concat.accept(this);
	}

	@Override
	public Object visit(Addition addition)throws ParseException{
		return addition.accept(this);
	}

	@Override
	public Object visit(BitwiseAnd bitwiseAnd)throws ParseException{
		return bitwiseAnd.accept(this);
	}

	@Override
	public Object visit(BitwiseOr bitwiseOr)throws ParseException{
		return bitwiseOr.accept(this);
	}

	@Override
	public Object visit(BitwiseXor bitwiseXor)throws ParseException{
		return bitwiseXor.accept(this);
	}

	@Override
	public Object visit(Division division)throws ParseException{
		
		
		return division.accept(this);
	}
	
//	private Object binExpress(Object left,Object right){
//		if( left==null || right==null) {
//			return left==null?( right==null?null:right ):left;
//		}
//		if( left instanceof Long && right instanceof Long ) {
//			return (Long) left +  (Long) right ;
//		} else if(  left instanceof Double && right instanceof Double  ) {
//			return (Double) left +  (Double) right ;
//		} else if(  left instanceof Double && right instanceof Long  ) {
//			return (Double) left +  (Long) right ;
//		} else if(  left instanceof Long && right instanceof Double  ) {
//			return (Long) left +  (Double) right ;
//		}
//		return null;
//	}

	@Override
	public Object visit(Modulo modulo)throws ParseException{
		return modulo.accept(this);
	}

	@Override
	public Object visit(Multiplication multiplication)throws ParseException{
		 return multiplication.accept(this);
	}

	@Override
	public Object visit(Subtraction subtraction)throws ParseException{
		return subtraction.accept(this);
	}

	@Override
	public Object visit(WhenClause whenClause)throws ParseException{
		return whenClause.accept(this);
	}

	@Override
	public Object visit(CaseExpression caseExpression)throws ParseException{
		Expression caseExpress = caseExpression.getSwitchExpression();
		if(caseExpress!=null) {
			Object var = caseExpress.accept(this);
			for(Expression  express : caseExpression.getWhenClauses() ) {
				if(express instanceof WhenClause) {
					WhenClause wcExpress  = (WhenClause)express;
					Object condValue = wcExpress.getWhenExpression().accept(this);
					if( (var==null&& condValue==null) || var.equals(condValue)  ) {
						return wcExpress.getThenExpression().accept(this);
					}
				}
			}
			return caseExpression.getElseExpression().accept(this);
		} else {
			for(Expression  express : caseExpression.getWhenClauses() ) {
				if(express instanceof WhenClause) {
					WhenClause wcExpress  = (WhenClause)express;
					Boolean value =false;
					Object obj = wcExpress.getWhenExpression().accept(this);
					if(obj instanceof Boolean) {
						obj = (Boolean)obj;
					} else if(obj instanceof Long) {
						obj = obj.equals( 0l);
					}
					if(value) {
						return wcExpress.getThenExpression().accept(this);
					}
				}
			}
			return caseExpression.getElseExpression().accept(this);
		}
	}

	@Override
	public Object visit(DateTimeLiteralExpression dateTimeLiteralExpression)throws ParseException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(CastExpression castExpression)throws ParseException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(TimestampValue timestampValue)throws ParseException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(TimeValue timeValue)throws ParseException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(DateValue dateValue)throws ParseException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(StringValue stringValue)throws ParseException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(HexValue hexValue)throws ParseException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(DoubleValue doubleValue)throws ParseException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NullValue nullValue)throws ParseException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Parenthesis parenthesis)throws ParseException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NotEqualsTo notEqualsTo)throws ParseException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(GreaterThan greaterThan)throws ParseException{
		return greaterThan.accept(this);
	}

	@Override
	public Object visit(EqualsTo equalsTo)throws ParseException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(MinorThan minorThan)throws ParseException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(MinorThanEquals minorThanEquals)throws ParseException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(GreaterThanEquals greaterThanEquals)throws ParseException{
		return greaterThanEquals.accept(this);
	}

	@Override
	public Object visit(TimeKeyExpression timeKeyExpression)throws ParseException{
		return timeKeyExpression.accept(this);
	}

	@Override
	public Object visit(SignedExpression signedExpression)throws ParseException{
		return signedExpression.accept(this);
	}
	public Parser getParser() {
		return parser;
	}
}
