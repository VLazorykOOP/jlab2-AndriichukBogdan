import java.util.Scanner;

public class Task2 {
    static class Equation {
        float a;
        float b;
        float c;

        public Equation() {}

        public Equation(float m_a, float m_b, float m_c) {
            a = m_a;
            b = m_b;
            c = m_c;
        }

        int countRoots() {
            float discriminant = (this.b * this.b) - (4 * this.a * this.c);
            if (discriminant == 0) {
                return 1;
            } else if (discriminant > 0) {
                return 2;
            }
            return 0;
        }

        float[] findRoots() {
            int numberOfRoots = this.countRoots();
            if (numberOfRoots == 1) {
                float[] roots = new float[1];
                roots[0] = (-1 * this.b) / (2 * this.a);
                return roots;
            } else if (numberOfRoots == 2) {
                float discriminant = (this.b * this.b) - (4 * this.a * this.c);
                float[] roots = new float[2];
                roots[0] = (float) ((-1 * this.b - Math.sqrt(discriminant)) / (2 * this.a));
                roots[1] = (float) ((-1 * this.b + Math.sqrt(discriminant)) / (2 * this.a));
                return roots;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter coefficient a: ");
        float a = sc.nextFloat();
        System.out.print("Enter coefficient b: ");
        float b = sc.nextFloat();
        System.out.print("Enter coefficient c: ");
        float c = sc.nextFloat();

        Equation equation = new Equation(a, b, c);

        int numberOfRoots = equation.countRoots();
        System.out.println("Number of roots: " + numberOfRoots);

        float[] roots = equation.findRoots();

        if (roots != null) {
            if (roots.length == 1) {
                System.out.println("Root: " + roots[0]);
            } else {
                System.out.println("Root 1: " + roots[0]);
                System.out.println("Root 2: " + roots[1]);
            }
        } else {
            System.out.println("The equation has no real roots.");
        }

        sc.close();
    }
}
