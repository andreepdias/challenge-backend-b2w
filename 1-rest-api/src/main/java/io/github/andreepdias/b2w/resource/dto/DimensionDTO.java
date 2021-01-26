package io.github.andreepdias.b2w.resource.dto;

public class DimensionDTO {

    private Double weight;
    private Double height;
    private Double width;
    private Double length;

    public DimensionDTO() {
    }

    public DimensionDTO(Double weight, Double height, Double width, Double length) {
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    public Double getLength() {
        return length;
    }
}
