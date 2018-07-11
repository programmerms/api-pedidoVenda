
CREATE SEQUENCE public.seq_usuario_usu_id;

CREATE TABLE public.usuario (
                usu_id BIGINT NOT NULL DEFAULT nextval('public.seq_usuario_usu_id'),
                usu_email VARCHAR(255) NOT NULL,
                usu_senha VARCHAR(255) NOT NULL,
                usu_perfil VARCHAR(11) NOT NULL,
                usu_nome VARCHAR(100) NOT NULL,
                usu_data_atualizacao TIMESTAMP NOT NULL,
                usu_data_criacao TIMESTAMP NOT NULL,
                CONSTRAINT usuario_pk PRIMARY KEY (usu_id)
);


ALTER SEQUENCE public.seq_usuario_usu_id OWNED BY public.usuario.usu_id;

CREATE SEQUENCE public.seq_categoria_cat_id;

CREATE TABLE public.categoria (
                cat_id BIGINT NOT NULL DEFAULT nextval('public.seq_categoria_cat_id'),
                cat_desc VARCHAR(50) NOT NULL,
                cat_data_atualizacao TIMESTAMP NOT NULL,
                cat_data_criacao TIMESTAMP NOT NULL,
                CONSTRAINT categoria_pk PRIMARY KEY (cat_id)
);


ALTER SEQUENCE public.seq_categoria_cat_id OWNED BY public.categoria.cat_id;

CREATE SEQUENCE public.seq_produto_prd_id;

CREATE TABLE public.produto (
                prd_id BIGINT NOT NULL DEFAULT nextval('public.seq_produto_prd_id'),
                cat_id BIGINT NOT NULL,
                prd_desc VARCHAR(100) NOT NULL,
                prd_vlr NUMERIC(10,8) DEFAULT 0.00 NOT NULL,
                prd_estoque NUMERIC(10,8) DEFAULT 0.00 NOT NULL,
                prd_data_atualizacao TIMESTAMP NOT NULL,
                prd_data_criacao TIMESTAMP NOT NULL,
                CONSTRAINT produto_pk PRIMARY KEY (prd_id, cat_id)
);


ALTER SEQUENCE public.seq_produto_prd_id OWNED BY public.produto.prd_id;

CREATE SEQUENCE public.seq_cliente_cli_id;

CREATE TABLE public.cliente (
                cli_id BIGINT NOT NULL DEFAULT nextval('public.seq_cliente_cli_id'),
                cli_docto VARCHAR(14) NOT NULL,
                cli_nome VARCHAR(100) NOT NULL,
                cli_end VARCHAR(100) NOT NULL,
                cli_cidade VARCHAR(50) NOT NULL,
                cli_uf VARCHAR(2) NOT NULL,
                cli_data_atualizacao TIMESTAMP NOT NULL,
                cli_data_criacao TIMESTAMP NOT NULL,
                CONSTRAINT cliente_pk PRIMARY KEY (cli_id)
);


ALTER SEQUENCE public.seq_cliente_cli_id OWNED BY public.cliente.cli_id;

CREATE SEQUENCE public.seq_pedido_ped_id;

CREATE TABLE public.pedido (
                ped_id BIGINT NOT NULL DEFAULT nextval('public.seq_pedido_ped_id'),
                cli_id BIGINT NOT NULL,
                usu_id BIGINT NOT NULL,
                ped_data_entrega TIMESTAMP,
                ped_valor_frete NUMERIC(10,8) DEFAULT 0.00 NOT NULL,
                ped_vlr_descto NUMERIC(10,8) DEFAULT 0.00 NOT NULL,
                ped_status VARCHAR(10) NOT NULL,
                ped_forma_pagto VARCHAR(16),
                ped_data_atualizacao TIMESTAMP NOT NULL,
                ped_data_criacao TIMESTAMP NOT NULL,
                CONSTRAINT pedido_pk PRIMARY KEY (ped_id, cli_id, usu_id)
);


ALTER SEQUENCE public.seq_pedido_ped_id OWNED BY public.pedido.ped_id;

CREATE SEQUENCE public.seq_itens_pedido_ite_id;

CREATE TABLE public.itens_pedido (
                ite_id BIGINT NOT NULL DEFAULT nextval('public.seq_itens_pedido_ite_id'),
                ped_id BIGINT NOT NULL,
                cli_id BIGINT NOT NULL,
                usu_id BIGINT NOT NULL,
                prd_id BIGINT NOT NULL,
                cat_id BIGINT NOT NULL,
                ite_qtde NUMERIC(10,8) DEFAULT 0.00 NOT NULL,
                ite_vlr_unit NUMERIC(10,8) DEFAULT 0.00 NOT NULL,
                CONSTRAINT itens_pedido_pk PRIMARY KEY (ite_id, ped_id, cli_id, usu_id, prd_id, cat_id)
);


ALTER SEQUENCE public.seq_itens_pedido_ite_id OWNED BY public.itens_pedido.ite_id;

ALTER TABLE public.pedido ADD CONSTRAINT usuario_pedido_fk
FOREIGN KEY (usu_id)
REFERENCES public.usuario (usu_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.produto ADD CONSTRAINT categoria_produto_fk
FOREIGN KEY (cat_id)
REFERENCES public.categoria (cat_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.itens_pedido ADD CONSTRAINT produto_itens_pedido_fk
FOREIGN KEY (prd_id, cat_id)
REFERENCES public.produto (prd_id, cat_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.pedido ADD CONSTRAINT cliente_pedido_fk
FOREIGN KEY (cli_id)
REFERENCES public.cliente (cli_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.itens_pedido ADD CONSTRAINT pedido_itens_pedido_fk
FOREIGN KEY (ped_id, cli_id, usu_id)
REFERENCES public.pedido (ped_id, cli_id, usu_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;