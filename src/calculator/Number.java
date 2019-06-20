
package calculator;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Класс описания отдельного числа
 * @author Яна
 */
public class Number {

  private int definition = 0;
  private String type;
/**
 * Конструктор Numb. Определение значения числа
 * @param numb - значение числа
 * @param numbType - тип числа (римское/арабское)
 */
    public Number(String numb, String numbType){
        if (numbType.equals("RomanNumber")) getRoman(numb);
        else getDecimal(numb);
        type = numbType;
    }
   /**
    * Конструктор Numb. Проверка принадлежности результата вычислений диапазону от 1 до 10
    * @param numb - значение числа
    * @param numbType - тип числа(римское/арабское)
    */ 
    public Number(int numb, String numbType) {
        if (numb < 1 || numb > 10) {
            createException("Резельтат вне диапазона от 1 до 10 включительно. Число: " + numb);
        } else {
            definition = numb;
            type = numbType;
        }
    }
    
   
    protected String getType(){
        return type;
    }
    
    protected void setDefinition(int def){
        this.definition = def;
        
    }
    
    protected void setType(String type){
        this.type = type;

    }
    
/**
 * Проверка числа на принадлежность диапазону от 1 до 10 включительно
 * @param number 
 */
   protected void getDecimal(String number) {
       if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 10)
           createException("Число должно находиться в диапазоне от 1 до 10 включительно. Число: " + number);
       else definition = Integer.parseInt(number);
   }
/**
 * Определение значения римских цифр
 * @param number 
 */
   protected void getRoman(String number){
        switch(number){
            case "I": {definition = 1; break;}
            case "II": {definition = 2; break;}
            case "III": {definition = 3; break;}
            case "IV": {definition = 4; break;}
            case "V": {definition = 5; break;}
            case "VI": {definition = 6; break;}
            case "VII": {definition = 7; break;}
            case "VIII": {definition = 8; break;}
            case "IX": {definition = 9; break;}
            case "X": {definition = 10; break;}
            default : {
                createException("Число должно находиться в диапазоне от I до X включительно.");
                break;
            }
        }    
    }
   /**
    * Преобразование числа к формату Integer
    * @return 
    */
    protected int toInt(){
        return definition;
    }
    /**
     * Преобразование значения к римской или арабской форме
     * @return 
     */
    protected String toStringForm() {
        if (type.equals("DecimalNumber")) {
            return Integer.toString(definition);
        } else {
            switch (definition) {
                case 1:
                    return "I";
                case 2:
                    return "II";
                case 3:
                    return "III";
                case 4:
                    return "IV";
                case 5:
                    return "V";
                case 6:
                    return "VI";
                case 7:
                    return "VII";
                case 8:
                    return "VIII";
                case 9:
                    return "IX";
                case 10:
                    return "X";
                default: 
                    return "NotDefined";
            }
        }
    }
/**
 * Формирование исключения
 * @param message 
 */
        private void createException(String message) {
        try {
            throw new ParserException(message);
        } catch (ParserException ex) {
            Logger.getLogger(Lexer.class.getName()).log(Level.SEVERE, message, ex);
        }
    }
}
/**
 * Класс исключений для Number
 * @author Яна
 */
class NumberException extends Exception {

    public NumberException(String message) {
        super(message);
    }

}
