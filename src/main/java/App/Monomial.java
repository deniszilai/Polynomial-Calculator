package App;

public class Monomial {
    public double coeficient;
    public double power;

    public Monomial () {}

    public Monomial(double coeficient, double power)
    {
        this.coeficient=coeficient;
        this.power=power;
    }

    public double getCoeficient()
    {
        return coeficient;
    }
    public void setCoeficient(double coeficient)
    {
        this.coeficient=coeficient;
    }

    public double getPower()
    {
        return power;
    }
    public void setPower(double power)
    {
        this.power=power;
    }

    public String toString() {
        if (coeficient >= 0)
            return "+" + coeficient + "x^" + (int)power + " ";
        else
            return coeficient + "x^" + (int)power + " ";

    }
}
