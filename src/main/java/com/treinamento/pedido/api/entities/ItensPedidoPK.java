package com.treinamento.pedido.api.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ItensPedidoPK implements Serializable {
    private long iteId;
    private long pedId;
    private long cliId;
    private long usuId;
    private long prdId;
    private long catId;

    @Column(name = "ite_id", nullable = false)
    @Id
    public long getIteId() {
        return iteId;
    }

    public void setIteId(long iteId) {
        this.iteId = iteId;
    }

    @Column(name = "ped_id", nullable = false)
    @Id
    public long getPedId() {
        return pedId;
    }

    public void setPedId(long pedId) {
        this.pedId = pedId;
    }

    @Column(name = "cli_id", nullable = false)
    @Id
    public long getCliId() {
        return cliId;
    }

    public void setCliId(long cliId) {
        this.cliId = cliId;
    }

    @Column(name = "usu_id", nullable = false)
    @Id
    public long getUsuId() {
        return usuId;
    }

    public void setUsuId(long usuId) {
        this.usuId = usuId;
    }

    @Column(name = "prd_id", nullable = false)
    @Id
    public long getPrdId() {
        return prdId;
    }

    public void setPrdId(long prdId) {
        this.prdId = prdId;
    }

    @Column(name = "cat_id", nullable = false)
    @Id
    public long getCatId() {
        return catId;
    }

    public void setCatId(long catId) {
        this.catId = catId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItensPedidoPK that = (ItensPedidoPK) o;
        return iteId == that.iteId &&
                pedId == that.pedId &&
                cliId == that.cliId &&
                usuId == that.usuId &&
                prdId == that.prdId &&
                catId == that.catId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(iteId, pedId, cliId, usuId, prdId, catId);
    }
}
