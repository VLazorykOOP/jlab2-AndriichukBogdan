import java.util.Scanner;

public class Task1 {
    static Scanner sc = new Scanner(System.in);

     static class Rational {
        public int numerator;
        public int denominator;

        public Rational(int numerator) {
            this.numerator = numerator;
            this.denominator = 1;
        }

        public Rational(int m_numerator, int m_denominator) {
            numerator = m_numerator;
            if (m_denominator == 0) {
                System.out.println("Нуль не можна в знаменник!");
                denominator = 1;
            } else denominator = m_denominator;
        }

        void get_rational() {
            if (denominator == 1) {
                System.out.printf("Fraction: %d\n", numerator);
            } else {
                System.out.printf("Fraction: %d / %d\n", numerator, denominator);
            }
        }

        Rational add(Rational first, Rational second) {
            int t_numerator;
            int t_denominator;
            if (first.denominator == second.denominator) {
                t_numerator = first.numerator + second.numerator;
                t_denominator = first.denominator;
            } else {
                t_numerator = (first.numerator * second.denominator) + (second.numerator * first.denominator);
                t_denominator = first.denominator * second.denominator;
            }
            return new Rational(t_numerator, t_denominator).reduce();
        }

        Rational minus(Rational first, Rational second) {
            int t_numerator;
            int t_denominator;
            if (first.denominator == second.denominator) {
                t_numerator = first.numerator - second.numerator;
                t_denominator = first.denominator;
            } else {
                t_numerator = (first.numerator * second.denominator) - (second.numerator * first.denominator);
                t_denominator = first.denominator * second.denominator;
            }
            return new Rational(t_numerator, t_denominator).reduce();
        }

        Rational multiply(Rational first, Rational second) {
            int t_numerator = first.numerator * second.numerator;
            int t_denominator = first.denominator * second.denominator;
            return new Rational(t_numerator, t_denominator).reduce();
        }

        Rational divide(Rational first, Rational second) {
            int t_numerator = first.numerator * second.denominator;
            int t_denominator = first.denominator * second.numerator;
            return new Rational(t_numerator, t_denominator).reduce();
        }

        boolean more(Rational first, Rational second) {
            return first.numerator * second.denominator > second.numerator * first.denominator;
        }

        boolean less(Rational first, Rational second) {
            return first.numerator * second.denominator < second.numerator * first.denominator;
        }

        boolean equals(Rational first, Rational second) {
            return first.numerator * second.denominator == second.numerator * first.denominator;
        }

        Rational reduce() {
            for (int i = this.numerator; i >= 2; i--) {
                if (this.numerator % i == 0 && this.denominator % i == 0) {
                    this.numerator /= i;
                    this.denominator /= i;
                }
            }
            return this;
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter First fraction numerator: ");
        int f_numerator = sc.nextInt();
        System.out.print("Enter First fraction denominator: ");
        int f_denominator = sc.nextInt();
        System.out.print("Enter Second fraction numerator: ");
        int s_numerator = sc.nextInt();
        System.out.print("Enter Second fraction denominator: ");
        int s_denominator = sc.nextInt();

        Rational first = new Rational(f_numerator, f_denominator);
        Rational second = new Rational(s_numerator, s_denominator);

        Rational res1 = first.add(first, second);
        Rational res2 = first.minus(first, second);
        Rational res3 = first.multiply(first, second);
        Rational res4 = first.divide(first, second);

        res1.get_rational();
        res2.get_rational();
        res3.get_rational();
        res4.get_rational();

        boolean result1 = first.more(first, second);
        boolean result2 = second.less(first, second);
        boolean result3 = second.equals(second, first);

        System.out.printf("%d / %d > %d / %d : %b\n",first.numerator,first.denominator,second.numerator,second.denominator,result1);
        System.out.printf("%d / %d < %d / %d : %b\n",first.numerator, first.denominator, second.numerator, second.denominator, result2 );
        System.out.printf("%d / %d == %d / %d : %b\n",first.numerator,first.denominator, second.numerator, second.denominator, result3);
    }

}
