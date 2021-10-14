package com.example.dz_2.calculator_ui;

import com.example.dz_2.calculator_domain.Calculator;
import com.example.dz_2.calculator_domain.Operation;

public class CalculatorPresenter {

    private static final int BASE = 10;

    private final CalculatorView view;
    private final Calculator calculator;

    private Double argOne = 0.0;
    private Double argTwo = null;

    private Operation prevOperation;
    private boolean isDotPressed;

    private int devider;

    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void onDigitPressed(int digit) {
        if (argTwo == null) {
            if(isDotPressed) {
                argOne = argOne + digit / (double) devider;
                devider *= BASE;
            } else{
                argOne = argOne * BASE + digit;
            }
            displayResult(argOne);
        } else {
            if(isDotPressed){
                argTwo = argTwo + digit / (double) devider;
                devider *= BASE;

            }else {
                argTwo = argTwo * BASE + digit;
            }
            displayResult(argTwo);
        }

    }

    public void onOperationPressed(Operation operation) {
        if (prevOperation != null) {
            double result = calculator.paramOperations(argOne, argTwo, operation);
            view.showResult(String.valueOf(result));

            argOne = result;
        }
        prevOperation = operation;
        argTwo = 0.0;
        isDotPressed = false;
    }

    public void onDotPressed() {
        if(!isDotPressed) {
            isDotPressed = true;
            devider = BASE;
        }
    }

    public void displayResult(double arg) {
        long longValue = (long) arg;
        if (longValue == arg) {
            view.showResult(String.valueOf(longValue));

        } else {
            view.showResult(String.valueOf(arg));
        }
    }

}
