package poo2.prog3.clientecontrolescolar.entidades;

public class DetalleCargaestudiante extends Cargaestudiante{
    private long year;
    private long periodo;
    private String nombreMateria;

    public DetalleCargaestudiante() {
    }

    public DetalleCargaestudiante(long idCargaProfesor) {
        super(idCargaProfesor);
    }

    public DetalleCargaestudiante(long idCargaProfesor, String rfc, String claveMateria, long idPeriodo) {
        super(idCargaProfesor, rfc, claveMateria, idPeriodo);
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

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    @Override
    public String toString() {
        return "";
    }
}
