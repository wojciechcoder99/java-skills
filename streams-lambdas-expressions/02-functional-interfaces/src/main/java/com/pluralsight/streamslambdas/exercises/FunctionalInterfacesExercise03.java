package com.pluralsight.streamslambdas.exercises;

import java.util.function.DoubleBinaryOperator;

public class FunctionalInterfacesExercise03 {

    public enum ArithmeticOperation {
        ADD(Double::sum),
        SUBTRACT((a, b) -> a - b),
        MULTIPLY((a, b) -> a * b),
        DIVIDE((a, b) -> a / b);

        private final DoubleBinaryOperator operator;

        ArithmeticOperation(DoubleBinaryOperator operator) {
            this.operator = operator;
        }

        public DoubleBinaryOperator getOperator() {
            return operator;
        }
    }

    /**
     * Exercise 3: Call a DoubleBinaryOperator to perform a calculation.
     *
     * @param a         First input value.
     * @param b         Second input value.
     * @param operation The operation to apply.
     * @return The result of applying the operation to the two input values.
     */
    public double calculate(double a, double b, ArithmeticOperation operation) {
        return operation.getOperator().applyAsDouble(a, b);
    }
}
