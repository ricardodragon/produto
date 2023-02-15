package com.dibros.produto.service;

import com.dibros.core.model.Usuario;
import com.dibros.produto.dto.ProdutoDTO;
import com.dibros.produto.model.Produto;
import com.dibros.produto.mapper.ProdutoMapper;
import com.dibros.produto.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public Iterable<ProdutoDTO> getProdutos() {
        return ProdutoMapper.INSTANCE.toListProdutoDTO(this.produtoRepository.findByUsuarioId(((Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId()));
    }

    public ProdutoDTO postProduto(ProdutoDTO produtoDTO) {
        Produto p = ProdutoMapper.INSTANCE.toProduto(produtoDTO);
        p.setUsuario((Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return ProdutoMapper.INSTANCE.toProdutoDTO(this.produtoRepository.save(p));
    }

    public ProdutoDTO putProduto(ProdutoDTO produtoDTO) {
        Produto p = this.produtoRepository.findById(produtoDTO.getId()).get();
        ProdutoMapper.INSTANCE.toProdutoMerge(produtoDTO, p);
        return ProdutoMapper.INSTANCE.toProdutoDTO(this.produtoRepository.save(p));
    }

    public String deleteProduto(Long id) {
        this.produtoRepository.deleteById(id);
        return "Ok";
    }

//p.setProdutoTitulo(p.getProdutoTitulo().getId()!=null?this.produtoTituloRepository.findById(p.getProdutoTitulo().getId()).get():p.getProdutoTitulo());
//	public UsuarioDTO saveApplicationUserByUsername(UsuarioDTO userDTO) {
//		applicationUserRepository.save(UsuarioMapperImpl.INSTANCE.userDTO);
//		return
//	}
}
