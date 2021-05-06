package poo2.prog3.clientecontrolescolar.entidades;


import java.io.Serializable;
import java.util.Objects;

public class Periodoescolar implements Serializable {

  private long idPeriodo;
  private long year;
  private long periodo;

  public Periodoescolar() {
  }

  public Periodoescolar(long idPeriodo) {
    this.idPeriodo = idPeriodo;
  }

  public Periodoescolar(long idPeriodo, long year, long periodo) {
    this.idPeriodo = idPeriodo;
    this.year = year;
    this.periodo = periodo;
  }

  public long getIdPeriodo() {
    return idPeriodo;
  }

  public void setIdPeriodo(long idPeriodo) {
    this.idPeriodo = idPeriodo;
  }


  public long getYear() {
    return year;
  }

  public void setYear(long year) {
    this.year = year;
  }


  public long getPeriodo() {
    return periodo;
  }

  public void setPeriodo(long periodo) {
    this.periodo = periodo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Periodoescolar that = (Periodoescolar) o;
    return idPeriodo == that.idPeriodo;
  }

  @Override
  public int hashCode() {
    return Objects.hash(idPeriodo);
  }

  @Override
  public String toString() {
    return "";
  }
}
