package com.dibros.produto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.dibros.core.model.Usuario;
import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Produto implements AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false, referencedColumnName = "id")
    @JsonIgnore
    private Usuario usuario;

    private Long quantidade;
    @Column(name = "preco", precision = 16, scale=2)
    private BigDecimal preco;
    private String titulo;

}
    //@Column(unique = true)
    //private String codigo;
    // private List<Imagem> imagens;
    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
    //@JoinColumn(name="produto_id", referencedColumnName = "id", nullable = false)
    //private Set<ProdutoCaracteristica> produtoCaracteristicas = new HashSet<>();

    //@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST}, optional = false)
    //@JoinColumn(name = "titulo_id")
    //private ProdutoTitulo produtoTitulo;