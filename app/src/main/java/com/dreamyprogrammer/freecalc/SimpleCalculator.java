package com.dreamyprogrammer.freecalc;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class SimpleCalculator {

    private StringBuilder expression = new StringBuilder();
    private String expressionFinal;

    public void onButtonNumPressed(int id) {
    }

    public String getText(){
        return expression.toString();

    };

    public String getEquallyn() {
        expressionFinal = expression.toString();
        expressionFinal = expressionFinal.replaceAll("%", "/100");
        Context rhino = Context.enter();
        rhino.setOptimizationLevel(-1);
        try {
            Scriptable scriptable = rhino.initStandardObjects();
            return rhino.evaluateString(scriptable, expressionFinal,"javascript", 1, null).toString();

        }catch (Exception e){
            return "Error";
        }
    }
}
