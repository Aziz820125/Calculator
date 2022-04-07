import java.util.Scanner;

public class Calculator {
    private static boolean Arab_number = true;

    public Calculator() {
    }

    private static String[] rs(String input) {
        String[] S1 = input.split(" ");
        if (S1.length != 3) {
            Scanner input_a_value_again = new Scanner(System.in);
            System.out.println("Ошибка. Введите выражение, разделяя каждый символ _пробелом_");
            input = input_a_value_again.nextLine();
            return rs(input);
        } else {
            return S1;
        }
    }

    public static void main(String[] args) {
        Scanner S2 = new Scanner(System.in);
        System.out.print("Введите выражение: ");

        for(String input = S2.nextLine(); !input.isEmpty(); input = S2.nextLine()) {
            String[] S1 = rs(input);
            String operation = S1[1];
            int value1 = 0;
            int value2 = 0;

            try {
                value1 = Integer.parseInt(S1[0]);
                value2 = Integer.parseInt(S1[2]);
            } catch (NumberFormatException var9) {
                Arab_number = false;
                System.out.println("Введены римские цифры");
            }

            Object values;
            if (Arab_number) {
                values = new Arab(value1, value2);
            } else {
                values = new Rimes(S1[0], S1[2]);
            }



            try {
                if (operation.equals("+")) {
                    ((Abstracts_metod)values).sum();
                } else if (operation.equals("-")) {
                    ((Abstracts_metod)values).sub();
                } else if (!operation.equals("/") && !operation.equals(":")) {
                    if (operation.equals("*") || operation.equals("x")) {
                        ((Abstracts_metod)values).mul();
                    }
                } else {
                    ((Abstracts_metod)values).div();
                }
                if (!operation.equals("+")&&!operation.equals("-")&&!operation.equals("/")&& !operation.equals("*"))
                    throw new ArithmeticException();
            }
            catch (ArithmeticException e) {
                System.out.println(" Ошибка! Введите корректную операцию");

            }



            if (Arab_number) {
                System.out.println("Ответ: " + ((Abstracts_metod)values).getResult());
            } else {
                System.out.println("Ответ: " + ((Abstracts_metod)values).getStringResult());
            }

            System.out.println();
            System.out.print("Введите следующее выражение: ");
        }

        System.out.println("Вы вышли из калькулятора");
    }
}
