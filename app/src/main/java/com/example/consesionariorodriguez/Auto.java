package com.example.consesionariorodriguez;

public class Auto {
    private String Marca;
    private String Modelo;
    private String Año;
    private String Numero_de_motor;
    private String Numero_de_chasis;

    public Auto() {
        // Constructor vacío necesario para Firestore
    }

    public Auto(String marca, String modelo, String año, String numero_de_motor, String numero_de_chasis) {
        this.Marca = marca;
        this.Modelo = modelo;
        this.Año = año;
        this.Numero_de_motor = numero_de_motor;
        this.Numero_de_chasis = numero_de_chasis;
    }

    // Getters y setters
    public String getMarca() { return Marca; }
    public void setMarca(String marca) { this.Marca = marca; }

    public String getModelo() { return Modelo; }
    public void setModelo(String modelo) { this.Modelo = modelo; }

    public String getAño() { return Año; }
    public void setAño(String año) { this.Año = año; }

    public String getNumero_de_motor() { return Numero_de_motor; }
    public void setNumero_de_motor(String numero_de_motor) { this.Numero_de_motor = numero_de_motor; }

    public String getNumero_de_chasis() { return Numero_de_chasis; }
    public void setNumero_de_chasis(String numero_de_chasis) { this.Numero_de_chasis = numero_de_chasis; }
}
