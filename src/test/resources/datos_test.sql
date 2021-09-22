INSERT INTO MS_PAGOS.MEDIO_PAGO (observacion) VALUES
    ('Observacion01'),
    ('Observacion02'),
    ('Observacion03');

INSERT INTO MS_PAGOS.EFECTIVO (nro_recibo, id_medio_pago) VALUES
    (1, 1);

INSERT INTO MS_PAGOS.CHEQUE (numero, banco, id_medio_pago) VALUES
    (1, 'Banco01', 2);

INSERT INTO MS_PAGOS.TRANSFERENCIA (cbu_origen, cbu_destino, codigo, id_medio_pago) VALUES
    ('0101010101', '1010101010', 1L, 3);

INSERT INTO MS_PAGOS.CLIENTE (id_cliente, razon_social, cuit, mail) VALUES
    (1, 'Cliente01', '11111111111', 'customer01@example.com'),
    (2, 'Cliente02', '22222222222', 'customer02@example.com');

INSERT INTO MS_PAGOS.PAGO (id_cliente, id_medio_pago) VALUES
    (1, 1),
    (2, 2),
    (1, 3);