package App;
import java.util.ArrayList;
import java.util.List;

public class Polynomial {
    List <Monomial> polynom= new ArrayList<Monomial>();

    public Polynomial () { }

    public Polynomial addition(Polynomial p) {
        Polynomial finish = new Polynomial();
        int p1_size = this.polynom.size();
        int p2_size = p.polynom.size();
        int i = 0, j = 0;
        while (i < p1_size && j < p2_size) {
            Monomial t1 = new Monomial(0, 0);
            Monomial t2 = new Monomial(0, 0);
            Monomial aux = new Monomial(0, 0);
            t1 = this.polynom.get(i);
            t2 = p.polynom.get(j);
            if (t1.getPower() > t2.getPower()) {
                finish.polynom.add(t1);
                i++;
            }
            else {
                if (t1.getPower() < t2.getPower()) {
                    finish.polynom.add(t2);
                    j++;
                }
                else {
                    aux.setCoeficient(t1.coeficient + t2.coeficient);
                    aux.setPower(t1.power);
                    finish.polynom.add(aux);
                    i++;
                    j++;
                }
            }
        }
        while (i < p1_size) {
            Monomial t1 = new Monomial(0, 0);
            t1 = this.polynom.get(i);
            finish.polynom.add(t1);
            i++;
        }
        while (j < p2_size) {
            Monomial t2 = new Monomial(0, 0);
            t2 = p.polynom.get(j);
            finish.polynom.add(t2);
            j++;
        }
        return finish;
    }

    public void ChangeSign(){
        for(Monomial m: this.polynom){
            m.coeficient = m.coeficient*(-1);
        }
    }

    public Polynomial dif(Polynomial p) {
        p.ChangeSign();
        return this.addition(p);
    }

    public Polynomial multiplication(Polynomial p) {
        Polynomial polynom2 = new Polynomial();

        for (Monomial k: this.polynom)
        {
            Polynomial polynom1 = new Polynomial();
            for (Monomial j: p.polynom)
            {
                Monomial aux = new Monomial(0, 0);
                aux.setCoeficient(k.coeficient * j.coeficient);
                aux.setPower(k.power + j.power);
                polynom1.polynom.add(aux);
            }
            polynom2=polynom2.addition(polynom1);
        }
        return polynom2;

    }

    public static Polynomial deriv(Polynomial p){
        Polynomial finish = new Polynomial();
        for(Monomial m: p.polynom){
            Monomial aux = new Monomial((int) (m.getCoeficient() * m.getPower()), (int)(m.getPower()-1));
            finish.polynom.add(aux);
        }
        return finish;
    }

    public static Polynomial integr(Polynomial p) {
        Polynomial finish = new Polynomial();
        for (Monomial m : p.polynom) {
            Monomial aux = new Monomial((m.getCoeficient() * (float) (1.0f / (m.getPower() + 1))), (m.getPower() + 1));
            finish.polynom.add(aux);
        }
        return finish;
    }

    public String toString() {
        String s = "";
        for(int i = 0; i < polynom.size(); i++)
            s = s + polynom.get(i).toString();
        return s;
    }

}
