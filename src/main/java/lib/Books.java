package lib;

import java.util.Date;

// middle part of editions
public abstract class Books extends Edition {
    private Date year;

    public Books(String name, int pageQuantity, Date year) {
        super(name, pageQuantity);
        this.year = year;

    }

    @Override
    public int compareTo(Edition edition) {
        int result = super.compareTo(edition);
        if (result != 0) {
            return result;
        }
        if (edition instanceof Books) {
            Books books = (Books) edition;
            result = this.getYear().getYear() - books.getYear().getYear();
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }
}
