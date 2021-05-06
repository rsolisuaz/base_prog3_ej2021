package poo2.prog3.clientecontrolescolar.entidades;


import java.io.Serializable;
import java.util.Objects;

public class Materia implements Serializable {

  private String claveMateria;
  private String nombreMateria;
  private long semestre;
  private String claveCarrera;

  public Materia() {
  }

  public Materia(String claveMateria) {
    this.claveMateria = claveMateria;
  }

  public Materia(String claveMateria, String nombreMateria, long semestre, String claveCarrera) {
    this.claveMateria = claveMateria;
    this.nombreMateria = nombreMateria;
    this.semestre = semestre;
    this.claveCarrera = claveCarrera;
  }

  public String getClaveMateria() {
    return claveMateria;
  }

  public void setClaveMateria(String claveMateria) {
    this.claveMateria = claveMateria;
  }


  public String getNombreMateria() {
    return nombreMateria;
  }

  public void setNombreMateria(String nombreMateria) {
    this.nombreMateria = nombreMateria;
  }


  public long getSemestre() {
    return semestre;
  }

  public void setSemestre(long semestre) {
    this.semestre = semestre;
  }


  public String getClaveCarrera() {
    return claveCarrera;
  }

  public void setClaveCarrera(String claveCarrera) {
    this.claveCarrera = claveCarrera;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Materia materia = (Materia) o;
    return claveMateria.equals(materia.claveMateria);
  }

  @Override
  public int hashCode() {
    return Objects.hash(claveMateria);
  }

  @Override
  public String toString() {
    return nombreMateria ;
  }
}
