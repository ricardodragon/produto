package com.dibros.produto.dto;

import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutoDTO {

    private Long id;
    //private String codigo;
    private Long quantidade;
    private BigDecimal preco;
    private String titulo;
}

//private Set<ProdutoCaracteristicaDTO> produtoCaracteristicasDTO = new HashSet<>();
//private ProdutoTituloDTO produtoTituloDTO;
// private List<Imagem> imagens;
