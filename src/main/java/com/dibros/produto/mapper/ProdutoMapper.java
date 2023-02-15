package com.dibros.produto.mapper;

import com.dibros.produto.dto.ProdutoDTO;
import com.dibros.produto.dto.ProdutoTituloDTO;
import com.dibros.produto.model.Produto;
import com.dibros.produto.model.ProdutoTitulo;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    ProdutoDTO toProdutoDTO(Produto produto);
    Produto toProduto(ProdutoDTO produtoDTO);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toProdutoMerge(ProdutoDTO produtoDTO, @MappingTarget Produto produto);
    Iterable<ProdutoDTO> toListProdutoDTO(Iterable<Produto> produtos);
    ProdutoTitulo toProdutoTitulo(ProdutoTituloDTO produtoTituloDTO);
    ProdutoTituloDTO toProdutoTituloDTO(ProdutoTitulo produtoTitulo);
}
//@Mapping(source = "produtoTitulo", target = "produtoTituloDTO")
//@Mapping(source = "produtoCaracteristicas", target = "produtoCaracteristicasDTO")
//@Mapping(source = "produtoTituloDTO", target = "produtoTitulo")
//@Mapping(source = "produtoCaracteristicasDTO", target = "produtoCaracteristicas")