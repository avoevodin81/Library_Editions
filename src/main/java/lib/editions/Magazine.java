package lib.editions;

import lib.Edition;
import lib.Papers;

public class Magazine extends Papers {
    private String category;

    public Magazine(String name, int pageQuantity, int serialNumber, String category) {
        super(name, pageQuantity, serialNumber);
        this.category = category;
    }

    @Override
    public void printInformation() {
        System.out.println(String.format("%s {name='%s', pageQuantity='%d' serialNumber='%d', category='%s'}",
                getClass().getSimpleName(), getName(), getPageQuantity(), getSerialNumber(), getCategory()));
    }

    public int compareTo(Edition o) {
        int result = super.compareTo(o);
        if (result != 0){
            return result;
        }
        if (o instanceof Magazine){
            Magazine magazine = (Magazine) o;
            result = getCategory().compareTo(magazine.getCategory());
            if (result != 0){
                return result;
            }
        }
        return 0;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}


