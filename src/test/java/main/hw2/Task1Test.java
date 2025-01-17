package main.hw2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task1Test {

    @Test
    public void testConstant() {
        Task1.Expr constant = new Task1.Constant(2.0);
        assertEquals(2.0, constant.evaluate());
    }

    @Test
    public void testNegate() {
        Task1.Expr negate = new Task1.Negate(new Task1.Constant(2.0));
        assertEquals(-2.0, negate.evaluate());
    }

    @Test
    public void testExponent() {
        Task1.Expr exponent = new Task1.Exponent(new Task1.Constant(2.0), new Task1.Constant(3.0));
        assertEquals(8.0, exponent.evaluate());
    }

    @Test
    public void testAddition() {
        Task1.Expr addition = new Task1.Addition(new Task1.Constant(2.0), new Task1.Constant(3.0));
        assertEquals(5.0, addition.evaluate());
    }

    @Test
    public void testMultiplication() {
        Task1.Expr multiplication = new Task1.Multiplication(new Task1.Constant(2.0), new Task1.Constant(3.0));
        assertEquals(6.0, multiplication.evaluate());
    }

    @Test
    public void testComplexExpression() {
        Task1.Expr complexExpr = new Task1.Addition(
            new Task1.Multiplication(new Task1.Constant(2.0), new Task1.Constant(3.0)),
            new Task1.Negate(new Task1.Constant(1.0))
        );
        assertEquals(5.0, complexExpr.evaluate());
    }
}
