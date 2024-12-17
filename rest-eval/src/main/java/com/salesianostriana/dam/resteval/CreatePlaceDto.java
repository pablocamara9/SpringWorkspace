package com.salesianostriana.dam.resteval;

public record CreatePlaceDto(
        String name,
        String address,
        String coords,
        String description,
        String image
) {

    /*public static Place toPlace(CreatePlaceDto dto) {
        return Place.builder()
                .name(dto.name)
                .address(dto.address)
                .coords(dto.coords)
                .desc(dto.description)
                .image(dto.image)
                .build();
    }*/

    public Place toPlace(CreatePlaceDto dto) {
        return Place.builder()
                .name(this.name)
                .address(this.address)
                .coords(this.coords)
                .desc(this.description)
                .image(this.image)
                .build();
    }
}
