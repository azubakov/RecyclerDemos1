package tomerbu.edu.recyclerdemos;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    EditText etEmail, etPassword;
    Button btnLogin;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View dialogView = inflater.inflate(R.layout.fragment_login, container, false);


        etEmail = (EditText) dialogView.findViewById(R.id.etEmail);
        etPassword = (EditText) dialogView.findViewById(R.id.etPassword);
        btnLogin = (Button) dialogView.findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String pass = etPassword.getText().toString();
                Toast.makeText(getContext(), "Logged In " + email, Toast.LENGTH_SHORT).show();
            }
        });

        return dialogView;
    }

}
