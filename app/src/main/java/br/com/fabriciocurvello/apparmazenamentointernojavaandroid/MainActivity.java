package br.com.fabriciocurvello.apparmazenamentointernojavaandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_NAME = "dados.txt";
    private EditText etEntradaTexto;
    private TextView tvExibeTexto;
    private Button btSalvar;
    private Button btCarregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etEntradaTexto = findViewById(R.id.et_entrada_texto);
        tvExibeTexto = findViewById(R.id.tv_exibe_texto);
        btSalvar = findViewById(R.id.bt_salvar);
        btCarregar = findViewById(R.id.bt_carregar);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarDados();
            }
        });

        btCarregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carregarDados();
            }
        });

    } // fim do onCreate

    private void salvarDados() {
        String texto = etEntradaTexto.getText().toString();
        try (FileOutputStream fos = openFileOutput(FILE_NAME, MODE_PRIVATE)) {
            fos.write(texto.getBytes());
            etEntradaTexto.setText("");
            tvExibeTexto.setText("Texto salvo com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            tvExibeTexto.setText("Erro ao salvar o texto");
        }
    }

    private void carregarDados() {
        try (FileInputStream fis = openFileInput(FILE_NAME)) {
            int size = fis.available();
            byte[] buffer = new byte[size];
            fis.read(buffer);
            String texto = new String(buffer);
            tvExibeTexto.setText(texto);
        } catch (IOException e) {
            e.printStackTrace();
            tvExibeTexto.setText("Erro ao carregar texto");
        }
    }
}