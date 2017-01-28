package lib;

// Edition class for all editions
public abstract class Edition implements Comparable<Edition> {

    private String name;
    private int pageQuantity;

    public Edition(String name, int pageQuantity) {
        this.name = name;
        this.pageQuantity = pageQuantity;
    }

    // every class need to realize this method for printing own fields
    public abstract void printInformation();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageQuantity() {
        return pageQuantity;
    }

    public void setPageQuantity(int pageQuantity) {
        this.pageQuantity = pageQuantity;
    }

    // part of realisation comparable
    public int compareTo(Edition edition) {
        int result = this.getClass().getName().compareTo(edition.getClass().getName());
        if (result != 0){
            return result;
        }

        result = this.getName().compareTo(edition.getName());
        if (result != 0){
            return result;
        }

        result = this.getPageQuantity() - (edition.getPageQuantity());
        if (result != 0){
            return result;
        }
        return 0;
    }
}
