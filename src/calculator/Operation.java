
package calculator;
/**
 * Класс для описания оператора
 * @author Яна
 */
public class Operation {
    String action;

   public Operation(String op) {
       switch(op){
           case "+": {action = "PLUS"; break;}
           case "-": {action = "MINUS"; break;}
           case "/": {action = "DEVIDE"; break;}
           case "*": {action = "MULTIPLE"; break;}
       }
   }
   protected String getAction(){
       return action;
   }
}
