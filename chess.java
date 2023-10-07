import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class chess {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите позиции k, l для первой фигуры: ");
        String k1 = reader.readLine();
        int k = Integer.parseInt(k1);
        String l1 = reader.readLine();
        int l = Integer.parseInt(l1);
        System.out.println("Введите позиции m, n для второй фигуры: ");
        String m1 = reader.readLine();
        int m = Integer.parseInt(m1);
        String n1 = reader.readLine();
        int n = Integer.parseInt(n1);
        canContinue(k, l, m, n); // вызов функции
        isSameColor(k, l, m, n); // вызов функции
        System.out.println("Выберите фигуру (ферзь, ладья, слон или конь), расположенную на k, l.");
        System.out.println("Для этого напишите \"Ферзь\", \"Ладья\", \"Слон\", \"Конь\" ниже: ");
        String chessFigure = reader.readLine();
        isDanger(k, l, m, n, chessFigure); // вызов функции
        System.out.println("Выберите фигуру (ферзь, ладья или слон), расположенную на k, l.");
        System.out.println("Для этого напишите \"Ферзь\", \"Ладья\", \"Слон\" ниже: ");
        String chessFigure1 = reader.readLine(); // вызов функции
        getOnChessField(k, l, m, n, chessFigure1); // вызов функции
    }

    public static void isSameColor(int k, int l, int m, int n) { // проверяем один ли цвет имеют 2 разных поля доски
        if (((k % 2 == 0 && l % 2 != 0) && (m % 2 == 0 && n % 2 != 0)) || ((k % 2 != 0 && l % 2 == 0) && (m % 2 != 0 && n % 2 == 0)) || ((k % 2 == 0 && l % 2 != 0) && (m % 2 != 0 && n % 2 == 0)) || ((k % 2 != 0 && l % 2 == 0) && (m % 2 == 0 && n % 2 != 0))) {
            System.out.println("Поля одного цвета (черные)");
        } else if (((k % 2 == 0 && l % 2 == 0) && (m % 2 == 0 && n % 2 == 0)) || ((k % 2 != 0 && l % 2 != 0) && (m % 2 != 0 && n % 2 != 0)) || ((k % 2 == 0 && l % 2 == 0) && (m % 2 != 0 && n % 2 != 0)) || ((k % 2 != 0 && l % 2 != 0) && (m % 2 == 0 && n % 2 == 0))) {
            System.out.println("Поля одного цвета (белые)");
        } else System.out.println("Поля разных цветов");
    }

    public static void isDanger(int k, int l, int m, int n, String chessFigure) { // функция, проверяющая, угрожает ли ферзь, ладья, слон или конь полю m, n
        if (chessFigure.equals("Ферзь")) {
            if ((k == m || l == n) || ((k - m) * (k - m) == (l - n) * (l - n))) {
                System.out.println("Ферзь на позиции k=" + k + ", l=" + l + ", угрожает полю m=" + m + ", n=" + n);
            } else
                System.out.println("Ферзь на позиции k=" + k + ", l=" + l + ", не угрожает полю m=" + m + ", n=" + n);
        } else if (chessFigure.equals("Ладья")) {
            if (k == m || l == n) {
                System.out.println("Ладья на позиции k=" + k + ", l=" + l + ", угрожает полю m=" + m + ", n=" + n);
            } else
                System.out.println("Ладья на позиции k=" + k + ", l=" + l + ", не угрожает полю m=" + m + ", n=" + n);
        } else if (chessFigure.equals("Слон")) {
            if ((k - m) * (k - m) == (l - n) * (l - n)) {
                System.out.println("Слон на позиции k=" + k + ", l=" + l + ", угрожает полю m=" + m + ", n=" + n);
            } else System.out.println("Слон на позиции k=" + k + ", l=" + l + ", не угрожает полю m=" + m + ", n=" + n);
        } else if (chessFigure.equals("Конь")) {
            if (((k - m) * (k - m) + (l - n) * (l - n)) == 5) {
                System.out.println("Конь на позиции k=" + k + ", l=" + l + ", угрожает полю m=" + m + ", n=" + n);
            } else System.out.println("Конь на позиции k=" + k + ", l=" + l + ", не угрожает полю m=" + m + ", n=" + n);
        }
    }

    public static void canContinue(int k, int l, int m, int n) { // функция, проверяющая правильность вводимых координат шахматной доски
        if (k < 1 || k > 8 || l < 1 || l > 8 || m < 1 || m > 8 || n < 1 || n > 8) {
            System.out.println("Номер какой-то клетки превосходит 8 или меньше 1, перезапустите программу и введите верные данные.");
            System.exit(0);
        }
    }

    public static void getOnChessField(int k, int l, int m, int n, String chessFigure) { //функция, проверяющая можно ли попасть на поле m, n за 2 хода, если нельзя за 1
        if (chessFigure.equals("Ферзь")) {
            if ((k == m || l == n) || ((k - m) * (k - m) == (l - n) * (l - n))) {
                System.out.println("Ферзь на позиции k=" + k + ", l=" + l + ", может попасть на поле m=" + m + ", n=" + n + " одним ходом");
            } else {
                k = m;
                System.out.println("За 1 ход попасть нельзя, можно за 2, поле, на которое приведет первый ход: " + k + ", " + l);
            }
        } else if (chessFigure.equals("Ладья")) {
            if (k == m || l == n) {
                System.out.println("Ладья на позиции k=" + k + ", l=" + l + ", может попасть на поле m=" + m + ", n=" + n + " одним ходом");
            } else {
                k = m;
                System.out.println("За 1 ход попасть нельзя, можно за 2, поле, на которое приведет первый ход: " + k + ", " + l);
            }
        } else if (chessFigure.equals("Слон")) {
            if ((k - m) * (k - m) == (l - n) * (l - n)) {
                System.out.println("Слон на позиции k=" + k + ", l=" + l + ", может попасть на поле m=" + m + ", n=" + n + " одним ходом");
            } else if (((k % 2 == 0 && l % 2 != 0) && (m % 2 == 0 && n % 2 != 0)) || ((k % 2 != 0 && l % 2 == 0) && (m % 2 != 0 && n % 2 == 0)) || ((k % 2 == 0 && l % 2 != 0) && (m % 2 != 0 && n % 2 == 0)) || ((k % 2 != 0 && l % 2 == 0) && (m % 2 == 0 && n % 2 != 0)) || ((k % 2 == 0 && l % 2 == 0) && (m % 2 == 0 && n % 2 == 0)) || ((k % 2 != 0 && l % 2 != 0) && (m % 2 != 0 && n % 2 != 0)) || ((k % 2 == 0 && l % 2 == 0) && (m % 2 != 0 && n % 2 != 0)) || ((k % 2 != 0 && l % 2 != 0) && (m % 2 == 0 && n % 2 == 0))) {
                System.out.println("За 2 хода попасть на поле m=" + m + ", n=" + n + "невозможно");
            }
            else System.out.println("Слон может попасть за 2 хода на поле m=" + m + ", n=" + n);
        }
    }
}