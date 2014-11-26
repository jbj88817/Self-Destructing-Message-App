package com.example.bojie.ribbit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bojie.ribbit.R;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;


public class ForgetPasswordActivity extends Activity {

    public static final String TAG = ForgetPasswordActivity.class.getSimpleName();

    EditText mEmail_ET;
    Button mResetPassword_BTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_forget_password);

        mEmail_ET = (EditText) findViewById(R.id.et_email);
        mResetPassword_BTN = (Button) findViewById(R.id.btn_reset_password);
        mResetPassword_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProgressBarIndeterminateVisibility(true);
                String email = mEmail_ET.getText().toString().trim();
                Log.v(TAG, email);
                ParseUser.requestPasswordResetInBackground(email, new RequestPasswordResetCallback() {
                    @Override
                    public void done(ParseException e) {
                        setProgressBarIndeterminateVisibility(false);
                        if(e == null){
                            Toast.makeText(ForgetPasswordActivity.this, "Send the reset email.",
                                    Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(ForgetPasswordActivity.this, "Unable to send the email," +
                                            "Please check your Internet connection.",
                                    Toast.LENGTH_SHORT).show();
                            Log.v(TAG, e.getMessage());
                        }
                    }
                });
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_forget_password, menu);
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
