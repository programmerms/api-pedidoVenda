package com.treinamento.pedido.api.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TB_CATEGORIA", schema = "public")
@SequenceGenerator(name = "SEQ_DESTINACAO", sequenceName = "almox.SEQ_DESTINACAO")
public class Categoria {
    private long catId;
    private String catDesc;
    private Timestamp catDataAtualizacao;
    private Timestamp catDataCriacao;
    private List<Produto> produtosByCatId;

    @Id
    @Column(name = "cat_id", nullable = false)
    public long getCatId() {
        return catId;
    }

    public void setCatId(long catId) {
        this.catId = catId;
    }

    @Basic
    @Column(name = "cat_desc", nullable = false, length = 50)
    public String getCatDesc() {
        return catDesc;
    }

    public void setCatDesc(String catDesc) {
        this.catDesc = catDesc;
    }

    @Basic
    @Column(name = "cat_data_atualizacao", nullable = false)
    public Timestamp getCatDataAtualizacao() {
        return catDataAtualizacao;
    }

    public void setCatDataAtualizacao(Timestamp catDataAtualizacao) {
        this.catDataAtualizacao = catDataAtualizacao;
    }

    @Basic
    @Column(name = "cat_data_criacao", nullable = false)
    public Timestamp getCatDataCriacao() {
        return catDataCriacao;
    }

    public void setCatDataCriacao(Timestamp catDataCriacao) {
        this.catDataCriacao = catDataCriacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return catId == categoria.catId &&
                Objects.equals(catDesc, categoria.catDesc) &&
                Objects.equals(catDataAtualizacao, categoria.catDataAtualizacao) &&
                Objects.equals(catDataCriacao, categoria.catDataCriacao);
    }

    @Override
    public int hashCode() {

        return Objects.hash(catId, catDesc, catDataAtualizacao, catDataCriacao);
    }

    @OneToMany(mappedBy = "categoriaByCatId")
    public List<Produto> getProdutosByCatId() {
        return produtosByCatId;
    }

    public void setProdutosByCatId(List<Produto> produtosByCatId) {
        this.produtosByCatId = produtosByCatId;
    }
}
