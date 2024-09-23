public class Task2 {
    static class Equation{
        float a;
        float b;
        float c;
        float x1;
        float x2;

        public Equation() {
        }
        public Equation(float m_a, float m_b, float m_c) {
            a = m_a;
            b = m_b;
            c = m_c;
        }
        int number_of_squares(Equation sen){
            if(((this.b * this.b) - (4 * this.a * this.c)) == 0){
                //System.out.println("The equation has one rational squares.");
                return 1;
            } else if (((this.b * this.b) - (4 * this.a * this.c)) > 0) {
                //System.out.println("The equation has two rational squares.");
                return 2;
            }else //System.out.println("The equation has no rational squares.");
            return 0;
        }

        Equation find_roots(Equation sen){
            if(this.number_of_squares(sen) == 1){
                this.x1 = (-1*(this.b))/(2*this.a);
                this.x2 = (-1*(this.b))/(2*this.a);
                return this;
            } else if (this.number_of_squares(sen) == 2) {
                float discriminate = (this.b*this.b) - (4*this.a*this.c);
                this.x1 = (float) ((-1*(this.b) - Math.sqrt(discriminate))/(2*this.a));
                this.x2 = (float) ((-1*(this.b) + Math.sqrt(discriminate))/(2*this.a));
                return this;
            }else System.out.println("The equation has no rational squares.");
            return null;
        }
    }
    public static void main(String[] args) {}
}
