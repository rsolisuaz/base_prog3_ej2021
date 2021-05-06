package poo2.prog3.clientecontrolescolar;

import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.JsonParseException;
import poo2.prog3.clientecontrolescolar.clientes.DaoEscolaresImpl;
import poo2.prog3.clientecontrolescolar.entidades.Carrera;
import poo2.prog3.clientecontrolescolar.entidades.Materia;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class DetalleMateriaActivity extends AppCompatActivity {
    private FloatingActionButton mFabElimina;
    private FloatingActionButton mFabModifica;
    private FloatingActionButton mFabGuarda;
    private DaoEscolaresImpl mDao;
    private Materia mItem;
    private boolean mEsNueva;
    private boolean mCamposActivos;
    private AlertDialog mDialogoConfirmacionEliminar;
    private AlertDialog mDialogoConfirmacionGuardar;
    private View mLayout;
    private EditText mEditClaveMateria;
    private EditText mEditNombreMateria;
    private EditText mEditSemestreMateria;
    private Spinner mSpinnerCarreraMateria;
    private ProgressBar progressBar;
    private ArrayList<View> mCampos;
    private List<Carrera> mDatosCarreras;

    private final static int MAXLENGTH_NOM=50;
    private final static int MAXLENGTH_CLAVE=10;
    private final static int MAX_SEMESTRE=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_materia);
        mDao = new DaoEscolaresImpl(getString(R.string.url_base));

        progressBar=findViewById(R.id.progressBar);
        //progressBar.setVisibility(View.GONE);

        mCampos =new ArrayList<>();
        mLayout = findViewById(R.id.container_materia_detalle);

        CollapsingToolbarLayout collLayout=findViewById(R.id.toolbar_layout);
        collLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
        int margen =collLayout.getExpandedTitleMarginStart();
        collLayout.setExpandedTitleMarginStart(margen+getResources().getDimensionPixelSize(R.dimen.text_margin));
        collLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);

        Toolbar toolbar = findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        // Muestra el boton de regreso en la  action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mFabElimina = findViewById(R.id.fab_elimina_materia);
        mFabElimina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialogoConfirmacionEliminar.show();
            }
        });

        mFabModifica = findViewById(R.id.fab_modifica_materia);
        mFabModifica.setOnClickListener(view -> {
            habilitaCampos(!mCamposActivos);
            mEditClaveMateria.setEnabled(false);

            if (mCamposActivos) {
                mFabModifica.setImageResource(R.drawable.mi_ic_lock);
                mFabGuarda.setVisibility(View.VISIBLE);
            }
            else {
                mFabModifica.setImageResource(R.drawable.mi_ic_lock_open);
                mFabGuarda.setVisibility(View.GONE);
            }
        });
        mFabGuarda = findViewById(R.id.fab_guarda_materia);
        mFabGuarda.setOnClickListener(view -> guardaInformacion());

        mEditClaveMateria = findViewById(R.id.edit_clave_materia); mCampos.add(mEditClaveMateria);
        mEditNombreMateria = findViewById(R.id.edit_nombre_carrera); mCampos.add(mEditNombreMateria);
        mEditSemestreMateria = findViewById(R.id.edit_semestre); mCampos.add(mEditSemestreMateria);
        mSpinnerCarreraMateria = findViewById(R.id.spinner_carrera); mCampos.add(mSpinnerCarreraMateria);
        obtenDetalles();
        creaDialogoConfirmacionEliminacion();
        creaDialogoConfirmacionGuardar();
    }

    /**
     * Este metodo obtiene la informacion que viene en el Intent usado para llamar a esta Activity
     * e inicializa los campos de texto con tal informacion
     */
    private void obtenDetalles() {
        Intent intent=getIntent();
        mItem = (Materia) intent.getSerializableExtra("materia");

        if (mItem==null) {
            mFabElimina.setVisibility(View.GONE);
            mFabModifica.setVisibility(View.GONE);
            mEsNueva=true;
        }
        else {
            mFabGuarda.setVisibility(View.GONE);
            habilitaCampos(false);
            mEditClaveMateria.setText(mItem.getClaveMateria());
            mEditNombreMateria.setText(mItem.getNombreMateria());
            mEditSemestreMateria.setText(Long.toString(mItem.getSemestre()));
            mEsNueva=false;
        }

        // TODO
        // Crear un hilo para descargar la lista de carreras
    }

    /**
     * Este metodo habilita/deshabilita los campos
     * @param flag true si se desea habilitar, false de lo contrario
     */
    private void habilitaCampos(boolean flag) {
        for (View et : mCampos) {
            et.setEnabled(flag);
        }
        mCamposActivos=flag;
    }

    /**
     * Este metodo toma los datos de las cajas de texto, y si son validos
     * solicita al servicio que se actualice o agregue
     */
    private void guardaInformacion() {
        String claveMat= mEditClaveMateria.getText().toString();
        String nomMat= mEditNombreMateria.getText().toString();
        String semestreTexto= mEditSemestreMateria.getText().toString();
        int semestre = -1;
        try {
            semestre=Integer.parseInt(semestreTexto);
        }
        catch (NumberFormatException ex) {
        }
        if (claveMat.isEmpty() || nomMat.isEmpty() || semestre<1 ||
                semestre>MAX_SEMESTRE || claveMat.length()>MAXLENGTH_CLAVE ||
                nomMat.length()>MAXLENGTH_NOM ) {
            muestraMensaje(R.string.mensaje_error_campos);
            return;
        }
        if (mItem==null) {
            mItem=new Materia();
        }
        mItem.setClaveMateria(claveMat);
        mItem.setNombreMateria(nomMat);
        mItem.setSemestre(semestre);
        Carrera c = (Carrera) mSpinnerCarreraMateria.getSelectedItem();
        // TODO Descomente la siguiente linea una vez que tenga el
        // codigo para llenar el spinner
        //mItem.setClaveCarrera(c.getClaveCarrera());
        mDialogoConfirmacionGuardar.show();
    }

    /**
     * Metodo que crea un Intent para enviar datos de regreso a la activity que llamo a esta
     * Los datos estaran en un Bundle dentro del intent indicando que operacion se hizo
     * y los datos de la materia (a usarse si la operacion fue agregar una nueva o actualizar una existente)
     *
     * @param codigo  Codigo que representa la operacion realizada (actualizacion o eliminacion)
     */
    private void regresaDatos(int codigo) {
        Intent datos = new Intent();
        Bundle info = new Bundle();
        info.putInt("operacion", codigo);
        info.putSerializable("materia", mItem);
        datos.putExtras(info);
        setResult(RESULT_OK, datos);
        finish();
    }

    /**
     * Metodo para crear un cuadro de dialogo de confirmacion de eliminacion
     */
    private void creaDialogoConfirmacionEliminacion() {
        // Se crea un constructor de cuadros de dialogo
        AlertDialog.Builder constructor = new AlertDialog.Builder(this, R.style.CustomDialogTheme);
        // Se establece el titulo del cuadro de dialogo
        constructor.setTitle(R.string.titulo_confirmacion_eliminar);
        // Se estable el mensaje del cuadro de dialogo
        constructor.setMessage(R.string.mensaje_confirmacion_eliminar);

        // Se establece el texto del boton de aceptacion asi como el manejador
        constructor.setPositiveButton(R.string.titulo_opcion_si, new ManejadorConfirmacion(ListMateriaActivity.OPERACION_ELIMINACION));
        // Se establece el texto del boton de cancelacio  asi como el manejador
        constructor.setNegativeButton(R.string.titulo_opcion_no, null);
        // Se crea el cuadro de dialogo
        mDialogoConfirmacionEliminar = constructor.create();
    }

    /**
     * Metodo para crear un cuadro de dialogo de confirmacion de guardar cambios
     */
    private void creaDialogoConfirmacionGuardar() {
        // Se crea un constructor de cuadros de dialogo
        AlertDialog.Builder constructor = new AlertDialog.Builder(this, R.style.CustomDialogTheme);
        // Se establece el titulo del cuadro de dialogo
        constructor.setTitle(R.string.titulo_confirmacion_guardar);
        // Se estable el mensaje del cuadro de dialogo
        constructor.setMessage(R.string.mensaje_confirmacion_guardar);

        // Se establece el texto del boton de aceptacion asi como el manejador
        constructor.setPositiveButton(R.string.titulo_opcion_si, new ManejadorConfirmacion(ListMateriaActivity.OPERACION_ACTUALIZACION));
        // Se establece el texto del boton de cancelacio  asi como el manejador
        constructor.setNegativeButton(R.string.titulo_opcion_no, null);
        // Se crea el cuadro de dialogo
        mDialogoConfirmacionGuardar = constructor.create();
    }

    /**
     * Metodo que muestra un mensaje temporal en la pantalla cuyo texto esta en
     * algun archivo XML de res/values
     *
     * @param idMensaje   ID del string a mostrar
     */
    private void muestraMensaje(int idMensaje) {
        final Snackbar snack=Snackbar.make(mLayout,idMensaje,Snackbar.LENGTH_LONG).
                setAction(R.string.texto_cerrar, v -> {
                    // No necesitamos hacer nada, solo que se cierre
                });
        snack.show();
    }

    /**
     * Manejador de la opcion de SI en el cuadro de confirmacion
     *
     */
    private class ManejadorConfirmacion implements DialogInterface.OnClickListener {
        private final int operacion;

        public ManejadorConfirmacion(int operacion) {
            this.operacion = operacion;
        }

        @Override
        public void onClick(DialogInterface dialog, int which) {
            progressBar.setVisibility(View.VISIBLE);
            // Falta trabajo para comunicarse con el servicio REST (con ayuda de hilos)
            // para solicitar hacer la operacion indicado por el atributo operacion
            // TODO
        }
    }

    // HACER CLASES PARA REPRESENTAR HILOS.
    // EL PRIMERO SE COMUNICARA CON EL SERVICIO REST PARA OBTENER INFORMACION.
    // EL SEGUNDO MOSTRARA EL RESULTADO EN LA GUI
    // NOTE QUE NECESITA UN PAR DE HILOS PARA BAJAR LA LISTA DE CARRERAS
    // Y OTRO PARA PARA AGREGAR, MODIFICAR O ELIMINAR LA MATERIA
    // TODO

}