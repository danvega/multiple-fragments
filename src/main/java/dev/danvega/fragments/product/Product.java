package dev.danvega.fragments.product;

public record Product(
        Integer id,
        String title,
        String color,
        Size size,
        Integer price,
        Stock stock,
        String img,
        String alt
) {
}
