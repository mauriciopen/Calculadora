/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;


public class Carrera {
    private ArrayList<Materia> materias;
    private double avance;
    private double  ponderado;
    private double cantidadCreditos;
    private double creditosCursados;
    
    public Carrera(){
        materias = new ArrayList<>();
        avance=0;
        ponderado=0;
        cantidadCreditos=0;
        creditosCursados=0;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<Materia> semestres) {
        this.materias = semestres;
    }

    public double getAvance() {
        return avance;
    }

    public void setAvance(double avance) {
        this.avance = avance;
    }

    public double getPonderado() {
        return ponderado;
    }

    public void setPonderado(double ponderado) {
        this.ponderado = ponderado;
    }

    public double getCantidadCreditos() {
        return cantidadCreditos;
    }

    public void setCantidadCreditos(int cantidadCreditos) {
        this.cantidadCreditos = cantidadCreditos;
    }

    public double getCreditosCursados() {
        return creditosCursados;
    }

    public void setCreditosCursados(int creditosCursados) {
        this.creditosCursados = creditosCursados;
    }
    
    public void calcularAvance(){
        avance = (creditosCursados*100)/cantidadCreditos;
    }
    
    public void obtenerCursados() {
        int suma = 0;
        for (int i = 0; i < materias.size(); i++) {
            suma = suma + materias.get(i).getCreditos();
        }
        creditosCursados = suma;
    }
    
    public void ponderadoAcumulado() {
        double suma = 0;
        for (int i = 0; i < materias.size(); i++) {
            suma = suma + (materias.get(i).getNota() * materias.get(i).getCreditos());
        }
        ponderado = (double) (suma / creditosCursados);
    }
}
