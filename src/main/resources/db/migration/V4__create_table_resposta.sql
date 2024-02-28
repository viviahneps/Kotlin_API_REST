CREATE TABLE resposta (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    mensagem VARCHAR(255) NOT NULL,
    data_Criacao TIMESTAMP NOT NULL,
    status BOOLEAN NOT NULL,
    autor_id BIGINT NOT NULL,
    topico_id BIGINT NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES Usuario(id),
    FOREIGN KEY (topico_id) REFERENCES Topico(id)
);
