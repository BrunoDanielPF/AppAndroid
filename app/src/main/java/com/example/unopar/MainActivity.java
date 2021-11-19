package com.example.unopar;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int quantidade = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void somar(View view){
        quantidade = quantidade + 1;
        displayQuantidade(quantidade);
    }

    public void subtrair(View view){
        quantidade = quantidade - 1;
        displayQuantidade(quantidade);
    }

    public void displayQuantidade(int qtd){
        TextView qtdTextView = (TextView) findViewById(R.id.quantidade);
        qtdTextView.setText("" + qtd);
    }
    public String criarMensagemPedido(String nome, int valor, boolean temBacon, boolean temQueijo, boolean temCebola){
        String mensagem = "nome: " + nome;
        mensagem += "\nBacon?" + temBacon;
        mensagem += "\nQueijo?" + temQueijo;
        mensagem += "\nCebola" + temCebola;
        mensagem += "\nQuantidade" + quantidade;
        mensagem += "\n\nTotal: R$ " + valor;
        return(mensagem);
    }
    public void enviarPedido(View view){
        EditText campoNome = (EditText) findViewById(R.id.campo_nome);
        String nome = campoNome.getText().toString();

        CheckBox checkboxBacon = (CheckBox) findViewById(R.id.Bacon);
        boolean temBacon = checkboxBacon.isChecked();

        CheckBox checkBoxQueijo = (CheckBox) findViewById(R.id.Queijo);
        boolean temQueijo = checkBoxQueijo.isChecked();

        CheckBox checkBoxCebola = (CheckBox) findViewById(R.id.Cebola);
        boolean temCebola = checkBoxCebola.isChecked();

        int valor = calculaPreco(temBacon,temCebola,temQueijo);

        String pedido = criarMensagemPedido(nome, valor,temBacon,temQueijo,temCebola);

        displayPedido(pedido);
    }
    public  void displayPedido(String pedido){
        TextView pedidoTextview = (TextView) findViewById(R.id.resumo_pedido);
        pedidoTextview.setText(pedido);
    }


    public  int calculaPreco(boolean temBacon, boolean temQueijo, boolean temCebola){
        int precoBase = 12;

        if(temBacon){
            precoBase += 2;
        }else if(temQueijo){
            precoBase += 2;
        }else if(temCebola){
            precoBase += 2;
        }
        return precoBase*quantidade;
    }

}