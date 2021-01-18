create database CabinetOphta;
use CabinetOphta;

CREATE TABLE doctor (
    username VARCHAR(15) PRIMARY KEY,
    userkey VARCHAR(30),
    nom VARCHAR(30) NOT NULL,
    prenom VARCHAR(30) NOT NULL
);

CREATE TABLE secretaire (
    username VARCHAR(15) PRIMARY KEY,
    userkey VARCHAR(30) NOT NULL
);

CREATE TABLE dossier (
    num_dossier BIGINT PRIMARY KEY,
    date_creation DATE
);

CREATE TABLE patient (
    num_patient BIGINT PRIMARY KEY AUTO_INCREMENT,
    CIN VARCHAR(15) UNIQUE,
    nom VARCHAR(30) NOT NULL,
    prenom VARCHAR(30) NOT NULL,
    sexe VARCHAR(15),
    date_naissance DATE,
    adresse TEXT(100),
    tel VARCHAR(15),
    num_dossier BIGINT NOT NULL UNIQUE,
    CONSTRAINT patient_dossier_fk
        FOREIGN KEY(num_dossier) 
        REFERENCES dossier(num_dossier)
        ON DELETE CASCADE

);

CREATE TABLE RDV (
    num_rdv BIGINT PRIMARY KEY,
    nom_pat VARCHAR(60),
    num_pat BIGINT,
    date_rdv DATE,
    heur_rdv TIMESTAMP,
    date_resevation DATE,
    CONSTRAINT rdv_patient_fk
        FOREIGN KEY(num_pat) 
        REFERENCES patient(num_patient)
);

CREATE TABLE visite (
    num_visite BIGINT PRIMARY KEY,
    num_dossier BIGINT NOT NULL,
    date_visite DATE,
    prescription TEXT,
    symptome TEXT,
    medecine TEXT,
    remede TEXT,
    paiement DOUBLE,
    CONSTRAINT visite_dossier_fk
        FOREIGN KEY(num_dossier) 
        REFERENCES dossier(num_dossier) 
        ON DELETE CASCADE
);
