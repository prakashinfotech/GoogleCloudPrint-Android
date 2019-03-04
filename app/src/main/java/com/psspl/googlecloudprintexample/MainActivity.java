package com.psspl.googlecloudprintexample;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.Task;
import com.psspl.model.SearchPrinterEntity;
import com.psspl.model.SubmitJobEntity;
import com.psspl.restapi.ApiClient;
import com.psspl.restapi.ApiInterface;
import com.psspl.model.TokenResponse;
import com.psspl.utility.CommonClass;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    private int RC_SIGN_IN = 100;
    private GoogleSignInClient mGoogleSignInClient;
    private Button btnPrintTicket;
    GoogleSignInAccount account;
    SignInButton signInButton;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        btnPrintTicket = findViewById(R.id.btnPrintTicket);


        account = GoogleSignIn.getLastSignedInAccount(this);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestServerAuthCode("Add Your Server Auth Code")
                .requestScopes(new Scope("https://www.googleapis.com/auth/cloudprint"))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        if (account != null) {
            //Already SignIn
            signIn();
            signInButton.setVisibility(View.GONE);
            btnPrintTicket.setVisibility(View.VISIBLE);
        } else {
            btnPrintTicket.setVisibility(View.GONE);
            signInButton.setVisibility(View.VISIBLE);
        }

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
        btnPrintTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (account==null||account.getServerAuthCode() == null) {
                    btnPrintTicket.setVisibility(View.GONE);
                    signInButton.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Please Sing Again token is expire", Toast.LENGTH_SHORT).show();
                } else {
                    getGenerateToken(account.getServerAuthCode());
                }
            }
        });

        CommonClass.checkPermission(MainActivity.this);
    }




    private void signIn() {
        try {
            Intent signInIntent = mGoogleSignInClient.getSignInIntent();
            startActivityForResult(signInIntent, RC_SIGN_IN);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            Log.i("Token", account.getServerAuthCode());


            updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("Login", "signInResult:failed code=" + e.getStatusCode());
            //updateUI(null);
        }
    }

    private void updateUI(GoogleSignInAccount account) {
        Toast.makeText(getApplicationContext(), "Login SuccessFully.", Toast.LENGTH_SHORT).show();
        btnPrintTicket.setVisibility(View.VISIBLE);
        signInButton.setVisibility(View.GONE);
        this.account=account;


    }


    private void getGenerateToken(String code) {
       pd= CommonClass.getLoadingDialog(MainActivity.this);
       pd.show();
        ApiInterface apiService = ApiClient.getClient("").create(ApiInterface.class);
        Call<TokenResponse> call = apiService.getGenerateToken("Add Your Server Auth Code", "gBaiRNf8VHpXhegqWeAnqblH", "authorization_code", code);
        call.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, retrofit2.Response<TokenResponse> response) {
                if (response.isSuccessful()) {
                    getSearchPrinter(response.body().getAccess_token());
                }else{
                    if(pd!=null){
                        pd.dismiss();
                    }
                }

            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                t.printStackTrace();
                if(pd!=null){
                    pd.dismiss();
                }
            }
        });
    }

    private void getSearchPrinter(final String BearerString) {
        ApiInterface apiService = ApiClient.getClientforAccessToken(BearerString).create(ApiInterface.class);
        Call<SearchPrinterEntity> call = apiService.getSearchPrinter();
        call.enqueue(new Callback<SearchPrinterEntity>() {
            @Override
            public void onResponse(Call<SearchPrinterEntity> call, retrofit2.Response<SearchPrinterEntity> response) {
                if (response.isSuccessful()) {

                    Uri path = Uri.parse("file:///android_asset/test/invoice.pdf");
                    //Uri path = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.invoice);
                    String newPath = path.toString();
                    submitJob(BearerString, newPath, response.body().getPrinters().get(0).getId(), "Sales App", "", "application/pdf");
                }else{
                    if(pd!=null){
                        pd.dismiss();
                    }
                }
            }

            @Override
            public void onFailure(Call<SearchPrinterEntity> call, Throwable t) {
                t.printStackTrace();
                if(pd!=null){
                    pd.dismiss();
                }
            }
        });
    }

    private void submitJob(String BearerString, String filepath, String printerid, String title, String ticket, String contentType) {

        MultipartBody.Part body = null;
        RequestBody reqFile = null;
        File file = new File(copyFile("invoice.pdf"));

        reqFile = RequestBody.create(MediaType.parse("application/pdf"), file);
        body = MultipartBody.Part.createFormData("content", "test.pdf", reqFile);
        RequestBody printeridreq = RequestBody.create(MediaType.parse("text/plain"), printerid);
        RequestBody titlereq = RequestBody.create(MediaType.parse("text/plain"), title);
       // RequestBody ticketreq = RequestBody.create(MediaType.parse("text/plain"), ticket);
        RequestBody contentTypereq = RequestBody.create(MediaType.parse("text/plain"), contentType);

        ApiInterface apiService = ApiClient.getClientforAccessToken(BearerString).create(ApiInterface.class);
        Call<SubmitJobEntity> call = apiService.getSubmitJob(printeridreq, body, titlereq,contentTypereq);
        call.enqueue(new Callback<SubmitJobEntity>() {
            @Override
            public void onResponse(Call<SubmitJobEntity> call, retrofit2.Response<SubmitJobEntity> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Your Ticket is Print Success fully, Now Check Your Google Cloud Account.", Toast.LENGTH_SHORT).show();
                }
                if(pd!=null){
                    pd.dismiss();
                }
            }

            @Override
            public void onFailure(Call<SubmitJobEntity> call, Throwable t) {
                t.printStackTrace();
                if(pd!=null){
                    pd.dismiss();
                }
            }
        });
    }

    private String copyFile(String filename) {
        AssetManager assetManager = this.getAssets();

        InputStream in = null;
        OutputStream out = null;
        try {
            in = assetManager.open(filename);

            File file = new File(Environment.getExternalStorageDirectory(), filename);
            if(!file.exists()){
                file.createNewFile();
            }
            out = new FileOutputStream(file);

            byte[] buffer = new byte[1024];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            return file.getAbsolutePath();
        } catch (Exception e) {
            Log.e("tag", e.getMessage());
            return "";
        }

    }



}
