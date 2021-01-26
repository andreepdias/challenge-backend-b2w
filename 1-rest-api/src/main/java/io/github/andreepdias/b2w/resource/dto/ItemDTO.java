package io.github.andreepdias.b2w.resource.dto;

import java.time.LocalDateTime;

public class ItemDTO {

    private String name;
    private Long code;
    private LocalDateTime date;
    private DimensionDTO dimension;

    public ItemDTO() {
    }

    public ItemDTO(String name, Long code, LocalDateTime date, DimensionDTO dimension) {
        this.name = name;
        this.code = code;
        this.date = date;
        this.dimension = dimension;
    }

    public String getName() {
        return name;
    }

    public Long getCode() {
        return code;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public DimensionDTO getDimension() {
        return dimension;
    }
}
