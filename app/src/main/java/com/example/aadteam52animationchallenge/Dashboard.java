package com.example.aadteam52animationchallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.*;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        RecyclerView recyclerView = findViewById(R.id.post_list);
        List<PostItem> mlist = new ArrayList<>();
        mlist.add(new PostItem("Beauty", "Honest Beauty", R.drawable.beauty));
        mlist.add(new PostItem("Camera", "Exakta", R.drawable.camera));
        mlist.add(new PostItem("Elle", "Elle Cartier", R.drawable.elle));
        mlist.add(new PostItem("Golf", "Volkswagen", R.drawable.golf));
        mlist.add(new PostItem("Motorbike", "Harley Davidson", R.drawable.harley));
        mlist.add(new PostItem("Lake House", "Elle Cartier", R.drawable.lake));

        PostAdapter adapter = new PostAdapter(this,mlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

	@Override
	public void onBackPressed()
	{
		Intent home_intent = new Intent(Dashboard.this, Login.class);
		startActivity(home_intent);
		overridePendingTransition(R.anim.animate_dashboard_enter, R.anim.animate_login_leave);
		finish();
		// TODO: Implement this method
		
	}
	
}
