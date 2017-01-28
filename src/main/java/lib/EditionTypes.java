package lib;

// with type of tags for parsing xml database
public enum EditionTypes {
    Book(new String[]{"name", "pageQuantity", "author", "publisher", "year"}),
    Encyclopedia(new String[]{"name", "pageQuantity", "tomNumber", "year"}),
    Magazine(new String[]{"name", "pageQuantity", "serialNumber", "category"}),
    Newspaper(new String[]{"name", "pageQuantity", "serialNumber", "date"});

    private String[] fields;

    private EditionTypes(String[] fields) {
        this.fields = fields;
    }

    public String[] getFields() {
        return fields;
    }
}
