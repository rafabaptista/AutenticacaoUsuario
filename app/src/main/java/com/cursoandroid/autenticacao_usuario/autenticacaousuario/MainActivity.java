package com.cursoandroid.autenticacao_usuario.autenticacaousuario;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

        //verificar se está logado
        if (auth.getCurrentUser() != null) {
            Log.i("loggedInUser", "Usuario logado!!");
        } else {
            Log.i("loggedInUser", "Usuario não logado!!");
        }


        //Login do usuário
        auth.signInWithEmailAndPassword("rafael.estudo@gmail.com", "teste12345")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){ //se o usuário foi realmente criado
                            Log.i("signInUser", "Sucesso ao logar user!!");
                        } else { //erro ao cadastrar
                            Log.i("signInUser", "ERRO ao logar user!!" + task.getException());
                        }
                    }
                });

        //cadastro do usuário
//        auth.createUserWithEmailAndPassword("rafael.estudo@gmail.com", "teste123")
//                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if(task.isSuccessful()){ //se o usuário foi realmente criado
//                            Log.i("createUser", "Sucesso ao criar user!!");
//                        } else { //erro ao cadastrar
//                            Log.i("createUser", "ERRO ao criar user!!");
//                        }
//                    }
//                });

        //verificar se está logado
        if (auth.getCurrentUser() != null) {
            Log.i("loggedInUser", "Usuario logado!!");
        } else {
            Log.i("loggedInUser", "Usuario não logado!!");
        }

        auth.signOut();

        //verificar se está logado
        if (auth.getCurrentUser() != null) {
            Log.i("loggedInUser", "Usuario logado!!");
        } else {
            Log.i("loggedInUser", "Usuario não logado!!");
        }
    }
}
