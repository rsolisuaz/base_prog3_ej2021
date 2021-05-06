package poo2.prog3.clientecontrolescolar.entidades;


import java.io.Serializable;
import java.util.Objects;

public class Estudiante implements Serializable {

  private String matricula;
  private String nombre;
  private String apPaterno;
  private String apMaterno;
  private String calle;
  private String colonia;
  private String codPostal;
  private String telefono;
  private String email;
  private long idEstado;
  private long idMunicipio;

  public Estudiante() {
  }

  public Estudiante(String matricula) {
    this.matricula = matricula;
  }

  public Estudiante(String matricula, String nombre, String apPaterno, String email) {
    this.matricula = matricula;
    this.nombre = nombre;
    this.apPaterno = apPaterno;
    this.email = email;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }


  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }


  public String getApPaterno() {
    return apPaterno;
  }

  public void setApPaterno(String apPaterno) {
    this.apPaterno = apPaterno;
  }


  public String getApMaterno() {
    return apMaterno;
  }

  public void setApMaterno(String apMaterno) {
    this.apMaterno = apMaterno;
  }


  public String getCalle() {
    return calle;
  }

  public void setCalle(String calle) {
    this.calle = calle;
  }


  public String getColonia() {
    return colonia;
  }

  public void setColonia(String colonia) {
    this.colonia = colonia;
  }


  public String getCodPostal() {
    return codPostal;
  }

  public void setCodPostal(String codPostal) {
    this.codPostal = codPostal;
  }


  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public long getIdEstado() {
    return idEstado;
  }

  public void setIdEstado(long idEstado) {
    this.idEstado = idEstado;
  }


  public long getIdMunicipio() {
    return idMunicipio;
  }

  public void setIdMunicipio(long idMunicipio) {
    this.idMunicipio = idMunicipio;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Estudiante that = (Estudiante) o;
    return matricula.equals(that.matricula);
  }

  @Override
  public int hashCode() {
    return Objects.hash(matricula);
  }

  @Override
  public String toString() {
    StringBuilder nomCompleto= new StringBuilder(nombre);
    nomCompleto.append(' ');
    nomCompleto.append(apPaterno);
    if (apMaterno!=null && apMaterno.length()>0) {
      nomCompleto.append(' ');
      nomCompleto.append(apMaterno);
    }
    return nomCompleto.toString();
  }
}
