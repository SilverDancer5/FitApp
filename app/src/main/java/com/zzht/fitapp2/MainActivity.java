package com.zzht.fitapp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;
import com.zzht.fitapp2.activity.KnowActivity;
import com.zzht.fitapp2.activity.SettingActivity;
import com.zzht.fitapp2.db.MyDBHelper;
import com.zzht.fitapp2.db.UserDB;
import com.zzht.fitapp2.domain.Figure;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    UserDB userDB = new UserDB(MainActivity.this, "USER.db", null, 2);
    int[] images = {R.drawable.head1, R.drawable.head2,R.drawable.head3,
            R.drawable.head4,R.drawable.head5, R.drawable.head6,
            R.drawable.head7,R.drawable.head8,R.drawable.head9};

    private AppBarConfiguration mAppBarConfiguration;

    private List<Fragment> fragments = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        MyDBHelper myDBHelper=new MyDBHelper(MainActivity.this, "fit.db",null,1);
//        myDBHelper.DataInit();
//        Figure figure = myDBHelper.selectLastWeightByUid(2);



        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_record, R.id.nav_generate, R.id.nav_home, R.id.nav_trend, R.id.nav_calorie, R.id.nav_consume)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        View headLayout = navigationView.inflateHeaderView(R.layout.nav_header_main);
        ImageView head = headLayout.findViewById(R.id.imageView);
        head.setImageResource(images[userDB.select(LogIn.name).get(0).getImage()]);
        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });



        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case R.id.action_settings:
                        intent = new Intent(MainActivity.this, SettingActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.action_knowyourself:
                        intent = new Intent(MainActivity.this, KnowActivity.class);
                        startActivity(intent);
                        break;
                }
                return false;
            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}
