package App;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Conversion {
    public Conversion() {}

    public Polynomial conv(String text) {
        double coef, power;
        String fMonomial;
        fMonomial = "([+-]?[\\d\\.]*[a-zA-Z]?\\^?\\d*)";
        String fMonomialP;
        fMonomialP = "([+-]?[\\d\\.]*)([a-zA-Z]?)\\^?(\\d*)";
        Pattern pat1 = Pattern.compile(fMonomial);
        Matcher mat1 = pat1.matcher(text);
        Polynomial x = new Polynomial();
        while (!mat1.hitEnd()) {
            coef = power = 0;
            mat1.find();
            Pattern pat2 = Pattern.compile(fMonomialP);
            Matcher mat2 = pat2.matcher(mat1.group());
            if (mat2.find()) {
                coef = Double.valueOf(mat2.group(1));
                power = Double.valueOf(mat2.group(3));
            }
            Monomial y = new Monomial(coef, power);
            x.polynom.add(y);
        }
        return x;
    }
}
