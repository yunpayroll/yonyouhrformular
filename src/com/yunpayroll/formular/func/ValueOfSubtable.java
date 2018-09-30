package com.yunpayroll.formular.func;

import com.yunpayroll.formular.ExpressionVisitor;
import com.yunpayroll.formular.FuncCommand;
import com.yunpayroll.formular.ParseException;
import com.yunpayroll.formular.express.Column;
import com.yunpayroll.formular.express.ExpressionList;
import com.yunpayroll.formular.express.GlobalVar;
import com.yunpayroll.formular.express.SelectExpressionItem;

public class ValueOfSubtable extends SelectExpressionItem implements FuncCommand {

	 Column column = null;
     String sql =null;
     GlobalVar var = null;
     
	@Override
	public Object execute(ExpressionVisitor expressionVisitor,
			ExpressionList parameters) throws ParseException {
		System.out.println("a");
		return null;
	}
	
	@Override
	public Object accept(ExpressionVisitor expressionVisitor) throws ParseException  {
		
		return null;
	}

	public Column getColumn() {
		return column;
	}

	public void setColumn(Column column) {
		this.column = column;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public GlobalVar getVar() {
		return var;
	}

	public void setVar(GlobalVar var) {
		this.var = var;
	}
	@Override
	public String toString() {
		return   "ValueOfSubtable("+column+"="+sql+",@"+var+"@";
	}

}
