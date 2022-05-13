package leticia.segundotrabalho_leticiavitoria;

// Letícia Castelo e Vitória Hilgert


import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private TextView lblTexto1;
    private TextView lblTexto2;
    private TextView txtTexto1;
    private TextView txtTexto2;
    private Button btnGravaTxt1;
    private Button btnGravaTxt2;
    private RadioGroup radioGroup;
    private RadioButton rad1;
    private RadioButton rad2;
    private TextView txtTam;
    private Button btnGravaTam;
    private Button btnRed;
    private Button btnGreen;
    private Button btnBlue;
    private CheckBox chkBold;
    private CheckBox chkItalic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblTexto1 = findViewById(R.id.lblTexto1);
        lblTexto2 = findViewById(R.id.lblTexto2);
        txtTexto1 = findViewById(R.id.txtTexto1);
        txtTexto2 = findViewById(R.id.txtTexto2);
        txtTam = findViewById(R.id.txtTam);
        btnGravaTxt1 = findViewById(R.id.btnGravaTxt1);
        btnGravaTxt2 = findViewById(R.id.btnGravaTxt2);
        radioGroup = findViewById(R.id.radioGroup);
        rad1 = findViewById(R.id.rad1);
        rad2 = findViewById(R.id.rad2);
        btnGravaTam = findViewById(R.id.btnGravaTam);
        btnRed = findViewById(R.id.btnRed);
        btnBlue = findViewById(R.id.btnBlue);
        btnGreen = findViewById(R.id.btnGreen);
        chkBold = findViewById(R.id.chkBold);
        chkItalic = findViewById(R.id.chkItalic);
        btnGravaTxt1.setOnClickListener(new EscutadorBotao1());
        btnGravaTxt2.setOnClickListener(new EscutadorBotao1());
        btnGravaTam.setOnClickListener(new EscutadorGravaTam());
        btnRed.setOnClickListener(new EscutadorGravaCor());
        btnGreen.setOnClickListener(new EscutadorGravaCor());
        btnBlue.setOnClickListener(new EscutadorGravaCor());
        EscutadorCheckBox echk = new EscutadorCheckBox();
        chkBold.setOnClickListener(echk);
        chkItalic.setOnClickListener(echk);
        radioGroup.setOnCheckedChangeListener(new EscutadorRadioGroup());
    }
    class EscutadorBotao1 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Button b = (Button) view;
            int id_btn = b.getId();
            if (id_btn == R.id.btnGravaTxt1) {
                String texto = txtTexto1.getText().toString();
                lblTexto1.setText(texto);
            } else {
                String texto = txtTexto2.getText().toString();
                lblTexto2.setText(texto);
            }
        }
    }
    class EscutadorGravaCor implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Button b = (Button) view;
            int id_btn = b.getId();
            int cor = 0;
            if (id_btn == R.id.btnRed) {
                cor = Color.RED;
            } else if (id_btn == R.id.btnBlue) {
                cor = Color.BLUE;
            } if (id_btn == R.id.btnGreen) {
                cor = Color.GREEN;
            }
            if (rad1.isChecked()) {
                lblTexto1.setTextColor(cor);
            } else if (rad2.isChecked()) {
                lblTexto2.setTextColor(cor);
            } else {
                Toast.makeText(getApplicationContext(), "nenhum texto selecionado", Toast.LENGTH_SHORT).show();
            }
        }
    }
    class EscutadorGravaTam implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (rad1.isChecked() || rad2.isChecked()) {
                String tam_aux = txtTam.getText().toString();
                float tam = Float.parseFloat(tam_aux);
                if (rad1.isChecked()) {
                    lblTexto1.setTextSize(tam);
                } else if (rad2.isChecked()) {
                    lblTexto2.setTextSize(tam);
                }
            } else {
                Toast.makeText(getApplicationContext(), "nenhum texto selecionado", Toast.LENGTH_SHORT).show();
            }
        }
    }
    class EscutadorCheckBox implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int estilo = 0;
            if (chkBold.isChecked() && chkItalic.isChecked() == false) {
                estilo = Typeface.BOLD;
            } else if (chkBold.isChecked() == false && chkItalic.isChecked()) {
                estilo = Typeface.ITALIC;
            } else if (chkBold.isChecked() && chkItalic.isChecked()) {
                estilo = Typeface.BOLD_ITALIC;
            }
            if (rad1.isChecked()) {
                lblTexto1.setTypeface(null, estilo);
            } else if (rad2.isChecked()) {
                lblTexto2.setTypeface(null, estilo);
            } else {
                Toast.makeText(getApplicationContext(), "nenhum texto selecionado", Toast.LENGTH_SHORT).show();
            }
        }
    }
    class EscutadorRadioGroup implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            int estilo = 0;
            switch (i) {
                case R.id.rad1:
                    estilo = lblTexto2.getTypeface().getStyle();
                    lblTexto1.setTypeface(null, estilo);
                    break;
                case R.id.rad2:
                    estilo = lblTexto1.getTypeface().getStyle();
                    lblTexto2.setTypeface(null, estilo);
                    break;
            }
        }
    }
}