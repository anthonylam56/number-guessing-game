DROP DATABASE IF EXISTS mastermindDB;
CREATE DATABASE mastermindDB;
USE mastermindDB;

CREATE TABLE Game(
	gameId INT AUTO_INCREMENT,
    inProgress BOOL DEFAULT true,
    answer VARCHAR(4),
    CONSTRAINT pk_gameId PRIMARY KEY (gameId)
);

CREATE TABLE Round(
	roundId INT AUTO_INCREMENT,
    result VARCHAR(25),
    timeStamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    guess VARCHAR(7),
    gameId INT NOT NULL,
    CONSTRAINT PRIMARY KEY pk_roundId (roundId),
    CONSTRAINT FOREIGN KEY fk_gameid (gameId) REFERENCES Game (gameId)
);