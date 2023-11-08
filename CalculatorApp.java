import java.util.*;
class myExpection extends InputMismatchException{
    String s;
    myExpection(String s){
        this.s = s;
    }
}
interface CalculatorBlueprint{
    double results(int a, int b, int op);
    int addition(int a, int b);
    int subtraction(int a, int b);
    double division(double a, double b);
    int multiplication(int a, int b);
}
class CalculatorApp implements CalculatorBlueprint{
    public double results(int a, int b, int op){
        switch (op){
            case 1: return addition(a, b);
            case 2: return subtraction(a, b);
            case 3: return multiplication(a, b);
            case 4: return division(a, b);
        }
        return 0;
    }
    public int addition(int a, int b){
        return a + b;
    }
    public int subtraction(int a, int b){
        return a - b;
    }
    public double division(double a, double b) throws myExpection{
        if (b == 0){
            System.out.println("Please add a number greater than 0 for the second value: ");
            return 0.0;
        }
        else {
            return a / b;
        }
    }
    public int multiplication(int a, int b){
        return a * b;
    }
}
     class Main {
    public static void main(String[] args) {
        System.out.println("Hello hi!!");
        System.out.println("Please enter your values");
        myExpection me = new myExpection("Input Mismatch, try again. ");
        CalculatorApp calc = new CalculatorApp();
        Scanner scan = new Scanner(System.in);
        boolean bool = false;
        double results = 0;
        while (!bool) {
            try {
                System.out.print("Please enter First Value: ");
                int firstValue = scan.nextInt();
                System.out.print("Please enter Second Value: ");
                int secondValue = scan.nextInt();
                System.out.println("Choose an operator to use \n1. Add \n2. Subtract \n3. Multiply \n4. Divide");
                int operator = scan.nextInt();
                if (operator == 1 || operator == 2 || operator == 3 || operator == 4){
                    results = calc.results(firstValue, secondValue, operator);
                }
                if (results % 1 == 0) {
                    System.out.println("The result is: " + (int) results);
                } else {
                    System.out.println("The result is: " + results);
                }
                bool = true;
            }
            catch (Exception e) {
                System.out.println(me.s);
                scan.next();
            }
        }
    }
}