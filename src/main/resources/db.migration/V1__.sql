-- Tabela para a classe Jogador
CREATE TABLE Jogadores (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255),
    dataNascimento VARCHAR(10)
);

-- Tabela para a classe Mapa
CREATE TABLE Mapas (
    idMapa BIGINT PRIMARY KEY,
    nomeMapa VARCHAR(255),
    anoMapa VARCHAR(4)
);

-- Tabela para a classe Skin
CREATE TABLE Skins (
    idSkin BIGINT PRIMARY KEY,
    nomeSkin VARCHAR(255),
    precoSkin DOUBLE
);

-- Tabela de associação jogador-skin (ManyToMany)
CREATE TABLE jogador_skin (
    jogador_id BIGINT,
    skin_id BIGINT,
    PRIMARY KEY (jogador_id, skin_id),
    FOREIGN KEY (jogador_id) REFERENCES Jogadores (id),
    FOREIGN KEY (skin_id) REFERENCES Skins (idSkin)
);

-- Tabela de associação jogador-mapa (ManyToMany)
CREATE TABLE jogador_mapa (
    jogador_id BIGINT,
    mapa_id BIGINT,
    PRIMARY KEY (jogador_id, mapa_id),
    FOREIGN KEY (jogador_id) REFERENCES Jogadores (id),
    FOREIGN KEY (mapa_id) REFERENCES Mapas (idMapa)
);
