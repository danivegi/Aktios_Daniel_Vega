public class Main {

    public static void main(String[] args) {
        String num = "9";

        for (int i = 0; i < 100; i++) {
            num += "9";
        }
        System.out.println(sumador(num));
    }

    static String sumador(String num) {
        String suma = "";
        int pos = num.length() - 1;
        int dig = -1;
        boolean sumaTotal = false;

        while (pos >= 0) {
            dig = Integer.parseInt(String.valueOf(num.charAt(pos)));
            if (sumaTotal) {
                suma = dig + suma;
                pos--;
                continue;
            }
            if (dig == 9) {
                suma = 0 + suma;
            } else {
                suma = dig + 1 + suma;
                sumaTotal = true;
            }
            if (pos == 0 && dig == 9) {
                suma = 10 + suma;
            }
            pos--;
        }
        return suma;
    }

}
