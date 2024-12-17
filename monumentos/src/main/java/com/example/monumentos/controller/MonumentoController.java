package com.example.monumentos.controller;

import com.example.monumentos.repo.MonumentoRepository;
import com.example.monumentos.model.Monumento;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monumento")
@RequiredArgsConstructor
@Tag(name = "Monumentos", description = "El controlador encargado de realizar las operaciones de gestión sobre los monumentos de la API")
public class MonumentoController {

    private final MonumentoRepository monumentoRepository;

    @Operation(summary = "Obtiene todos los monumentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                description = "Se han encontrado y devuelto todos los monumentos",
                content = { @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = Monumento.class)),
                    examples = {@ExampleObject(
                            value = """
                                    [
                                        {"id": 1, "codPais": "ES", "nombre": "Giralda", "longitud": 37.3862, "latitud": -5.9926, "descripcion": "Mu bonita", 
                                        "urlImagen": "https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/La_Giralda_August_2012_Seville_Spain.jpg/240px-La_Giralda_August_2012_Seville_Spain.jpg"},
                                        {"id": 2, "codPais": "IT", "nombre": "Torre de Pisa", "longitud": 43.7229, "latitud": 10.3965, "descripcion": "Esta torcida", 
                                        "urlImagen": "https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/The_Leaning_Tower_of_Pisa_SB.jpeg/250px-The_Leaning_Tower_of_Pisa_SB.jpeg"}
                                    ]
                                    """
                    )}
                )}),
            @ApiResponse(responseCode = "404",
                description = "No se ha encontrado ningún monumento",
                content = @Content
            ),
    })
    @GetMapping
    public ResponseEntity<List<Monumento>> getAll(
            @RequestParam(required = false, value = "nombreCiudad", defaultValue = "all") String ciudad,
            @RequestParam(required = false, value = "sort", defaultValue = "desc") String sortDirection
    ) {
        List<Monumento> result = monumentoRepository.orderByName(ciudad, sortDirection);

        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Crea un monumento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "El monumento se ha creado correctamente"
            )
    })
    @PostMapping
    public ResponseEntity<Monumento> add(@RequestBody Monumento monumento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(monumentoRepository.add(monumento));
    }

    @Operation(summary = "Obtiene un monumento específico buscándolo por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha encontrado y devuelto el monumento buscado",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monumento.class)),
                            examples = {@ExampleObject(
                                    value = """
                                    [
                                        {"id": 1, "codPais": "ES", "nombre": "Giralda", "longitud": 37.3862, "latitud": -5.9926, "descripcion": "Mu bonita", 
                                        "urlImagen": "https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/La_Giralda_August_2012_Seville_Spain.jpg/240px-La_Giralda_August_2012_Seville_Spain.jpg"},
                                    ]
                                    """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado el monumento buscado",
                    content = @Content
            ),
    })
    @GetMapping("/{id}")
    public ResponseEntity<Monumento> getById(@PathVariable Long id) {
        return ResponseEntity.of(monumentoRepository.get(id));
    }

    @Operation(summary = "Edita un monumento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han modificado el monumento correctamente",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monumento.class)),
                            examples = {@ExampleObject(

                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado el monumento a editar",
                    content = @Content
            ),
    })
    @PutMapping("/{id}")
    public ResponseEntity<Monumento> edit(@RequestBody Monumento monumento, @PathVariable("id") Long idMonumento) {
        return ResponseEntity.of(monumentoRepository.edit(idMonumento, monumento));
    }

    @Operation(summary = "Borra un monumento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha eliminado el monumento correctamente",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monumento.class)),
                            examples = {@ExampleObject(

                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado el monumento a borrar",
                    content = @Content
            ),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Monumento> delete(@PathVariable Long idMonumento) {
        monumentoRepository.delete(idMonumento);
        return ResponseEntity.noContent().build();
    }









}
