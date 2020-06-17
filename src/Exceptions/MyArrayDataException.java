package Exceptions;

public class MyArrayDataException extends NumberFormatException {


    private int i;
    private int j = - 1;

    public MyArrayDataException(String s, int i, int j) {
        super(s);
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }


}
