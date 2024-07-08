create table addresses
(
  cep varchar(9) NOT NULL,
  logradouro varchar(255) NOT NULL,
  complemento varchar(255) NOT NULL,
  bairro varchar(255) NOT NULL,
  localidade varchar(255) NOT NULL,
  uf varchar(2) NOT NULL,
  PRIMARY KEY (cep)
);
