package br.com.softwareit.kbssa;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddConfigsActivity extends Activity {
	
	private SharedPreferences prefs;
	
	final static String APP_PREFS = "app_prefs";
	final static String EMAIL_USUARIO = "email_usuario";
	final static String NOME_MEDICO = "nome_medico";
	final static String EMAIL_MEDICO = "email_medico";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.configs);
	
		prefs = getSharedPreferences(APP_PREFS, MODE_PRIVATE);
		
		final EditText email_usuario_text = (EditText) findViewById(R.id.email_text);
		final EditText nome_medico_text = (EditText) findViewById(R.id.nome_medico_text);
		final EditText email_medico_text = (EditText) findViewById(R.id.email_medico_text);
		
		Button saveButton = (Button) findViewById(R.id.salvar_button);
		
		saveButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String email_usuario = email_usuario_text.getEditableText().toString();
				String nome_medico = nome_medico_text.getEditableText().toString();
				String email_medico = email_medico_text.getEditableText().toString();
				
				Editor editor = prefs.edit();
				editor.putString(EMAIL_USUARIO, email_usuario);
				editor.putString(NOME_MEDICO, nome_medico);
				editor.putString(EMAIL_MEDICO, email_medico);
				editor.commit();
				
				Toast.makeText(getApplicationContext(),
						"Adicionado com sucesso!", Toast.LENGTH_SHORT).show();
						finish();
				
				finish();
			}
		});
	}
	
}
