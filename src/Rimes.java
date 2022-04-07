public class Rimes extends Abstracts_metod {

    private String rimes1;
    private String rimes2;
    private int rimes1_int;
    private int rimes2_int;
    private int result_int;
    private String sign = " ";
    private String result_rimes;
    private final String[] rimes9 = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    Rimes(String value1, String value2) {
        this.rimes1 = value1;
        this.rimes2 = value2;
        this.rimes1_int = convert_to_int(rimes1);
        this.rimes2_int = convert_to_int(rimes2);
    }
    private  String convert_to_rimes(int n, int ostatok) {
        ostatok = n % 10;
        if (ostatok != 0) {
            try {
                return convert_to_rimes(n - ostatok, 0) + rimes9[ostatok - 1];
            } catch (ArrayIndexOutOfBoundsException e) {

                sign = "-";
                return " Ошибка. Не может быть отрицательного римского числа.";// convert_to_rimes(n - ostatok, 0) + rimes9[(ostatok + 1) * -1];
            }
        }
        //отрицательное римское число
        if (n > 0) {

            n = n - 10;
            return   convert_to_rimes(n, 0) + "X";
        }
        else if (n < 0) {

            n = n + 10;
            return convert_to_rimes(n,0) + "X";
        } else {

            return  sign;
        }
    }


    @Override
    public void sum() {

        result_int = rimes1_int + rimes2_int;
        result_rimes = convert_to_rimes(result_int, result_int);

    }




    @Override
    public void sub() {
        result_int = rimes1_int - rimes2_int;
        result_rimes= convert_to_rimes(result_int, result_int);
    }

    @Override
    public void div() {
        try {
            result_int = rimes1_int / rimes2_int;
            result_rimes = convert_to_rimes(result_int, result_int);
        } catch (ArithmeticException e) {
            System.out.print("Ошибка. Вероятно введены и арабские и римские одновременно. ");
            return;
        }

    }

    @Override
    public void mul() {
        result_int = rimes1_int * rimes2_int;
        result_rimes = convert_to_rimes(result_int, result_int);
    }

    @Override
    public int getResult() {
        return result_int;
    }
    public String getStringResult() {
        return result_rimes;
    }

    private int convert_to_int(String rimes_val){
        char[] value_char = rimes_val.toCharArray();
        int[] values_int = new int[value_char.length];
        for (int i = 0; i < value_char.length; i++) {
            switch (value_char[i]) {
                case 'I':
                    values_int[i] = 1;
                    break;
                case 'V':
                    values_int[i] = 5;
                    break;
                case 'X':
                    values_int[i] = 10;
                    break;

                default:
                    System.out.println("неверный символ. Проверьте правильность ввода римских цифр");
                    break;
            }
        }
        int result = values_int[0];
        for (int i = 0; i < values_int.length && values_int.length > i + 1; i++) {
            if (values_int[i] >= values_int[i+1]) {
                result += values_int[i+1];
            } else if (values_int[i] < values_int[i+1]) {
                result = result + values_int[i+1] - 2;
            }
        }
        return result;
    }

    public String getRimes_1() {
        return rimes1;
    }

    public String getRimes_2() {
        return rimes2;
    }

    public void setRimes1(String rimes_val1) {
        this.rimes1 = rimes_val1;
    }

    public void setRimes2(String rimes_val2) {
        this.rimes2 = rimes_val2;
    }

    public int getRimes1_int() {
        return rimes1_int;
    }

    public int getRimes2_int() {
        return rimes2_int;
    }

    public void setRimes1_int(int rimes1_int) {
        this.rimes1_int = rimes1_int;
    }

    public void setRimes2_int(int rimes2_int) {
        this.rimes2_int = rimes2_int;
    }

}

