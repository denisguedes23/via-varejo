CREATE TABLE varejo.tb_condicao_pagamento (
	id bigserial NOT NULL,
	qtde_parcelas int4 NULL,
	valor_entrada numeric(19,2) NULL,
	CONSTRAINT tb_condicao_pagamento_pkey PRIMARY KEY (id)
);

CREATE TABLE varejo.tb_condicao_pagamento_parcela (
	id bigserial NOT NULL,
	numero_parcela int4 NULL,
	taxa_juros_mes numeric(19,2) NULL,
	valor numeric(19,2) NULL,
	condicao_pagamento_id int8 NULL,
	CONSTRAINT tb_condicao_pagamento_parcela_pkey PRIMARY KEY (id),
	CONSTRAINT condicao_pagamento_fk FOREIGN KEY (condicao_pagamento_id) REFERENCES varejo.tb_condicao_pagamento(id)
);

CREATE TABLE varejo.tb_produto (
	id bigserial NOT NULL,
	codigo varchar(5) NULL,
	nome varchar(255) NULL,
	valor numeric(19,2) NULL,
	condicao_pagamento_id int8 NULL,
	CONSTRAINT tb_produto_pkey PRIMARY KEY (id),
	CONSTRAINT produto_condicao_pagamento_fk FOREIGN KEY (condicao_pagamento_id) REFERENCES varejo.tb_condicao_pagamento(id)
);

