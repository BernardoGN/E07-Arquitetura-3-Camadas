package br.ufmg.coltec.tp.appacademico.UI;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.ufmg.coltec.tp.appacademico.Negocio.Aluno;
import br.ufmg.coltec.tp.appacademico.Negocio.FachadaAluno;
import br.ufmg.coltec.tp.appacademico.Negocio.IFachadaAluno;
import br.ufmg.coltec.tp.appacademico.R;

public class InserirAlunoActivity extends Activity {

    private IFachadaAluno fachadaAluno = new FachadaAluno(InserirAlunoActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_aluno);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        final EditText nome = findViewById(R.id.txt_nomeAluno);
        final EditText curso = findViewById(R.id.txt_cursoAluno);
        final EditText matricula = findViewById(R.id.txt_matriculaAluno);
        final EditText endereco = findViewById(R.id.txt_enderecoAluno);

        Button inserir = findViewById(R.id.btn_inserirAluno);

        inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strNome = nome.getText().toString();
                String strCurso = curso.getText().toString();
                String strMatricula = matricula.getText().toString();
                String strEndereco = endereco.getText().toString();
                if (!strNome.equals("") && !strCurso.equals("") && !strMatricula.equals("") && !strEndereco.equals("")) {
                    Aluno aluno = new Aluno(nome.getText().toString(),
                            curso.getText().toString(),
                            Long.parseLong(matricula.getText().toString()),
                            endereco.getText().toString());

                    fachadaAluno.inserirAluno(aluno);
                    Toast.makeText(InserirAlunoActivity.this, "Aluno inserido com sucesso", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(InserirAlunoActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
