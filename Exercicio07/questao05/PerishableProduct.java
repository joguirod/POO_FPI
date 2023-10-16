package Exercicio07.questao05;

import java.util.Date;
public class PerishableProduct extends Product {
    private Date _expirationDate;

    public PerishableProduct(Date _expirationDate) {
        this._expirationDate = _expirationDate;
    }

    public boolean notExpired(Date currentDate){
        return currentDate.before(_expirationDate);
    }

    public void replace(int replacementQty, Date currentDate){
        if (notExpired(currentDate)){
            super.replace(replacementQty);
        }
    }

    public void reduce(int reduceQty, Date currentDate){
        if (notExpired(currentDate)){
            super.reduce(reduceQty);
        }
    }

    public Date getExpirationDate() {
        return _expirationDate;
    }
}
