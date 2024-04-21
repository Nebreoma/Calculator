import java.util.function.*;

public class Calculator {

    static Supplier<Calculator> instance = Calculator::new;

    public BinaryOperator<Integer> plus = (x, y) -> x + y;
    public BinaryOperator<Integer> minus = (x, y) -> x - y;
    public BinaryOperator<Integer> multiply = (x, y) -> x * y;
    public BinaryOperator<Integer> devide = (x, y) -> y != 0 ? x / y : 0;
    //Нельзя делить на ноль. В том случае, если 'y' окажется нулем - можем перехватить до операции

    public UnaryOperator<Integer> pow = (x) -> x * x;
    public UnaryOperator<Integer> abs = (x) -> x > 0 ? x : x * -1;

    public Predicate<Integer> isPositive = (x) -> x > 0;

    Consumer<Integer> println = System.out::println;
}