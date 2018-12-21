package com.litetech.tuby.utils;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;

public class TextUtility {
    private AppCompatActivity appCompatActivity;


    public static TextUtility getInstance(Activity activity) {
        return new TextUtility(activity);
    }


    private TextUtility(Activity activity) {
        this.appCompatActivity = (AppCompatActivity) activity;
    }


    private TextUtility(){

    }


    public static TextUtility getInstance() {
        return new TextUtility();
    }

    public boolean isEmpty(TextInputLayout...textInputLayout) {
        boolean valid = true;
        for (TextInputLayout inputLayout : textInputLayout) {
            if (Objects.requireNonNull(inputLayout.getEditText()).getText().toString().isEmpty()) {
                inputLayout.setError(inputLayout.getHint() + " field required");
                valid = false;
            }
        }
        return valid;
    }


    public void addTextChangeListener(TextInputLayout...layouts){
        for (final TextInputLayout layout : layouts){
            Objects.requireNonNull(layout.getEditText()).addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if (charSequence.toString().length() < 1){
                        layout.setError(layout.getHint()+" field required");
                    }else {
                        layout.setError(null);
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
    }


    public String fieldToString(TextInputLayout layout){
        String value = "";

        if (isEmpty(layout)){
            value = Objects.requireNonNull(layout.getEditText()).getText().toString();
        }
        return value;
    }




    public boolean validEmail(TextInputLayout email) {
        boolean valid = true;
        if (email.getEditText().getText().toString().isEmpty() | !email.getEditText().getText().toString().contains("@")) {
            email.setError("Email is invalid");
            valid = false;
        }
        return valid;
    }


    public boolean validPassword(TextInputLayout password) {
        boolean valid = true;
        if (password.getEditText().getText().toString().isEmpty() || password.getEditText().getText().toString().length() < 7) {
            password.setError("Password is invalid");
            valid = false;
        }

        return valid;
    }


    public void checkTextInput(final TextInputLayout textInputLayout, final String fieldName) {
        Objects.requireNonNull(textInputLayout.getEditText()).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                switch (fieldName) {
                    case "Email":
                        if (!charSequence.toString().contains("@")) {
                            textInputLayout.setError(fieldName + " is invalid");
                        } else {
                            textInputLayout.setError(null);
                        }
                        break;
                    case "Password":
                        if (charSequence.toString().length() < 5) {
                            textInputLayout.setError(fieldName + " is invalid");
                        } else {
                            textInputLayout.setError(null);
                        }
                        break;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }



}
