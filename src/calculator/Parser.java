
package calculator;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Анализ полученных токенов
 * @author Яна
 */
public class Parser {
    private Number a;
    private Number b;
    private Operation operator;
    private String result;

    public Parser(ArrayList<Token> tokens){
            checkTokens(tokens);
    }
    
    protected String getResult() {return result;}
/**
 * Проверка количества токенов
 * @param tokens 
 */
    protected void checkTokens (ArrayList<Token> tokens){
        if (tokens.size() != 3) 
            createException("Неверное количество элементов. Введите выражение вида *Переменная* *операция* *Переменная*");
        else checkNumbers(tokens);

    }
    /**
     * Проверка на смешанность римских и арабских чисел, соответствие форме *переменная**операция**переменная*
     * @param tokens 
     */
    private void checkNumbers(ArrayList<Token> tokens) {
        if ((tokens.get(0).getType().equals("DecimalNumber") || tokens.get(0).getType().equals("RomanNumber")) && (tokens.get(2).getType().equals("DecimalNumber") || tokens.get(2).getType().equals("RomanNumber"))
                && tokens.get(1).getType().equals("Operation")) {
            if ((tokens.get(0).getType().equals("DecimalNumber") && tokens.get(2).getType().equals("RomanNumber"))
                    || (tokens.get(0).getType().equals("RomanNumber") && tokens.get(2).getType().equals("DecimalNumber"))) createException("Нельзя одновременно использовать арабские и римсике цифры");
            else setExpression(tokens);
        } else createException("Неверный формат ввода.*Переменная* *операция* *Переменная*");
    }
       /**
        * Преобразование токенов в числа и в оператор, вычисление
        * @param tokens 
        */ 
    private void setExpression(ArrayList<Token> tokens) {
        a = new Number(tokens.get(0).getValue(), tokens.get(0).getType());
        b = new Number(tokens.get(2).getValue(), tokens.get(2).getType());
        operator = new Operation(tokens.get(1).getValue());
        if (a.toInt() != 0 && b.toInt() != 0) {
            Calculation calculator = new Calculation();
            result = calculator.calculate(a, b, operator);
            if(result != null)
            showResult();
        }
    }
/**
 * Формирование исключений для Parser 
 * @param message 
 */
    private void createException(String message) {
        try {
            throw new ParserException(message);
        } catch (ParserException ex) {
            Logger.getLogger(Lexer.class.getName()).log(Level.SEVERE, message, ex);
        }
    }
/**
 * Вывод результата вычислений
 */
    private void showResult() {
            System.out.println("Result: ");
            System.out.println(result);   
    }
}

/**
 * Класс исключений для Parser при анализе токенов
 * @author Яна
 */
class ParserException extends Exception{
    public ParserException(String message){
        super(message);
    }
}
