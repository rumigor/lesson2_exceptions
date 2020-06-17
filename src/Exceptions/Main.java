package Exceptions;

public class Main {

    public static void main(String[] args) {
        String[][] numbers = {
            {"1", "3", "44", "55"},
            {"2", "22", "3", "45"},
            {"2", "3", "0", "-20"},
            {"22", "-23", "33", "3"}
        };

        String[][] wrongSize = {
                {"1", "3", "44", "55"},
                {"2", "22", "3"},
                {"2", "3", "0", "-20"},
                {"22", "-23", "33", "3"}
        };

        String[][] wrongFormat = {
                {"1", "3", "44", "55"},
                {"2", "Second", "3", "5"},
                {"2", "3", "0", "-20"},
                {"22", "-23", "33", "3"}
        };

        try {
            System.out.println(sumArray(numbers));
//            System.out.println(sumArray(wrongSize));
            System.out.println(sumArray(wrongFormat));
        }
        catch (MyArraySizeException e) {
            e.printStackTrace();
            if (e.getJ() == -1) {
                System.err.println("Число строк в массиве: " + e.getI());
            }
            else {System.err.println("В строке " + e.getI() + ": " + e.getJ() + " элементов");}
        }
        catch (MyArrayDataException e){
            e.printStackTrace();
            System.err.println("Ошибка в ячейке [" + e.getI()+"]["+e.getJ()+"]");
        }
    }

    public static int sumArray (String [][] array) {
        if (array.length != 4)
            throw new MyArraySizeException("Число строк в массиве не равно 4", array.length);
        for (int i = 0; i <array.length; i++) {
            if (array[i].length != 4) throw new MyArraySizeException("В строке должно быть 4 элемента", i, array.length);
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка в формате числа", i, j);
            }
            }
        }
        return sum;
    }
}
