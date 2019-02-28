package com.mayank.ok.events;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText email,password;
    Button login,signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Appdata a=new Appdata();
        if(a.get(getApplicationContext(),a.login).equals("true"))
        {
            Intent it=new Intent(getApplicationContext(),DashboardActivity.class);
            startActivity(it);
            finish();
        }
        mAuth = FirebaseAuth.getInstance();
        email=findViewById(R.id.user);
        password=findViewById(R.id.pass);
        signup=findViewById(R.id.l);
        login=findViewById(R.id.nxt);
    }



    public void log(View view) {
        Intent i=new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(i);
    }


    public void next(View view) {

        final String user=email.getText().toString();
        String pass=password.getText().toString();
        mAuth.createUserWithEmailAndPassword(user,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(getApplicationContext(),"Signup Sucessful",Toast.LENGTH_LONG).show();
                            Appdata a=new Appdata();
                            a.save(getApplicationContext(),"true",a.login);
                            a.save(getApplicationContext(),user,a.userkey);
                            Intent i=new Intent(getApplicationContext(),DashboardActivity.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplicationContext(),"login failed",Toast.LENGTH_LONG).show();

                        }

                        // ...
                    }
                });
    }

}
