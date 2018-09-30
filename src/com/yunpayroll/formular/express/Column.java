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

import java.util.Map;
import java.util.Stack;

import com.yunpayroll.formular.ASTNodeAccessImpl;
import com.yunpayroll.formular.ExpressionVisitor;
import com.yunpayroll.formular.ParseException;
import com.yunpayroll.formular.SelectItemVisitorImpl;


/**
 * A column. It can have the table name it belongs to.
 */
public final class Column extends ASTNodeAccessImpl implements Expression, MultiPartName {

    private Table table;
    private String columnName;

    public Column() {
    }

    public Column(Table table, String columnName) {
        setTable(table);
        setColumnName(columnName);
    }

    public Column(String columnName) {
        this(null, columnName);
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String string) {
        columnName = string;
    }

     

     

    @Override
    public Object accept(ExpressionVisitor expressionVisitor)throws ParseException  {
    	String tname = getTable().getName();
    	Map<String,Object> wadata = (Map<String,Object>)((SelectItemVisitorImpl)expressionVisitor).getParser().getVariable(tname);
        return wadata.get(getColumnName());
    }

	@Override
	public String getFullyQualifiedName() {
		return null;
	}
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		if(table!=null) {
			s.append(table.getName()).append('.');
		}
		s.append(columnName);
		return  s.toString();
	}

    
}
