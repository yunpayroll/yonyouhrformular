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

import java.sql.Time;
import java.util.Stack;

import com.yunpayroll.formular.ExpressionVisitor;
import com.yunpayroll.formular.ParseException;

/**
 * A Time in the form {t 'hh:mm:ss'}
 */
public class TimeValue implements Expression {

    private Time value;
    private String timeValue;

    public TimeValue(String value) {
    	this.timeValue = value;
        this.value = Time.valueOf(value.substring(1, value.length() - 1));
    }

    @Override
    public Object accept(ExpressionVisitor expressionVisitor) throws ParseException {
        return timeValue;
    }

    public Time getValue() {
        return value;
    }

    public void setValue(Time d) {
        value = d;
    }

    @Override
    public String toString() {
        return "{t '" + value + "'}";
    }
}