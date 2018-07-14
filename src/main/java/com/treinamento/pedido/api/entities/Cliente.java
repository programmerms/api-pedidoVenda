package com.treinamento.pedido.api.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Cliente {
    private long cliId;
    private String cliDocto;
    private String cliNome;
    private String cliEnd;
    private String cliCidade;
    private String cliUf;
    private Timestamp cliDataAtualizacao;
    private Timestamp cliDataCriacao;
    private List<Pedido> pedidosByCliId;

    @Id
    @Column(name = "cli_id", nullable = false)
    public long getCliId() {
        return cliId;
    }

    public void setCliId(long cliId) {
        this.cliId = cliId;
    }

    @Basic
    @Column(name = "cli_docto", nullable = false, length = 14)
    public String getCliDocto() {
        return cliDocto;
    }

    public void setCliDocto(String cliDocto) {
        this.cliDocto = cliDocto;
    }

    @Basic
    @Column(name = "cli_nome", nullable = false, length = 100)
    public String getCliNome() {
        return cliNome;
    }

    public void setCliNome(String cliNome) {
        this.cliNome = cliNome;
    }

    @Basic
    @Column(name = "cli_end", nullable = false, length = 100)
    public String getCliEnd() {
        return cliEnd;
    }

    public void setCliEnd(String cliEnd) {
        this.cliEnd = cliEnd;
    }

    @Basic
    @Column(name = "cli_cidade", nullable = false, length = 50)
    public String getCliCidade() {
        return cliCidade;
    }

    public void setCliCidade(String cliCidade) {
        this.cliCidade = cliCidade;
    }

    @Basic
    @Column(name = "cli_uf", nullable = false, length = 2)
    public String getCliUf() {
        return cliUf;
    }

    public void setCliUf(String cliUf) {
        this.cliUf = cliUf;
    }

    @Basic
    @Column(name = "cli_data_atualizacao", nullable = false)
    public Timestamp getCliDataAtualizacao() {
        return cliDataAtualizacao;
    }

    public void setCliDataAtualizacao(Timestamp cliDataAtualizacao) {
        this.cliDataAtualizacao = cliDataAtualizacao;
    }

    @Basic
    @Column(name = "cli_data_criacao", nullable = false)
    public Timestamp getCliDataCriacao() {
        return cliDataCriacao;
    }

    public void setCliDataCriacao(Timestamp cliDataCriacao) {
        this.cliDataCriacao = cliDataCriacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return cliId == cliente.cliId &&
                Objects.equals(cliDocto, cliente.cliDocto) &&
                Objects.equals(cliNome, cliente.cliNome) &&
                Objects.equals(cliEnd, cliente.cliEnd) &&
                Objects.equals(cliCidade, cliente.cliCidade) &&
                Objects.equals(cliUf, cliente.cliUf) &&
                Objects.equals(cliDataAtualizacao, cliente.cliDataAtualizacao) &&
                Objects.equals(cliDataCriacao, cliente.cliDataCriacao);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cliId, cliDocto, cliNome, cliEnd, cliCidade, cliUf, cliDataAtualizacao, cliDataCriacao);
    }

    @OneToMany(mappedBy = "clienteByCliId")
    public List<Pedido> getPedidosByCliId() {
        return pedidosByCliId;
    }

    public void setPedidosByCliId(List<Pedido> pedidosByCliId) {
        this.pedidosByCliId = pedidosByCliId;
    }
}
