package com.dibros.produto.controller;

import com.dibros.produto.dto.ProdutoDTO;
import com.dibros.produto.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Api(value = "Endpoints to manage usuarios")
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    @ApiOperation(value = "List all available produtos", response = ProdutoDTO.class)
    public ResponseEntity<Iterable<ProdutoDTO>> getProduto() {
        return new ResponseEntity<>(this.produtoService.getProdutos(), HttpStatus.OK);
    }

    @GetMapping("/all")
    @ApiOperation(value = "List all available produtos", response = ProdutoDTO[].class)
    public ResponseEntity<Iterable<ProdutoDTO>> getProdutos() {
        return new ResponseEntity<>(this.produtoService.getProdutos(), HttpStatus.OK);
    }


    @PostMapping
    @ApiOperation(value = "List all available produtos", response = ProdutoDTO.class)
    public ResponseEntity<ProdutoDTO> postProdutos(@RequestBody ProdutoDTO produtoDTO) {
        return new ResponseEntity<>(this.produtoService.postProduto(produtoDTO), HttpStatus.OK);
    }

    @PutMapping
    @ApiOperation(value = "List all available produtos", response = ProdutoDTO.class)
    public ResponseEntity<ProdutoDTO> putProdutos(@RequestBody ProdutoDTO produtoDTO) {
        return new ResponseEntity<>(this.produtoService.putProduto(produtoDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "List all available produtos", response = String.class)
    public ResponseEntity<String> deleteProdutos(@PathVariable Long id) {
        return new ResponseEntity<>(this.produtoService.deleteProduto(id), HttpStatus.OK);
    }
}
