
CREATE SEQUENCE public.seq_tb_usuario;

CREATE TABLE public.tb_usuario (
                usu_id BIGINT NOT NULL DEFAULT nextval('public.seq_tb_usuario'),
                usu_email VARCHAR(255) NOT NULL,
                usu_senha VARCHAR(255) NOT NULL,
                usu_perfil VARCHAR(11) NOT NULL,
                usu_nome VARCHAR(100) NOT NULL,
                usu_data_atualizacao TIMESTAMP NOT NULL,
                usu_data_criacao TIMESTAMP NOT NULL,
                CONSTRAINT tb_usuario_pk PRIMARY KEY (usu_id)
);


ALTER SEQUENCE public.seq_tb_usuario OWNED BY public.tb_usuario.usu_id;

CREATE SEQUENCE public.seq_tb_categoria;

CREATE TABLE public.tb_categoria (
                cat_id BIGINT NOT NULL DEFAULT nextval('public.seq_tb_categoria'),
                cat_desc VARCHAR(50) NOT NULL,
                cat_data_atualizacao TIMESTAMP NOT NULL,
                cat_data_criacao TIMESTAMP NOT NULL,
                CONSTRAINT tb_categoria_pk PRIMARY KEY (cat_id)
);


ALTER SEQUENCE public.seq_tb_categoria OWNED BY public.tb_categoria.cat_id;

CREATE SEQUENCE public.seq_tb_produto;

CREATE TABLE public.tb_produto (
                prd_id BIGINT NOT NULL DEFAULT nextval('public.seq_tb_produto'),
                cat_id BIGINT NOT NULL,
                prd_desc VARCHAR(100) NOT NULL,
                prd_vlr NUMERIC(10,8) DEFAULT 0.00 NOT NULL,
                prd_estoque NUMERIC(10,8) DEFAULT 0.00 NOT NULL,
                prd_data_atualizacao TIMESTAMP NOT NULL,
                prd_data_criacao TIMESTAMP NOT NULL,
                CONSTRAINT tb_produto_pk PRIMARY KEY (prd_id, cat_id)
);


ALTER SEQUENCE public.seq_tb_produto OWNED BY public.tb_produto.prd_id;

CREATE SEQUENCE public.seq_tb_cliente;

CREATE TABLE public.tb_cliente (
                cli_id BIGINT NOT NULL DEFAULT nextval('public.seq_tb_cliente'),
                cli_docto VARCHAR(14) NOT NULL,
                cli_nome VARCHAR(100) NOT NULL,
                cli_end VARCHAR(100) NOT NULL,
                cli_cidade VARCHAR(50) NOT NULL,
                cli_uf VARCHAR(2) NOT NULL,
                cli_data_atualizacao TIMESTAMP NOT NULL,
                cli_data_criacao TIMESTAMP NOT NULL,
                CONSTRAINT tb_cliente_pk PRIMARY KEY (cli_id)
);


ALTER SEQUENCE public.seq_tb_cliente OWNED BY public.tb_cliente.cli_id;

CREATE SEQUENCE public.seq_tb_pedido;

CREATE TABLE public.tb_pedido (
                ped_id BIGINT NOT NULL DEFAULT nextval('public.seq_tb_pedido'),
                cli_id BIGINT NOT NULL,
                usu_id BIGINT NOT NULL,
                ped_data_entrega TIMESTAMP,
                ped_valor_frete NUMERIC(10,8) DEFAULT 0.00 NOT NULL,
                ped_vlr_descto NUMERIC(10,8) DEFAULT 0.00 NOT NULL,
                ped_status VARCHAR(10) NOT NULL,
                ped_forma_pagto VARCHAR(16),
                ped_data_atualizacao TIMESTAMP NOT NULL,
                ped_data_criacao TIMESTAMP NOT NULL,
                CONSTRAINT tb_pedido_pk PRIMARY KEY (ped_id, cli_id, usu_id)
);


ALTER SEQUENCE public.seq_tb_pedido OWNED BY public.tb_pedido.ped_id;

CREATE SEQUENCE public.seq_tb_itens_pedido;

CREATE TABLE public.tb_itens_pedido (
                ite_id BIGINT NOT NULL DEFAULT nextval('public.seq_tb_itens_pedido'),
                ped_id BIGINT NOT NULL,
                cli_id BIGINT NOT NULL,
                usu_id BIGINT NOT NULL,
                prd_id BIGINT NOT NULL,
                cat_id BIGINT NOT NULL,
                ite_qtde NUMERIC(10,8) DEFAULT 0.00 NOT NULL,
                ite_vlr_unit NUMERIC(10,8) DEFAULT 0.00 NOT NULL,
                CONSTRAINT tb_itens_pedido_pk PRIMARY KEY (ite_id, ped_id, cli_id, usu_id, prd_id, cat_id)
);


ALTER SEQUENCE public.seq_tb_itens_pedido OWNED BY public.tb_itens_pedido.ite_id;

ALTER TABLE public.tb_pedido ADD CONSTRAINT usuario_pedido_fk
FOREIGN KEY (usu_id)
REFERENCES public.tb_usuario (usu_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.tb_produto ADD CONSTRAINT categoria_produto_fk
FOREIGN KEY (cat_id)
REFERENCES public.tb_categoria (cat_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.tb_itens_pedido ADD CONSTRAINT produto_itens_pedido_fk
FOREIGN KEY (prd_id, cat_id)
REFERENCES public.tb_produto (prd_id, cat_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.tb_pedido ADD CONSTRAINT cliente_pedido_fk
FOREIGN KEY (cli_id)
REFERENCES public.tb_cliente (cli_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.tb_itens_pedido ADD CONSTRAINT pedido_itens_pedido_fk
FOREIGN KEY (ped_id, cli_id, usu_id)
REFERENCES public.tb_pedido (ped_id, cli_id, usu_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;