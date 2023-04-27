CREATE TABLE tb_caracteristicas(
    caracteristicas_id integer PRIMARY KEY,
    personalidade text,
    ideais text,
    ligacoes text,
    defeitos text
);

CREATE TABLE tb_personagem (
    user_id text PRIMARY KEY,
    fichas integer REFERENCES tb_fichas,
    caracteristicas integer REFERENCES tb_caracteristicas,
    nome varchar(80),
     classe varchar(80),
    nivel integer,
    antecedente varchar(80),
    raca varchar(16),
    tendencia varchar(16),
    experiencia integer,
    bonusProficiencia integer,
    sabedoriaPassiva integer
);

CREATE TABLE tb_status (
   status_id integer PRIMARY KEY,
   forca integer,
   destreza integer,
   constituicao integer,
   inteligencia integer,
   sabedoria integer,
   carisma integer
);

CREATE TABLE tb_estatisticas (
                                 estatisticas_id integer PRIMARY KEY,
                                 armdClasse integer,
                                 iniciativa integer,
                                 deslocamento integer,
                                 pv integer,
                                 pv_temp integer,
                                 dVida integer,
                                 testes_contra_morte integer,
                                 t_sucessos integer,
                                 t_fracassos integer
);

CREATE TABLE tb_pForca (
                           pForca_id integer PRIMARY KEY,
                           atletismo integer
);

CREATE TABLE tb_pDestreza(
                             pDestreza_id integer PRIMARY KEY,
                             acrobacia integer,
                             prestidigitacao integer,
                             furtividade integer
);

CREATE TABLE tb_pInteligencia(
                             pInteligencia_id integer PRIMARY KEY,
                             c_arcano integer,
                             c_historia integer,
                             c_natureza integer,
                             procurar integer
);

CREATE TABLE tb_pSabedoria(
                              pSabedoria_id integer PRIMARY KEY,
                              lidar_com_animais integer,
                              motivacao integer,
                              cura integer,
                              percepcao integer,
                              sobrevivencia integer
);

CREATE TABLE tb_pCarisma(
                            pCarisma_id integer PRIMARY KEY,
                            enganacao integer,
                            intimidacao integer,
                            atuacao integer,
                            persuasao integer
);

CREATE TABLE tb_pericias (
                             pericias_id integer PRIMARY KEY,
                             forca integer REFERENCES tb_pForca,
                             destreza integer REFERENCES tb_pDestreza,
                             inteligencia integer REFERENCES tb_pInteligencia,
                             sabedoria integer REFERENCES tb_pSabedoria,
                             carisma integer REFERENCES tb_pCarisma
);

CREATE TABLE tb_ficha (
    fichas_id integer PRIMARY KEY,
    status integer REFERENCES tb_status,
    pericias integer REFERENCES tb_pericias,
    estatisticas REFERENCES tb_estatisticas
);
