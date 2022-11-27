package com.example.whatsapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.hotspot2.pps.Credential;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.whatsapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class login extends AppCompatActivity {
    private EditText number ,code;
    private TextView alarm;
    private Button send,ok;
    private FirebaseAuth auth;
    private String verificationId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        uiti();
        auth = FirebaseAuth.getInstance();
        //click on send
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(number.getText().toString())) {
                    Toast.makeText(login.this, "enter valid number", Toast.LENGTH_SHORT).show();
                } else {
                    String pnumber = number.getText().toString();
                    sendVerficationCode(pnumber);
                }
            }
        });
        //cleck on ok
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(code.getText().toString())) {
                    Toast.makeText(login.this, "wrong", Toast.LENGTH_SHORT).show();
                } else {
                    verifycode(code.getText().toString());
                }
            }
        });
    }
        //verfy
       private void sendVerficationCode(String pnumber)
        {
            PhoneAuthOptions options=
                    PhoneAuthOptions.newBuilder(auth)
                            .setPhoneNumber("+20"+pnumber)
                            .setTimeout(60l,TimeUnit.SECONDS)
                            .setActivity(this)
                            .setCallbacks(mCallback)
                            .build();
            PhoneAuthProvider.verifyPhoneNumber(options);
        }
      private   PhoneAuthProvider.OnVerificationStateChangedCallbacks
                mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential credential)
            {
               // final String code = credential.getSmsCode();
                //if (code!= null) {
                 //   verifycode(code);
               // }
                signbyCred(credential);
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                Toast.makeText(login.this, "failed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken token) {
                super.onCodeSent(s, token);
                verificationId=s;
            }
        };
    private void verifycode(String code)
    {
        PhoneAuthCredential credential=PhoneAuthProvider.getCredential(verificationId,code);
       // signbyCred(credential);

    }

        private void signbyCred(PhoneAuthCredential credential) {
            FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
            firebaseAuth.signInWithCredential(credential)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful())
                            {

                                FirebaseUser firebaseUser=task.getResult().getUser();
                                Toast.makeText(login.this, "success", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(login.this,MainActivity.class);
                                startActivity(intent);
                            }
                        }
                    });
        }


    //initialization the elements
    private void uiti(){
        number = findViewById(R.id.number);
        alarm = findViewById(R.id.alarm);
        ok = findViewById(R.id.ok);
        send=findViewById(R.id.send_code);
        code=findViewById(R.id.code);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser= FirebaseAuth.getInstance().getCurrentUser();

        if(currentUser!=null)
        {
          Intent intent=new Intent(login.this,MainActivity.class);
          startActivity(intent);
        }
    }
}