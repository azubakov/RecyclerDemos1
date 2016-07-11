package tomerbu.edu.recyclerdemos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        layout = (RelativeLayout)findViewById(R.id.layout);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  showLoginDialog();
                showLoginFragmentDialog();
            }
        });

    }

    boolean toggle = true;
    private void showLoginFragmentDialog() {
        LoginFragment dialog = new LoginFragment();
       // dialog.show(getSupportFragmentManager(), "Tomer");

        if (toggle){
            getSupportFragmentManager().beginTransaction().add(R.id.container, dialog, "Tomer").commit();
        }
        else
            getSupportFragmentManager().beginTransaction().remove(getSupportFragmentManager().findFragmentByTag("Tomer")).commit();
        toggle = !toggle;

    }

    private void showLoginDialog() {
        View dialogView = getLayoutInflater().inflate(R.layout.login_dialog, layout, false);
        final EditText etEmail = (EditText) dialogView.findViewById(R.id.etEmail);
        final EditText etPassword = (EditText) dialogView.findViewById(R.id.etPassword);
        Button btnLogin = (Button) dialogView.findViewById(R.id.btnLogin);


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        final AlertDialog dialog = builder.show();


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String pass = etPassword.getText().toString();
                Toast.makeText(MainActivity.this, "Logged In " + email, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
