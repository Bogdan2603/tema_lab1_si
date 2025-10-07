package tema1;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Tema1_cod 
{

    public static double eval(String expr) 
    {
        try 
        {
            expr = expr.replace("x", "*"); 
            Expression expression = new ExpressionBuilder(expr).build();
            return expression.evaluate();
        } 
        catch (Exception e) 
        {
            throw new RuntimeException("expresie invalida!!!");
        }
    }

    public static void main(String[] args) 
    {
        System.out.println(eval("5+3*2"));     
        System.out.println(eval("10/2+6-1"));  
    }
}
