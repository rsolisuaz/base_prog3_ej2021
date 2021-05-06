package poo2.prog3.clientecontrolescolar.entidades;


import java.io.Serializable;
import java.util.Objects;

public class Cargaestudiante implements Serializable {

  private long idCargaEstudiante;
  private String matricula;
  private String claveMateria;
  private long idPeriodo;

  public Cargaestudiante() {
  }

  public Cargaestudiante(long idCargaEstudiante) {
    this.idCargaEstudiante = idCargaEstudiante;
  }

  public Cargaestudiante(long idCargaEstudiante, String matricula, String claveMateria, long idPeriodo) {
    this.idCargaEstudiante = idCargaEstudiante;
    this.matricula = matricula;
    this.claveMateria = claveMateria;
    this.idPeriodo = idPeriodo;
  }

  public long getIdCargaEstudiante() {
    return idCargaEstudiante;
  }

  public void setIdCargaEstudiante(long idCargaEstudiante) {
    this.idCargaEstudiante = idCargaEstudiante;
  }


  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }


  public String getClaveMateria() {
    return claveMateria;
  }

  public void setClaveMateria(String claveMateria) {
    this.claveMateria = claveMateria;
  }


  public long getIdPeriodo() {
    return idPeriodo;
  }

  public void setIdPeriodo(long idPeriodo) {
    this.idPeriodo = idPeriodo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Cargaestudiante that = (Cargaestudiante) o;
    return idCargaEstudiante == that.idCargaEstudiante;
  }

  @Override
  public int hashCode() {
    return Objects.hash(idCargaEstudiante);
  }
}
