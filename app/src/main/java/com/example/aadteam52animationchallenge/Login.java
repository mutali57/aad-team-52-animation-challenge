package com.example.aadteam52animationchallenge;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import android.widget.*;
import android.content.res.*;
import android.transition.*;
import android.content.*;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity
{

    AnimationDrawable anim;
    AssetManager am;

	// LoginHelper loginHelper;
    Typeface typefaceBillabong, typefaceRoboto;
    TextView nHeader;

    EditText edtPassword, edtEmail;
    Button btnLogin;
    private Spinner spinner;
	private Button loginButton;
	private  Scene scene1;
	private  Scene scene2;
	private Scene currentScene;
	private Transition transition;
	private FrameLayout framelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
		framelayout = findViewById(R.id.sceneRoot);

		//initTe
		scene1 = Scene.getSceneForLayout(framelayout, R.layout.scene1, this);
		scene2 = Scene.getSceneForLayout(framelayout, R.layout.scene2, this);
		transition = TransitionInflater.from(this).inflateTransition(R.transition.example1);

		scene1.enter();

		currentScene = scene1;
		if (currentScene == scene1)
		{
			typefaceBillabong = Typeface.createFromAsset(getResources(). getAssets(), "Billabong.ttf");
			typefaceRoboto = Typeface.createFromAsset(getResources(). getAssets(), "Roboto-Regular.ttf");
			nHeader = findViewById(R.id.lblHeader);
			nHeader.setTypeface(typefaceBillabong);

			animateBackground(this);
		}
		initSpinner();

    }

	private void initSpinner() throws Resources.NotFoundException
	{
		spinner = findViewById(R.id.activity_mainSpinner);
		Resources res = getResources();
		String[] planets = res.getStringArray(R.array.langArray);
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, planets);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(dataAdapter);
	}

	private void animateBackground(Context contxt)
	{
		am = contxt.getApplicationContext().getAssets();
        RelativeLayout container = findViewById(R.id.container);
        anim = (AnimationDrawable) container.getBackground();
        anim.setEnterFadeDuration(100);
        anim.setExitFadeDuration(1000);
	}

	private void initText()
	{   typefaceBillabong = Typeface.createFromAsset(getResources(). getAssets(), "Billabong.ttf");
		typefaceRoboto = Typeface.createFromAsset(getResources(). getAssets(), "Roboto-Regular.ttf");
		nHeader = findViewById(R.id.lblHeader);
        nHeader.setTypeface(typefaceBillabong);
        edtPassword = findViewById(R.id.edtPassword);
        edtEmail = findViewById(R.id.edtEmail);
        btnLogin = findViewById(R.id.btnLogin);
        edtPassword.setTypeface(typefaceRoboto);
		edtEmail.setTypeface(typefaceRoboto);
		btnLogin.setTypeface(typefaceRoboto);
	}
    @Override
    protected void onResume()
	{
        super.onResume();
        if (anim != null && !anim.isRunning())
            anim.start();
    }

    @Override
    protected void onPause()
	{
        super.onPause();
        if (anim != null && anim.isRunning())
            anim.stop();

	}




	@Override
	public void onBackPressed()
	{
		if (currentScene == scene2)
			goScene1(this);
		else
			super.onBackPressed();
		// TODO: Implement this method

	}

	private void goScene1(Context context) throws Resources.NotFoundException
	{
		if (currentScene == scene2)
		{
			TransitionManager.go(scene1, transition);
			initSpinner();
			typefaceBillabong = Typeface.createFromAsset(getResources(). getAssets(), "Billabong.ttf");
			typefaceRoboto = Typeface.createFromAsset(getResources(). getAssets(), "Roboto-Regular.ttf");
			nHeader = findViewById(R.id.lblHeader);
			nHeader.setTypeface(typefaceBillabong);

			currentScene =	scene1;

			animateBackground(context);
			if (anim != null && !anim.isRunning())
				anim.start();


		}
	}
	private void goScene2(Context contxt) throws Resources.NotFoundException
	{
		if (currentScene == scene1)
		{

			TransitionManager.go(scene2, transition);
			initSpinner();
			initText();
			animateBackground(contxt);
			if (anim != null && !anim.isRunning())
				anim.start();
			currentScene = scene2;
		}}


	public void  signIn(View v)
	{
		goScene1(v.getContext());

	}

	public void logInMenu(View  v)
	{
		goScene2(v.getContext());}

//Use the logIn onclick button to move from Login to MainActivity
	public void logIn(View v){
		Intent  intent = new Intent(Login.this,Dashboard.class);
		v.getContext().startActivity(intent);
		//please make sure your setcontentView is set to the right Layout.

	}

	public void signUp(View v)
	{
		goScene1(v.getContext());

	}

}
	
