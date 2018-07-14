package com.treinamento.pedido.api.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "itens_pedido", schema = "public", catalog = "api-treinamento-pedido")
@IdClass(ItensPedidoPK.class)
public class ItensPedido {
    private long iteId;
    private long pedId;
    private long cliId;
    private long usuId;
    private long prdId;
    private long catId;
    private BigDecimal iteQtde;
    private BigDecimal iteVlrUnit;
    private Pedido pedido;
    private Produto produto;

    @Id
    @Column(name = "ite_id", nullable = false)
    public long getIteId() {
        return iteId;
    }

    public void setIteId(long iteId) {
        this.iteId = iteId;
    }

    @Id
    @Column(name = "ped_id", nullable = false)
    public long getPedId() {
        return pedId;
    }

    public void setPedId(long pedId) {
        this.pedId = pedId;
    }

    @Id
    @Column(name = "cli_id", nullable = false)
    public long getCliId() {
        return cliId;
    }

    public void setCliId(long cliId) {
        this.cliId = cliId;
    }

    @Id
    @Column(name = "usu_id", nullable = false)
    public long getUsuId() {
        return usuId;
    }

    public void setUsuId(long usuId) {
        this.usuId = usuId;
    }

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
    @Column(name = "ite_qtde", nullable = false, precision = 8)
    public BigDecimal getIteQtde() {
        return iteQtde;
    }

    public void setIteQtde(BigDecimal iteQtde) {
        this.iteQtde = iteQtde;
    }

    @Basic
    @Column(name = "ite_vlr_unit", nullable = false, precision = 8)
    public BigDecimal getIteVlrUnit() {
        return iteVlrUnit;
    }

    public void setIteVlrUnit(BigDecimal iteVlrUnit) {
        this.iteVlrUnit = iteVlrUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItensPedido that = (ItensPedido) o;
        return iteId == that.iteId &&
                pedId == that.pedId &&
                cliId == that.cliId &&
                usuId == that.usuId &&
                prdId == that.prdId &&
                catId == that.catId &&
                Objects.equals(iteQtde, that.iteQtde) &&
                Objects.equals(iteVlrUnit, that.iteVlrUnit);
    }

    @Override
    public int hashCode() {

        return Objects.hash(iteId, pedId, cliId, usuId, prdId, catId, iteQtde, iteVlrUnit);
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "ped_id", referencedColumnName = "ped_id", nullable = false), @JoinColumn(name = "cli_id", referencedColumnName = "cli_id", nullable = false), @JoinColumn(name = "usu_id", referencedColumnName = "usu_id", nullable = false)})
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "prd_id", referencedColumnName = "prd_id", nullable = false), @JoinColumn(name = "cat_id", referencedColumnName = "cat_id", nullable = false)})
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
