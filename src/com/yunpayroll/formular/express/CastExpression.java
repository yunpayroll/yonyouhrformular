package com.yunpayroll.formular.express;

import java.util.Stack;

import com.yunpayroll.formular.ExpressionVisitor;
import com.yunpayroll.formular.ParseException;


/**
 *
 * @author tw
 */
public class CastExpression implements Expression {

    private Expression leftExpression;
    private ColDataType type;
    private boolean useCastKeyword = true;

    public ColDataType getType() {
        return type;
    }

    public void setType(ColDataType type) {
        this.type = type;
    }

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public void setLeftExpression(Expression expression) {
        leftExpression = expression;
    }

    @Override
    public Object accept(ExpressionVisitor expressionVisitor)throws ParseException  {
        return null;
    }

    public boolean isUseCastKeyword() {
        return useCastKeyword;
    }

    public void setUseCastKeyword(boolean useCastKeyword) {
        this.useCastKeyword = useCastKeyword;
    }

    @Override
    public String toString() {
        if (useCastKeyword) {
            return "CAST(" + leftExpression + " AS " + type.toString() + ")";
        } else {
            return leftExpression + "::" + type.toString();
        }
    }
}
