package com.example.proyectolibreriaingsoftware.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("articuloMapper")
    public ModelMapper articuloMapper() {
        return new ModelMapper();
    }

    @Bean("articuloPCMapper")
    public ModelMapper articuloPCMapper() {
        return new ModelMapper();
    }

    @Bean("asesorMapper")
    public ModelMapper asesorMapper() {
        return new ModelMapper();
    }

    @Bean("autorMapper")
    public ModelMapper autorMapper() {
        return new ModelMapper();
    }

    @Bean("categoriaLCMapper")
    public ModelMapper categoriaLCMapper() {
        return new ModelMapper();
    }

    @Bean("cuentaMapper")
    public ModelMapper cuentaMapper() {
        return new ModelMapper();
    }

    @Bean("editorialMapper")
    public ModelMapper editorialMapper() {
        return new ModelMapper();
    }

    @Bean("empleadoMapper")
    public ModelMapper empleadoMapper() {
        return new ModelMapper();
    }

    @Bean("especialidadMapper")
    public ModelMapper especialidadMapper() {
        return new ModelMapper();
    }

    @Bean("libroMapper")
    public ModelMapper libroMapper() {
        return new ModelMapper();
    }

    @Bean("miembroComiteMapper")
    public ModelMapper miembroComiteMapper() {
        return new ModelMapper();
    }

    @Bean("multaMapper")
    public ModelMapper multaMapper() {
        return new ModelMapper();
    }

    @Bean("palabrasClaveMapper")
    public ModelMapper palabrasClaveMapper() {
        return new ModelMapper();
    }

    @Bean("prestamoMapper")
    public ModelMapper prestamoMapper() {
        return new ModelMapper();
    }

    @Bean("revistaMapper")
    public ModelMapper revistaMapper() {
        return new ModelMapper();
    }

    @Bean("subCategoriaLCMapper")
    public ModelMapper subCategoriaLCMapper() {
        return new ModelMapper();
    }

    @Bean("tesisAsesorMapper")
    public ModelMapper tesisAsesorMapper() {
        return new ModelMapper();
    }

    @Bean("tesisMapper")
    public ModelMapper tesisMapper() {
        return new ModelMapper();
    }

    @Bean("tesisPCMapper")
    public ModelMapper tesisPCMapper() {
        return new ModelMapper();
    }

    @Bean("usuarioMapper")
    public ModelMapper usuarioMapper() {
        return new ModelMapper();
    }

    @Bean("subcategoriaLCMapper")
    public ModelMapper subcategoriaLCMapper() {
        return new ModelMapper();
    }

    @Bean("pubAutorMapper")
    public ModelMapper pubAutorMapper() {
        return new ModelMapper();
    }

//    @Bean("rLibroMapper")
//    public ModelMapper rLibroMapper(){
//        ModelMapper mapper = new ModelMapper();
//        TypeMap<ProductDTO, Product> typeMap = mapper.createTypeMap(ProductDTO.class, Product.class);
//        //typeMap.addMapping(ProductDTO::getIdCategoria, (dest, v) -> dest.getCategory().setIdCategory((Integer) v));
//        //typeMap.addMapping(ProductDTO::getIdCategory, (dest, v) -> dest.getCategory().setIdCategory((Integer) v));
//        return mapper;
//    }

}
