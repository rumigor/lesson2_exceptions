package Exceptions;

public class MyArraySizeException extends RuntimeException {
    private int i;


    private int j;

    public MyArraySizeException(String  message, int i, int j) {
        super(message);
        this.i = i;
        this.j = j;
    }

    public MyArraySizeException(String  message, int i) {
        super(message);
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
