
package calculator;

public class Calculation {

    String res = null;
    /**
     * Определение необходимого действия над полученными переменными
     * @param a
     * @param b
     * @param operation
     * @return 
     */
    protected String calculate(Number a, Number b, Operation operation) {
        if (operation.getAction().equals("PLUS")) {
            add(a, b);
        } else if (operation.getAction().equals("MINUS")) {
            substract(a, b);
        } else if (operation.getAction().equals("MULTIPLE")) {
            multiple(a, b);
        } else if (operation.getAction().equals("DEVIDE")) {
            devide(a, b);
        }
        return res;
    }
/**
 * Сложение полученных переменных
 * @param a
 * @param b 
 */
  private void add(Number a, Number b){
       Number result = new Number(a.toInt() + b.toInt(), a.getType());
       if(result.toInt()!= 0) 
       res = result.toStringForm();
    }
  /**
   * Вычетание полученных переменных
   * @param a
   * @param b 
   */
 private  void substract (Number a, Number  b){
      Number result = new Number(a.toInt() - b.toInt(), a.getType());
      if(result.toInt()!= 0) 
      res = result.toStringForm();
    }
 /**
  * Умножение полученных переменных
  * @param a
  * @param b 
  */
  private  void multiple(Number  a, Number  b){
        Number result = new Number(a.toInt() * b.toInt(), a.getType());
        if(result.toInt()!= 0) 
        res = result.toStringForm();
    }
  /**
   * Деление полученных переменных
   * @param a
   * @param b 
   */
   private void devide (Number a, Number  b){
        Number result = new Number(a.toInt() / b.toInt(), a.getType());  
        if(result.toInt()!= 0) 
        res = result.toStringForm();
    }
}



