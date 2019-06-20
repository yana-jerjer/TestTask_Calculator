
package calculator;

import java.util.Comparator;
/**
 * Класс описания отдельного токена
 * @author Яна
 */
public class Token {
    private String value;
    private String type;
    private int regionStart;

    public Token(String value, String type, int regionStart){
        this.value = value;
        this.type = type;
        this.regionStart = regionStart;
    }

    protected String getValue(){
        return value;
    }
    protected String getType(){
        return type;
    }
    public int getRegionStart(){
        return regionStart;
    }
    /**
     * Сортировка токенов для их отображения в том же порядке, что и во входной строке
     * @param rS
     * @return 
     */
    protected int compareTo(Token rS){
        return regionStart - rS.getRegionStart();
    }
}
