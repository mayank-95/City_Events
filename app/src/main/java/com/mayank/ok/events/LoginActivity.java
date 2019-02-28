package com.mayank.ok.events;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.mayank.ok.events.Appdata.login;
import static com.mayank.ok.events.Appdata.userkey;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText user,pass;
    Button l,nxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Appdata a=new Appdata();
        if(a.get(getApplicationContext(),a.login).equals("true"))
        {
            Intent it=new Intent(getApplicationContext(),DashboardActivity.class);
            startActivity(it);
            finish();
        }
        mAuth = FirebaseAuth.getInstance();
        user=findViewById(R.id.user);
        pass=findViewById(R.id.pass);
        l=findViewById(R.id.l);
        nxt=findViewById(R.id.nxt);

    }

    public void sign(View view) {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void log(View view) {
        final String email=user.getText().toString();
        String password=pass.getText().toString();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
                            Appdata a=new Appdata();
                            a.save(getApplicationContext(),"true",a.login);
                            a.save(getApplicationContext(),email,a.userkey);
                            Intent i=new Intent(getApplicationContext(),DashboardActivity.class);
                            startActivity(i);


                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(getApplicationContext(), "Authentication failed.",Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });

    }
}
