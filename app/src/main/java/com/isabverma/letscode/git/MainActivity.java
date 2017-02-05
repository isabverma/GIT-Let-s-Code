package com.isabverma.letscode.git;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Context context;
    String NavGit ="<h2>GIT</h2><br><p>A tool used for versioning</p>";
    String NavGitDownload="<h2>GIT Download</h2><br><p>Download the Git</p>";
    String NavGitSetup="<h2>GIT Setup</h2><br><p>Setup the Git</p>";
    String NavGitInit="<h2>GIT INIT</h2><br><p>Setup the Git</p>";
    String NavGitClone="<h2>GIT Clone</h2><br><p>Setup the Git</p>";
    String NavGitConfigUserName="<h2>GIT Username</h2><br><p>Setup the Git</p>";
    String NavGitConfigUserEmail="<h2>GIT Email</h2><br><p>Setup the Git</p>";
    String NavGitConfigColorUi="<h2>GIT Color UI</h2><br><p>Setup the Git</p>";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.main_container);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.content_main, null);
        TextView name = (TextView)layout.findViewById(R.id.content_main_text_view);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            getSupportActionBar().setTitle("GIT Basics");
            name.setText(Html.fromHtml(NavGit, Html.FROM_HTML_MODE_COMPACT));
        } else{
            getSupportActionBar().setTitle("GIT Basics");
            name.setText(Html.fromHtml(NavGit));
        }
        mainLayout.removeAllViews();
        mainLayout.addView(layout);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    private Boolean exit = false;
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if(exit){
                finish();
            }else{
                Toast.makeText(this, "Press Back Again To Exit", Toast.LENGTH_SHORT).show();
                exit = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        exit = false;
                    }
                },2*1000);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            Toast.makeText(this, "Settings Selected..!!!", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.action_about_developers){
            Toast.makeText(this, "About Developers Selected..!!!", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.action_feedback){
            Toast.makeText(this, "Feedback Selected..!!!", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.action_rate_us){ //for rate us
            Uri uri = Uri.parse("market://details?id=com.isabverma.letscode.git");
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            // To count with Play market backstack, After pressing back button,
            // to taken back to our application, we need to add following flags to intent.
            goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            try {
                startActivity(goToMarket);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + context.getPackageName()))); }
        }else if(id == R.id.action_share){
            Toast.makeText(this, "Share Selected..!!!", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.main_container);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.content_main, null);
        TextView name = (TextView)layout.findViewById(R.id.content_main_text_view);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            if (id == R.id.nav_git) {
                getSupportActionBar().setTitle("GIT Basics");
                name.setText(Html.fromHtml(NavGit, Html.FROM_HTML_MODE_COMPACT));
            } else if (id == R.id.nav_download) {
                getSupportActionBar().setTitle("GIT Download");
                name.setText(Html.fromHtml(NavGitDownload, Html.FROM_HTML_MODE_COMPACT));
            } else if (id == R.id.nav_setup) {
                getSupportActionBar().setTitle("GIT Setup");
                name.setText(Html.fromHtml(NavGitSetup, Html.FROM_HTML_MODE_COMPACT));
            }else if (id == R.id.nav_git_init) {
                getSupportActionBar().setTitle("GIT init");
                name.setText(Html.fromHtml(NavGitInit, Html.FROM_HTML_MODE_COMPACT));
            } else if (id == R.id.nav_git_clone) {
                getSupportActionBar().setTitle("GIT clone");
                name.setText(Html.fromHtml(NavGitClone, Html.FROM_HTML_MODE_COMPACT));
            } else if (id == R.id.nav_git_config_user_name) {
                getSupportActionBar().setTitle("GIT config user.name");
                name.setText(Html.fromHtml(NavGitConfigUserName, Html.FROM_HTML_MODE_COMPACT));
            } else if (id == R.id.nav_git_congif_user_eamil) {
                getSupportActionBar().setTitle("GIT config user.email");
                name.setText(Html.fromHtml(NavGitConfigUserEmail, Html.FROM_HTML_MODE_COMPACT));
            } else if (id == R.id.nav_git_congif_color_ui) {
                getSupportActionBar().setTitle("GIT config color.ui");
                name.setText(Html.fromHtml(NavGitConfigColorUi, Html.FROM_HTML_MODE_COMPACT));
            } else{
                getSupportActionBar().setTitle("GIT Basics");
                name.setText(Html.fromHtml(NavGit, Html.FROM_HTML_MODE_COMPACT));
            }
        } else{
            if (id == R.id.nav_git) {
                getSupportActionBar().setTitle("GIT Basics");
                name.setText(Html.fromHtml(NavGit));
            } else if (id == R.id.nav_download) {
                getSupportActionBar().setTitle("GIT Download");
                name.setText(Html.fromHtml(NavGitDownload));
            } else if (id == R.id.nav_setup) {
                getSupportActionBar().setTitle("GIT Setup");
                name.setText(Html.fromHtml(NavGitSetup));
            }else if (id == R.id.nav_git_init) {
                getSupportActionBar().setTitle("GIT init");
                name.setText(Html.fromHtml(NavGitInit));
            } else if (id == R.id.nav_git_clone) {
                getSupportActionBar().setTitle("GIT clone");
                name.setText(Html.fromHtml(NavGitClone));
            } else if (id == R.id.nav_git_config_user_name) {
                getSupportActionBar().setTitle("GIT config user.name");
                name.setText(Html.fromHtml(NavGitConfigUserName));
            } else if (id == R.id.nav_git_congif_user_eamil) {
                getSupportActionBar().setTitle("GIT config user.email");
                name.setText(Html.fromHtml(NavGitConfigUserEmail));
            } else if (id == R.id.nav_git_congif_color_ui) {
                getSupportActionBar().setTitle("GIT config color.ui");
                name.setText(Html.fromHtml(NavGitConfigColorUi));
            } else{
                getSupportActionBar().setTitle("GIT Basics");
                name.setText(Html.fromHtml(NavGit));
            }
        }

        mainLayout.removeAllViews();
        mainLayout.addView(layout);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
