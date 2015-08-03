package br.com.softwareit.kbssa;

import java.text.SimpleDateFormat;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
	
	private RelatorioDAO dao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlite);
	
		dao = new RelatorioDAO(this);
		dao.open();
	}
	
	@Override
	protected void onResume() {
		dao.open();
		super.onResume();
		
		List<Relatorio> relatorios = dao.getAll();
		
		final ArrayAdapter<Relatorio> adapter = new ArrayAdapter<Relatorio>(this, android.R.layout.simple_list_item_1, relatorios);
		setListAdapter(adapter);
		
		final ListView listView = getListView();
		listView.setTextFilterEnabled(true);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@SuppressLint("SimpleDateFormat")
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Relatorio relatorio = (Relatorio) listView.getItemAtPosition(position);
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				
				StringBuilder sb = new StringBuilder("Item: " + (position + 1) + "\n");
				sb.append("Nome: " + relatorio.getUsername() + "\n");
				sb.append("Data: " + sdf.format(relatorio.getDataHora()) + "\n");
				sb.append("Intensidade da dor: " + relatorio.getIntensidade() + "\n");
				sb.append("Como estava se sentindo: " + relatorio.getComentario());
				
				Toast.makeText(getApplicationContext(),
				sb.toString(), Toast.LENGTH_SHORT).show();
			}
		});
 
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
		        adb.setTitle("Excluir relatório?");
		        adb.setMessage("Tem certeza que deseja excluir o registro nº " + (position + 1));
		        final Relatorio relatorio = (Relatorio) listView.getItemAtPosition(position);
		        
		        adb.setNegativeButton("Não", null);
		        adb.setPositiveButton("Sim", new AlertDialog.OnClickListener() {
		            public void onClick(DialogInterface dialog, int which) {
		            	
						dao.delete(relatorio);
						adapter.remove(relatorio);
					    adapter.notifyDataSetChanged();
						
						// When long clicked, show a toast with the TextView text
					    Toast.makeText(getApplicationContext(),
						"Removido com sucesso!", Toast.LENGTH_SHORT).show();
		            }});
		        adb.show();
			    
				return false;
			}
		});
	}
	
	@Override
	protected void onPause() {
		dao.close();
		super.onPause();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId() == R.id.add_relatorio){
			Intent intent = new Intent(this, AddRelatorioActivity.class);
			startActivity(intent);
		}else if(item.getItemId() == R.id.add_config){
			Intent intent = new Intent(this, AddConfigsActivity.class);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}
	
}
