package lib.editions;

import lib.Edition;
import lib.Papers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Newspaper extends Papers {
    private Date date;

    public Newspaper(String name, int pageQuantity, int serialNumber, Date date) {
        super(name, pageQuantity, serialNumber);
        this.date = date;
    }

    @Override
    public void printInformation() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        System.out.println(String.format("%s {name='%s', pageQuantity='%d', serialNumber='%d', date='%s'}",
                getClass().getSimpleName(), getName(), getPageQuantity(), getSerialNumber(), sdf.format(getDate())));
    }

    public int compareTo(Edition o) {
        int result = super.compareTo(o);
        if (result != 0){
            return result;
        }
        if (o instanceof Newspaper){
            SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
            Newspaper newspaper = (Newspaper) o;
            result = sdf.format(getDate()).compareTo(sdf.format(newspaper.date));
            if (result != 0){
                return result;
            }
        }
        return 0;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
