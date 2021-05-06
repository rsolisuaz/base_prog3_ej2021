package poo2.prog3.clientecontrolescolar.entidades;


import java.io.Serializable;
import java.util.Objects;

public class Estado implements Serializable {

  private long idEstado;
  private String nombreEstado;

  public Estado() {
  }

  public Estado(long idEstado) {
    this.idEstado = idEstado;
  }

  public Estado(long idEstado, String nombreEstado) {
    this.idEstado = idEstado;
    this.nombreEstado = nombreEstado;
  }

  public long getIdEstado() {
    return idEstado;
  }

  public void setIdEstado(long idEstado) {
    this.idEstado = idEstado;
  }


  public String getNombreEstado() {
    return nombreEstado;
  }

  public void setNombreEstado(String nombreEstado) {
    this.nombreEstado = nombreEstado;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Estado estado = (Estado) o;
    return idEstado == estado.idEstado;
  }

  @Override
  public int hashCode() {
    return Objects.hash(idEstado);
  }

  @Override
  public String toString() {
    return nombreEstado;
  }
}
