package com.treinamento.pedido.api.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Usuario {
    private long usuId;
    private String usuEmail;
    private String usuSenha;
    private String usuPerfil;
    private String usuNome;
    private Timestamp usuDataAtualizacao;
    private Timestamp usuDataCriacao;
    private List<Pedido> pedidosByUsuId;

    @Id
    @Column(name = "usu_id", nullable = false)
    public long getUsuId() {
        return usuId;
    }

    public void setUsuId(long usuId) {
        this.usuId = usuId;
    }

    @Basic
    @Column(name = "usu_email", nullable = false, length = 255)
    public String getUsuEmail() {
        return usuEmail;
    }

    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }

    @Basic
    @Column(name = "usu_senha", nullable = false, length = 255)
    public String getUsuSenha() {
        return usuSenha;
    }

    public void setUsuSenha(String usuSenha) {
        this.usuSenha = usuSenha;
    }

    @Basic
    @Column(name = "usu_perfil", nullable = false, length = 11)
    public String getUsuPerfil() {
        return usuPerfil;
    }

    public void setUsuPerfil(String usuPerfil) {
        this.usuPerfil = usuPerfil;
    }

    @Basic
    @Column(name = "usu_nome", nullable = false, length = 100)
    public String getUsuNome() {
        return usuNome;
    }

    public void setUsuNome(String usuNome) {
        this.usuNome = usuNome;
    }

    @Basic
    @Column(name = "usu_data_atualizacao", nullable = false)
    public Timestamp getUsuDataAtualizacao() {
        return usuDataAtualizacao;
    }

    public void setUsuDataAtualizacao(Timestamp usuDataAtualizacao) {
        this.usuDataAtualizacao = usuDataAtualizacao;
    }

    @Basic
    @Column(name = "usu_data_criacao", nullable = false)
    public Timestamp getUsuDataCriacao() {
        return usuDataCriacao;
    }

    public void setUsuDataCriacao(Timestamp usuDataCriacao) {
        this.usuDataCriacao = usuDataCriacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return usuId == usuario.usuId &&
                Objects.equals(usuEmail, usuario.usuEmail) &&
                Objects.equals(usuSenha, usuario.usuSenha) &&
                Objects.equals(usuPerfil, usuario.usuPerfil) &&
                Objects.equals(usuNome, usuario.usuNome) &&
                Objects.equals(usuDataAtualizacao, usuario.usuDataAtualizacao) &&
                Objects.equals(usuDataCriacao, usuario.usuDataCriacao);
    }

    @Override
    public int hashCode() {

        return Objects.hash(usuId, usuEmail, usuSenha, usuPerfil, usuNome, usuDataAtualizacao, usuDataCriacao);
    }

    @OneToMany(mappedBy = "usuarioByUsuId")
    public List<Pedido> getPedidosByUsuId() {
        return pedidosByUsuId;
    }

    public void setPedidosByUsuId(List<Pedido> pedidosByUsuId) {
        this.pedidosByUsuId = pedidosByUsuId;
    }
}
