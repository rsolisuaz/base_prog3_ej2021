package poo2.prog3.clientecontrolescolar.clientes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import poo2.prog3.clientecontrolescolar.entidades.*;
import poo2.prog3.clientecontrolescolar.interfaces.DaoEscolares;
import poo2.prog3.clientecontrolescolar.utils.HttpUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class DaoEscolaresImpl implements DaoEscolares {
    private final String urlBase;
    private final String pathMateria = "materia/";
    private final String pathCarrera = "carrera/";
    private final String pathEstudiante = "estudiante/";
    private final String pathEstado = "estado/";
    private final String pathMunicipio = "municipio/";


    public DaoEscolaresImpl(String urlBase) {
        this.urlBase = urlBase;
    }
    @Override
    public List<Estado> obtenEstados() throws IOException {
        // TODO
        return null;
    }

    @Override
    public List<Municipio> obtenMunicipios(long idEstado) throws IOException {
        // TODO Para puntos extra
        return null;
    }

    @Override
    public List<Carrera> obtenCarreras() throws IOException {
        // TODO
        return null;
    }

    @Override
    public boolean agregaCarrera(Carrera c) throws IOException {
        return false;
    }

    @Override
    public boolean modificaCarrera(Carrera c) throws IOException {
        return false;
    }

    @Override
    public boolean eliminaCarrera(String clave) throws IOException {
        return false;
    }

    @Override
    public List<Materia> obtenMaterias() throws IOException {
        // TODO
        return null;
    }

    @Override
    public boolean agregaMateria(Materia m) throws IOException {
        // TODO
        return false;
    }

    @Override
    public boolean modificaMateria(Materia m) throws IOException {
        // TODO
        return false;
    }

    @Override
    public boolean eliminaMateria(String clave) throws IOException {
        // TODO
        return false;
    }

    @Override
    public List<Periodoescolar> obtenPeriodos() throws IOException {
        return null;
    }

    @Override
    public boolean agregaPeriodo(Periodoescolar p) throws IOException {
        return false;
    }

    @Override
    public boolean modificaPeriodo(Periodoescolar p) throws IOException {
        return false;
    }

    @Override
    public boolean eliminaPeriodo(long id) throws IOException {
        return false;
    }

    @Override
    public List<Profesor> obtenProfesores() throws IOException {
        return null;
    }

    @Override
    public boolean agregaProfesor(Profesor p) throws IOException {
        return false;
    }

    @Override
    public boolean modificaProfesor(Profesor p) throws IOException {
        return false;
    }

    @Override
    public boolean eliminaProfesor(String rfc) throws IOException {
        return false;
    }

    @Override
    public List<DetalleCargaprofesor> obtenCargaProfesor(String rfc) throws IOException {
        return null;
    }

    @Override
    public boolean agregaCargaProfesor(Cargaprofesor c) throws IOException {
        return false;
    }

    @Override
    public boolean eliminaCargaProfesor(long idCarga) throws IOException {
        return false;
    }

    @Override
    public List<Estudiante> obtenEstudiantes() throws IOException {
        // TODO
        return null;
    }

    @Override
    public boolean agregaEstudiante(Estudiante e) throws IOException {
        // TODO
        return false;
    }

    @Override
    public boolean modificaEstudiante(Estudiante e) throws IOException {
        // TODO
        return false;
    }

    @Override
    public boolean eliminaEstudiante(String matricula) throws IOException {
        // TODO
        return false;
    }

    @Override
    public List<DetalleCargaestudiante> obtenCargaEstudiante(String matricula) throws IOException {
        return null;
    }

    @Override
    public boolean agregaCargaEstudiante(Cargaestudiante c) throws IOException {
        return false;
    }

    @Override
    public boolean eliminaCargaEstudiante(long idCarga) throws IOException {
        return false;
    }
}
