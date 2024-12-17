package com.salesianostriana.dam.resteval;

public record GetPlaceDto(
        Long id,
        String name,
        String coords,
        String image
) {
    public static GetPlaceDto of(Place place) {
        return new GetPlaceDto(
                place.getId(),
                place.getName(),
                place.getCoords(),
                place.getImage()
        );
    }

}


