
package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Разбиение полученной строки на токены
 * @author Яна
 */
public class Lexer {

    private Pattern numberDec = Pattern.compile("[0-9]+");
    private Pattern numberRom = Pattern.compile("(I|V|X)+");
    private Pattern operation = Pattern.compile("\\+|-|\\/|\\*");
    private Pattern exception = Pattern.compile("[^-|I|X|V|0-9|+|*|/]");

    public Lexer(String expression) {
        Matcher matcherException = exception.matcher(expression);
        if (matcherException.find()) {
            try {
                throw new LexerException("Wrong sign: \"" + matcherException.group() + "\"");
            } catch (LexerException ex) {
                Logger.getLogger(Lexer.class.getName()).log(Level.SEVERE, "Wrong sign: \"" + matcherException.group() + "\"", ex);
            }
        } else {
            Matcher matcherNumbersDec = numberDec.matcher(expression);
            Matcher matcherNumbersRom = numberRom.matcher(expression);
            Matcher matcherOperation = operation.matcher(expression);
            ArrayList<Token> tokens = new ArrayList<Token>();
            //определение токенов - арабских чисел
            while (matcherNumbersDec.find()) {
                for (int i = 0; i <= matcherNumbersDec.groupCount(); i++) {
                    Token token = new Token(matcherNumbersDec.group(i), "DecimalNumber", matcherNumbersDec.start(i));
                    tokens.add(token);
                }
            }
            //определение токенов - римских чисел
            while (matcherNumbersRom.find()) {
                for (int i = 0; i < matcherNumbersRom.groupCount(); i++) {
                    Token token = new Token(matcherNumbersRom.group(i), "RomanNumber", matcherNumbersRom.start(i));
                    tokens.add(token);
                }
            }
            //определение токенов - операторов
            while (matcherOperation.find()) {
                for (int i = 0; i <= matcherOperation.groupCount(); i++) {
                    Token token = new Token(matcherOperation.group(i), "Operation", matcherOperation.start(i));
                    tokens.add(token);
                }
            }
            //Сортировка токено для соответствия входящей строке
            Collections.sort(tokens, (o1, o2) -> o1.compareTo(o2));
            Parser parser = new Parser(tokens);
        }
    }
}
/**
 * Класс исключений для Lexer
 * @author Яна
 */
class LexerException extends Exception {

    public LexerException(String wrong_sign) {
        super(wrong_sign);
    }
}
