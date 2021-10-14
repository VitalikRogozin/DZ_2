package com.example.dz_2.calculator_domain;

public class CalculatorImp implements Calculator{

    @Override
    public double paramOperations(double argOne, double argTwo, Operation operation) {
        switch (operation){
            case ADD:
                return argOne + argTwo;
            case SUB:
                return argOne - argTwo;
            case MULT:
                return argOne * argTwo;
            case DIV:
                return argOne / argTwo;
        }
        return 0.0;
    }
}
