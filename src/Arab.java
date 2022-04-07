
public class Arab extends Abstracts_metod {

    private int t1;
    private int t2;
    private int result;

    Arab(int r1, int r2) {
        this.t1 = r1;
        this.t2 = r2;
    }

    public void sum() {

        if (t1 >= 0 && t1 <= 10 && t2 >= 0 && t2 <= 10) {
            this.result = t1 + t2;
        }
        else

            System.out.println(" Ошибка.Введите числа от 0 до 10");


    }


    public void sub() {

        if (t1>=t2 ) {
            if( t1 >= 0 && t1 <= 10 && t2 >= 0 && t2 <= 10){
                this.result = t1 - t2;}
            else  System.out.println(" Ошибка.Введите числа от 0 до 10");
        } else
            System.out.println(" Ошибка.Результат не может быть отрицательным");


    }



    public void div() {
        try {  if ((t1 >= 0 && t1 <= 10) &&( t2 >= 0 && t2<=10)) //&& t1==2*t1||t2==2*t2 )
        {this.result = t1 / t2;
        }

        else
            System.out.println(" Введите числа от 0 до 10 или некорректный ввод числа. Числа должны делиться без остатка");
        } catch (ArithmeticException e) {
            System.out.print("Делить на 0 нельзя! ");
            return;
        }


    }

    public void mul() {
        if (t1 >= 0 && t1 <= 10 && t2 >= 0 && t2 <= 10)
        { this.result = t1 * t2;}
        else
            System.out.println(" Введите числа от 0 до 10");
    }

    @Override
    public int getResult() {
        return result;
    }




    @Override
    public String getStringResult() {
        return "" + result;
    }

    public int getT1() {
        return t1;
    }

    public int getT2() {
        return t2;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setT1(int t1) {
        this.t1 = t1;
    }

    public void setT2(int t2) {
        this.t2 = t2;
    }

}