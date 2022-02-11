package com.examen.interciclo.service;


import com.examen.interciclo.dto.ProductoRequest;
import com.examen.interciclo.dto.ProductoResponse;
import com.examen.interciclo.models.Producto;
import com.examen.interciclo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;


    public boolean guardarProducto(ProductoRequest productoRequest){
        Producto producto = new Producto();
        producto.setDescripcion(productoRequest.getDescripcion());
        producto.setPrecio(productoRequest.getPrecio());
        producto.setCantidad(productoRequest.getCantidad());
        if(productoRequest.getCantidad()*productoRequest.getPrecio()>50){
            producto.setTotal(productoRequest.getCantidad()*productoRequest.getPrecio());
        }else{
            producto.setTotal((productoRequest.getCantidad()*productoRequest.getPrecio())
                    -((productoRequest.getCantidad()*productoRequest.getPrecio())*0.10)
                    +((productoRequest.getCantidad()*productoRequest.getPrecio())*0.12));
        }

        try {
            System.out.println(producto);
            productoRepository.save(producto);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean actualizarProducto(ProductoRequest productoRequest){
        Producto producto = new Producto();
        producto.setCodigo(productoRequest.getCodigo());
        producto.setDescripcion(productoRequest.getDescripcion());
        producto.setPrecio(productoRequest.getPrecio());
        producto.setCantidad(productoRequest.getCantidad());
        if(productoRequest.getCantidad()*productoRequest.getPrecio()>50){
            producto.setTotal(productoRequest.getCantidad()*productoRequest.getPrecio());
        }else{
            producto.setTotal((productoRequest.getCantidad()*productoRequest.getPrecio())
                    -((productoRequest.getCantidad()*productoRequest.getPrecio())*0.10)
                    +((productoRequest.getCantidad()*productoRequest.getPrecio())*0.12));
        }
        try {
            productoRepository.save(producto);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public List<ProductoResponse> verProductos(){
        List<ProductoResponse> productoResponseList = new ArrayList<>();
        productoRepository.findAll().forEach(producto1 -> {
            ProductoResponse productoResponse = new ProductoResponse();
            productoResponse.setCodigo(producto1.getCodigo());
            productoResponse.setDescripcion(producto1.getDescripcion());
            productoResponse.setPrecio(producto1.getPrecio());
            productoResponse.setCantidad(producto1.getCantidad());
            productoResponse.setTotal(producto1.getTotal());
            productoResponseList.add(productoResponse);
        });
        return productoResponseList;
    }
    public ProductoResponse verProductobyId(Long id){
        if (productoRepository.existsById(id)){
            ProductoResponse productoResponse = new ProductoResponse();
            Producto producto1 = productoRepository.getById(id);
            productoResponse.setCodigo(producto1.getCodigo());
            productoResponse.setDescripcion(producto1.getDescripcion());
            productoResponse.setPrecio(producto1.getPrecio());
            productoResponse.setCantidad(producto1.getCantidad());
            productoResponse.setTotal(producto1.getTotal());
            return productoResponse;
        }
        return null;
    }
    public boolean eliminarProductobyId(Long id){
        if (productoRepository.existsById(id)){
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
