package com.examen.interciclo.controller;


import com.examen.interciclo.dto.ProductoRequest;
import com.examen.interciclo.dto.ProductoResponse;
import com.examen.interciclo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<Boolean> crearUsuario(@RequestBody ProductoRequest productoRequest){
        if (productoService.guardarProducto(productoRequest)){
            return new ResponseEntity(true, HttpStatus.CREATED);
        }
        return new ResponseEntity(false,HttpStatus.NOT_FOUND);
    }
    @PutMapping
    public ResponseEntity<Boolean> actualizarUsuario(@RequestBody ProductoRequest productoRequest){
        if (productoService.actualizarProducto(productoRequest)){
            return new ResponseEntity(true,HttpStatus.CREATED);
        }
        return new ResponseEntity(false,HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> aliminarUsuariobyId(@PathVariable Long id){
        if (productoService.eliminarProductobyId(id)){
            return new ResponseEntity(true,HttpStatus.CREATED);
        }
        return new ResponseEntity(false,HttpStatus.NOT_FOUND);
    }
    @GetMapping
    public ResponseEntity<List<ProductoResponse>> verUsuario(){
        List<ProductoResponse> productoResponses = productoService.verProductos();
        if(productoResponses!=null){
            return new ResponseEntity<List<ProductoResponse>>(productoResponses,HttpStatus.OK);
        }else{
            return new ResponseEntity<List<ProductoResponse>>(productoResponses,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<ProductoResponse> verUsuarioById(@PathVariable Long id){
        ProductoResponse productoResponses = productoService.verProductobyId(id);
        if(productoResponses!=null){
            return new ResponseEntity<ProductoResponse>(productoResponses,HttpStatus.OK);
        }else{
            return new ResponseEntity<ProductoResponse>(productoResponses,HttpStatus.NOT_FOUND);
        }
    }
}
