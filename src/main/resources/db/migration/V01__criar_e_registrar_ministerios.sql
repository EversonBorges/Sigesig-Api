CREATE TABLE ministerio(
    id_ministerio BIGSERIAL,
    desc_ministerio VARCHAR(50) NOT NULL,
   CONSTRAINT id_ministerio PRIMARY KEY(id_ministerio)
) ;

INSERT INTO ministerio (desc_ministerio) VALUES ('Diacono');
INSERT INTO ministerio (desc_ministerio) VALUES ('Pastor');
INSERT INTO ministerio (desc_ministerio) VALUES ('Lider');
