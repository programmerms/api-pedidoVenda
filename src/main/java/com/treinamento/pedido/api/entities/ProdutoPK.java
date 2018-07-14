package com.treinamento.pedido.api.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ProdutoPK implements Serializable {
    private long prdId;
    private long catId;

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
        ProdutoPK produtoPK = (ProdutoPK) o;
        return prdId == produtoPK.prdId &&
                catId == produtoPK.catId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(prdId, catId);
    }
}
