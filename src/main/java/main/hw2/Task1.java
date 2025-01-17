package main.hw2;

public class Task1 {

    private Task1() {
    }

    public sealed interface Expr permits Constant, Negate, Exponent, Addition, Multiplication {
        double evaluate();
    }

    public record Constant(double value) implements Expr {
        @Override
        public double evaluate() {
            return value;
        }
    }

    public record Negate(Expr expr) implements Expr {
        @Override
        public double evaluate() {
            return -expr.evaluate();
        }
    }

    public record Exponent(Expr number, Expr degree) implements Expr {
        @Override
        public double evaluate() {
            return Math.pow(number.evaluate(), degree.evaluate());
        }
    }

    public record Addition(Expr first, Expr second) implements Expr {
        @Override
        public double evaluate() {
            return first.evaluate() + second.evaluate();
        }
    }

    public record Multiplication(Expr first, Expr second) implements Expr {
        @Override
        public double evaluate() {
            return first.evaluate() * second.evaluate();
        }
    }
}
