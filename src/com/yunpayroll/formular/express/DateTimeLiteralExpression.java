/*
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2016 JSQLParser
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
 /*
 * Copyright (C) 2016 JSQLParser.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package com.yunpayroll.formular.express;

import java.util.Stack;

import com.yunpayroll.formular.ExpressionVisitor;
import com.yunpayroll.formular.ParseException;

/**
 *
 * @author toben
 */
public class DateTimeLiteralExpression implements Expression {

    private String value;
    private DateTime type;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public DateTime getType() {
        return type;
    }

    public void setType(DateTime type) {
        this.type = type;
    }

    @Override
    public Object accept(ExpressionVisitor expressionVisitor) throws ParseException {
        expressionVisitor.visit(this);
        return null;
    }

    @Override
    public String toString() {
        return type.name() + " " + value;
    }

    public static enum DateTime {
        DATE, TIME, TIMESTAMP;
    }
}
