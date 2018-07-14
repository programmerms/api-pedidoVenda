package com.treinamento.pedido.api.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@IdClass(ProdutoPK.class)
public class Produto {
    private long prdId;
    private long catId;
    private String prdDesc;
    private BigDecimal prdVlr;
    private BigDecimal prdEstoque;
    private Timestamp prdDataAtualizacao;
    private Timestamp prdDataCriacao;
    private List<ItensPedido> itensPedidos;
    private Categoria categoriaByCatId;

    @Id
    @Column(name = "prd_id", nullable = false)
    public long getPrdId() {
        return prdId;
    }

    public void setPrdId(long prdId) {
        this.prdId = prdId;
    }

    @Id
    @Column(name = "cat_id", nullable = false)
    public long getCatId() {
        return catId;
    }

    public void setCatId(long catId) {
        this.catId = catId;
    }

    @Basic
    @Column(name = "prd_desc", nullable = false, length = 100)
    public String getPrdDesc() {
        return prdDesc;
    }

    public void setPrdDesc(String prdDesc) {
        this.prdDesc = prdDesc;
    }

    @Basic
    @Column(name = "prd_vlr", nullable = false, precision = 8)
    public BigDecimal getPrdVlr() {
        return prdVlr;
    }

    public void setPrdVlr(BigDecimal prdVlr) {
        this.prdVlr = prdVlr;
    }

    @Basic
    @Column(name = "prd_estoque", nullable = false, precision = 8)
    public BigDecimal getPrdEstoque() {
        return prdEstoque;
    }

    public void setPrdEstoque(BigDecimal prdEstoque) {
        this.prdEstoque = prdEstoque;
    }

    @Basic
    @Column(name = "prd_data_atualizacao", nullable = false)
    public Timestamp getPrdDataAtualizacao() {
        return prdDataAtualizacao;
    }

    public void setPrdDataAtualizacao(Timestamp prdDataAtualizacao) {
        this.prdDataAtualizacao = prdDataAtualizacao;
    }

    @Basic
    @Column(name = "prd_data_criacao", nullable = false)
    public Timestamp getPrdDataCriacao() {
        return prdDataCriacao;
    }

    public void setPrdDataCriacao(Timestamp prdDataCriacao) {
        this.prdDataCriacao = prdDataCriacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return prdId == produto.prdId &&
                catId == produto.catId &&
                Objects.equals(prdDesc, produto.prdDesc) &&
                Objects.equals(prdVlr, produto.prdVlr) &&
                Objects.equals(prdEstoque, produto.prdEstoque) &&
                Objects.equals(prdDataAtualizacao, produto.prdDataAtualizacao) &&
                Objects.equals(prdDataCriacao, produto.prdDataCriacao);
    }

    @Override
    public int hashCode() {

        return Objects.hash(prdId, catId, prdDesc, prdVlr, prdEstoque, prdDataAtualizacao, prdDataCriacao);
    }

    @OneToMany(mappedBy = "produto")
    public List<ItensPedido> getItensPedidos() {
        return itensPedidos;
    }

    public void setItensPedidos(List<ItensPedido> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }

    @ManyToOne
    @JoinColumn(name = "cat_id", referencedColumnName = "cat_id", nullable = false)
    public Categoria getCategoriaByCatId() {
        return categoriaByCatId;
    }

    public void setCategoriaByCatId(Categoria categoriaByCatId) {
        this.categoriaByCatId = categoriaByCatId;
    }
}
