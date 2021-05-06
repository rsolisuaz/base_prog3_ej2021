package poo2.prog3.clientecontrolescolar.entidades;


import java.io.Serializable;
import java.util.Objects;

public class Carrera implements Serializable {

  private String claveCarrera;
  private String nombreCarrera;

  public Carrera() {
  }

  public Carrera(String claveCarrera) {
    this.claveCarrera = claveCarrera;
  }

  public Carrera(String claveCarrera, String nombreCarrera) {
    this.claveCarrera = claveCarrera;
    this.nombreCarrera = nombreCarrera;
  }

  public String getClaveCarrera() {
    return claveCarrera;
  }

  public void setClaveCarrera(String claveCarrera) {
    this.claveCarrera = claveCarrera;
  }


  public String getNombreCarrera() {
    return nombreCarrera;
  }

  public void setNombreCarrera(String nombreCarrera) {
    this.nombreCarrera = nombreCarrera;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Carrera carrera = (Carrera) o;
    return claveCarrera.equals(carrera.claveCarrera);
  }

  @Override
  public int hashCode() {
    return Objects.hash(claveCarrera);
  }

  @Override
  public String toString() {
    return nombreCarrera;
  }
}
