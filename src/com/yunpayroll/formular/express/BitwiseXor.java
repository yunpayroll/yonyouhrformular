
package com.yunpayroll.formular.express;

import java.util.Stack;

import com.yunpayroll.formular.ExpressionVisitor;
import com.yunpayroll.formular.ParseException;


public class BitwiseXor extends BinaryExpression {

    @Override
    public Object accept(ExpressionVisitor expressionVisitor)throws ParseException  {
        return null;
    }

    @Override
    public String getStringExpression() {
        return "^";
    }
}
