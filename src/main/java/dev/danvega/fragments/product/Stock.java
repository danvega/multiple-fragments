package dev.danvega.fragments.product;

public enum Stock {

    IN_STOCK("In Stock"),
    ONE_MONTH("Ships in 3–4 weeks");

    public final String label;

    Stock(String label) {
        this.label = label;
    }

}
