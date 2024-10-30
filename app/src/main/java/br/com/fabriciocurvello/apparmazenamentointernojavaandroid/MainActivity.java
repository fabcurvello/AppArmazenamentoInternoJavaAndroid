package br.com.fabriciocurvello.apparmazenamentointernojavaandroid;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_NAME = "dados.txt";
    private static final String TEXT_VIEW_STATE = "textViewState";
    private EditText etEntradaMsg;
    private TextView tvExibeMsg;
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

        etEntradaMsg = findViewById(R.id.et_entrada_msg);
        tvExibeMsg = findViewById(R.id.tv_exibe_msg);
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
        String mensagem = etEntradaMsg.getText().toString();
        try (FileOutputStream fos = openFileOutput(FILE_NAME, MODE_PRIVATE)) {
            fos.write(mensagem.getBytes());
            etEntradaMsg.setText("");
            tvExibeMsg.setText("Mensagem salva com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            tvExibeMsg.setText("Erro ao salvar a mensagem.");
        }
    }

    private void carregarDados() {
        try (FileInputStream fis = openFileInput(FILE_NAME)) {
            int size = fis.available();
            byte[] buffer = new byte[size];
            fis.read(buffer);
            String mensagem = new String(buffer);
            tvExibeMsg.setText(mensagem);
        } catch (IOException e) {
            e.printStackTrace();
            tvExibeMsg.setText("Erro ao carregar a mensagem.");
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // Salva o estado do TextView no Bundle
        outState.putString(TEXT_VIEW_STATE, tvExibeMsg.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restaura o estado do TextView após a rotação
        if (savedInstanceState != null) {
            tvExibeMsg.setText(savedInstanceState.getString(TEXT_VIEW_STATE));
        }
    }
}