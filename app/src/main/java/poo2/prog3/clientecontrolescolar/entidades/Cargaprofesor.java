package poo2.prog3.clientecontrolescolar.entidades;


import java.io.Serializable;
import java.util.Objects;

public class Cargaprofesor implements Serializable  {

  private long idCargaProfesor;
  private String rfc;
  private String claveMateria;
  private long idPeriodo;

  public Cargaprofesor() {
  }

  public Cargaprofesor(long idCargaProfesor) {
    this.idCargaProfesor = idCargaProfesor;
  }

  public Cargaprofesor(long idCargaProfesor, String rfc, String claveMateria, long idPeriodo) {
    this.idCargaProfesor = idCargaProfesor;
    this.rfc = rfc;
    this.claveMateria = claveMateria;
    this.idPeriodo = idPeriodo;
  }

  public long getIdCargaProfesor() {
    return idCargaProfesor;
  }

  public void setIdCargaProfesor(long idCargaProfesor) {
    this.idCargaProfesor = idCargaProfesor;
  }


  public String getRfc() {
    return rfc;
  }

  public void setRfc(String rfc) {
    this.rfc = rfc;
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
    Cargaprofesor that = (Cargaprofesor) o;
    return idCargaProfesor == that.idCargaProfesor;
  }

  @Override
  public int hashCode() {
    return Objects.hash(idCargaProfesor);
  }
}
