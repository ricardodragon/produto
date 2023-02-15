package com.dibros.produto.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutoCaracteristicaDTO {

    private Long id;

    private String nome;
    private String valor;
}
