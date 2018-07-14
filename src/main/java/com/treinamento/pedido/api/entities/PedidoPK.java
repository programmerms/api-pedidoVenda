package com.treinamento.pedido.api.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PedidoPK implements Serializable {
    private long pedId;
    private long cliId;
    private long usuId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoPK pedidoPK = (PedidoPK) o;
        return pedId == pedidoPK.pedId &&
                cliId == pedidoPK.cliId &&
                usuId == pedidoPK.usuId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(pedId, cliId, usuId);
    }
}
