package lib;

// middle part of editions
public abstract class Papers extends Edition {
    private int serialNumber;

    public Papers(String name, int pageQuantity, int serialNumber) {
        super(name, pageQuantity);
        this.serialNumber = serialNumber;
    }

    @Override
    public int compareTo(Edition edition) {
        int result = super.compareTo(edition);
        if (result != 0) {
            return result;
        }
        if (edition instanceof Papers) {
            Papers papers = (Papers) edition;
            result = getSerialNumber() - (papers.getSerialNumber());
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }
}
