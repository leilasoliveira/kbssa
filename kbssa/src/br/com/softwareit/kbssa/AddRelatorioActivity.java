package br.com.softwareit.kbssa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class AddRelatorioActivity extends Activity {

	private RelatorioDAO dao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_relatorio);
		
		dao = new RelatorioDAO(this);
		dao.open();
		
		final EditText usernameText = (EditText) findViewById(R.id.user_name_text);
		final RatingBar intensidadeText = (RatingBar) findViewById(R.id.intensidade_text);
		final EditText comentarioText = (EditText) findViewById(R.id.comentario_text);

		Button saveButton = (Button) findViewById(R.id.add_relatorio_button);
		
		saveButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String username = usernameText.getEditableText().toString();
				String comentario = comentarioText.getEditableText().toString();
				Integer intensidade = new BigDecimal(intensidadeText.getRating()).setScale(0, RoundingMode.UP).intValue();
				Date data = new Date();
				
				dao.create(comentario, intensidade, data, username);
				
				Toast.makeText(getApplicationContext(),
				"Adicionado com sucesso!", Toast.LENGTH_SHORT).show();
				finish();
			}
		});
	}
	
	@Override
	protected void onPause() {
		dao.close();
		super.onPause();
	}
	
	@Override
	protected void onResume() {
		dao.open();
		super.onResume();
	}
	
	
}
