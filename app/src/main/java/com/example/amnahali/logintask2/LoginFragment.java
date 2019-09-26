package com.example.amnahali.logintask2;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import static android.content.Context.MODE_PRIVATE;

public class LoginFragment extends DialogFragment {

    public Button logIn;
    private CheckBox checkFragment;
    private SharedPreferences.Editor editor ;

    TextInputEditText userName, password;
    TextInputLayout passwordInputLayout;


    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup
            container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        editor = getActivity().getSharedPreferences("pref", MODE_PRIVATE).edit();
        logIn = view.findViewById(R.id.logIn);
        userName = view.findViewById(R.id.userName);
        password = view.findViewById(R.id.password);
        passwordInputLayout = view.findViewById(R.id.passwordInputLayout);
        checkFragment = view.findViewById(R.id.staySignIn);

        password.addTextChangedListener(passwordWatcher);

        logIn.setOnClickListener(logInCheck);


    }

    private View.OnClickListener logInCheck = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

                if(userName.getText().toString().equals("admin") && password.getText().toString().equals("12345678")){
                    if (checkFragment.isChecked()) {

                        editor.putString("key", userName.getText().toString());
                        editor.apply();

                    }
                        ((MainActivity) getActivity()).userName.setText(userName.getText().toString());
                        dismiss();
                }else{
                    Toast.makeText(view.getContext(),"UserName and/or password are not correct",Toast.LENGTH_LONG).show();
                }

        }
    };
    private TextWatcher passwordWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            if (charSequence.length() > passwordInputLayout.getCounterMaxLength()) {
                passwordInputLayout.setError("Password is too long");
            } else {
                passwordInputLayout.setError(null);
            }


        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };


}