package lib.editions;

import lib.Books;
import lib.Edition;

import java.util.Date;

public class Encyclopedia extends Books {
    private int tomNumber;

    public Encyclopedia(String name, int pageQuantity, int tomNumber, Date year) {
        super(name, pageQuantity, year);
        this.tomNumber = tomNumber;
    }

    @Override
    public void printInformation() {
        System.out.println(String.format("%s {name='%s', pageQuantity='%d' tomNumber='%d', year='%d'}",
                getClass().getSimpleName(), getName(), getPageQuantity(), getTomNumber(), getYear().getYear()));
    }

    public int compareTo(Edition o) {
        int result = super.compareTo(o);
        if (result != 0){
            return result;
        }
        return 0;
    }

    public int getTomNumber() {
        return tomNumber;
    }

    public void setTomNumber(int tomNumber) {
        this.tomNumber = tomNumber;
    }
}