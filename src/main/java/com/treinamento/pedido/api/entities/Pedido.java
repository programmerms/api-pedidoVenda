package com.treinamento.pedido.api.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@IdClass(PedidoPK.class)
public class Pedido {
    private long pedId;
    private long cliId;
    private long usuId;
    private Timestamp pedDataEntrega;
    private BigDecimal pedValorFrete;
    private BigDecimal pedVlrDescto;
    private String pedStatus;
    private String pedFormaPagto;
    private Timestamp pedDataAtualizacao;
    private Timestamp pedDataCriacao;
    private List<ItensPedido> itensPedidos;
    private Cliente clienteByCliId;
    private Usuario usuarioByUsuId;

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

    @Basic
    @Column(name = "ped_data_entrega", nullable = true)
    public Timestamp getPedDataEntrega() {
        return pedDataEntrega;
    }

    public void setPedDataEntrega(Timestamp pedDataEntrega) {
        this.pedDataEntrega = pedDataEntrega;
    }

    @Basic
    @Column(name = "ped_valor_frete", nullable = false, precision = 8)
    public BigDecimal getPedValorFrete() {
        return pedValorFrete;
    }

    public void setPedValorFrete(BigDecimal pedValorFrete) {
        this.pedValorFrete = pedValorFrete;
    }

    @Basic
    @Column(name = "ped_vlr_descto", nullable = false, precision = 8)
    public BigDecimal getPedVlrDescto() {
        return pedVlrDescto;
    }

    public void setPedVlrDescto(BigDecimal pedVlrDescto) {
        this.pedVlrDescto = pedVlrDescto;
    }

    @Basic
    @Column(name = "ped_status", nullable = false, length = 10)
    public String getPedStatus() {
        return pedStatus;
    }

    public void setPedStatus(String pedStatus) {
        this.pedStatus = pedStatus;
    }

    @Basic
    @Column(name = "ped_forma_pagto", nullable = true, length = 16)
    public String getPedFormaPagto() {
        return pedFormaPagto;
    }

    public void setPedFormaPagto(String pedFormaPagto) {
        this.pedFormaPagto = pedFormaPagto;
    }

    @Basic
    @Column(name = "ped_data_atualizacao", nullable = false)
    public Timestamp getPedDataAtualizacao() {
        return pedDataAtualizacao;
    }

    public void setPedDataAtualizacao(Timestamp pedDataAtualizacao) {
        this.pedDataAtualizacao = pedDataAtualizacao;
    }

    @Basic
    @Column(name = "ped_data_criacao", nullable = false)
    public Timestamp getPedDataCriacao() {
        return pedDataCriacao;
    }

    public void setPedDataCriacao(Timestamp pedDataCriacao) {
        this.pedDataCriacao = pedDataCriacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return pedId == pedido.pedId &&
                cliId == pedido.cliId &&
                usuId == pedido.usuId &&
                Objects.equals(pedDataEntrega, pedido.pedDataEntrega) &&
                Objects.equals(pedValorFrete, pedido.pedValorFrete) &&
                Objects.equals(pedVlrDescto, pedido.pedVlrDescto) &&
                Objects.equals(pedStatus, pedido.pedStatus) &&
                Objects.equals(pedFormaPagto, pedido.pedFormaPagto) &&
                Objects.equals(pedDataAtualizacao, pedido.pedDataAtualizacao) &&
                Objects.equals(pedDataCriacao, pedido.pedDataCriacao);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pedId, cliId, usuId, pedDataEntrega, pedValorFrete, pedVlrDescto, pedStatus, pedFormaPagto, pedDataAtualizacao, pedDataCriacao);
    }

    @OneToMany(mappedBy = "pedido")
    public List<ItensPedido> getItensPedidos() {
        return itensPedidos;
    }

    public void setItensPedidos(List<ItensPedido> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }

    @ManyToOne
    @JoinColumn(name = "cli_id", referencedColumnName = "cli_id", nullable = false)
    public Cliente getClienteByCliId() {
        return clienteByCliId;
    }

    public void setClienteByCliId(Cliente clienteByCliId) {
        this.clienteByCliId = clienteByCliId;
    }

    @ManyToOne
    @JoinColumn(name = "usu_id", referencedColumnName = "usu_id", nullable = false)
    public Usuario getUsuarioByUsuId() {
        return usuarioByUsuId;
    }

    public void setUsuarioByUsuId(Usuario usuarioByUsuId) {
        this.usuarioByUsuId = usuarioByUsuId;
    }
}
