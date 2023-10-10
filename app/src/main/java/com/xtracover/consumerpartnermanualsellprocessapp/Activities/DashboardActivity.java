package com.xtracover.consumerpartnermanualsellprocessapp.Activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.navigation.NavigationView;
import com.xtracover.consumerpartnermanualsellprocessapp.Adapters.AioAdapter;
import com.xtracover.consumerpartnermanualsellprocessapp.Adapters.DesktopAdapter;
import com.xtracover.consumerpartnermanualsellprocessapp.Adapters.MonitorAdapter;
import com.xtracover.consumerpartnermanualsellprocessapp.Adapters.NoteBookAdapter;
import com.xtracover.consumerpartnermanualsellprocessapp.Adapters.SliderAdapter;
import com.xtracover.consumerpartnermanualsellprocessapp.Models.SliderItems;
import com.xtracover.consumerpartnermanualsellprocessapp.R;
import com.xtracover.consumerpartnermanualsellprocessapp.Utilities.MathCaptcha;
import com.xtracover.consumerpartnermanualsellprocessapp.Utilities.UserSession;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private Context mContext;
    private UserSession userSession;
    private DrawerLayout drawer_layout;
    private NavigationView dashboradNavigetion;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;
    private ImageView dashboardMenuMain, dashboardCart, dashboardLogin;
    private ViewPager2 viewPagerImageSlider;
    private Handler sliderHandler = new Handler();
    private NoteBookAdapter noteBookAdapter;
    private MonitorAdapter monitorAdapter;
    private AioAdapter aioAdapter;
    private DesktopAdapter desktopAdapter;
    private RecyclerView noteBookRcView, monitorRcView, aioRcView, desktopRcView;
    private LinearLayoutManager linearLayoutManagerN, linearLayoutManagerM, linearLayoutManagerA, linearLayoutManagerD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        mContext = this;
        userSession = new UserSession(mContext);

        getLayoutUiId();

        dashboradNavigetion.setNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle((Activity) mContext, drawer_layout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();

        dashboardMenuMain.setOnClickListener(this);
        dashboardCart.setOnClickListener(this);
        dashboardLogin.setOnClickListener(this);
        getAutomaticSliderImage();

        getNoteBookItemsDetailsSystem();
    }

    private void getNoteBookItemsDetailsSystem() {
        try {
            noteBookAdapter = new NoteBookAdapter(mContext);
            linearLayoutManagerN = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
            noteBookRcView.setLayoutManager(linearLayoutManagerN);
            noteBookRcView.setAdapter(noteBookAdapter);
            noteBookAdapter.notifyDataSetChanged();

            monitorAdapter = new MonitorAdapter(mContext);
            linearLayoutManagerM = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
            monitorRcView.setLayoutManager(linearLayoutManagerM);
            monitorRcView.setAdapter(monitorAdapter);
            monitorAdapter.notifyDataSetChanged();

            aioAdapter = new AioAdapter(mContext);
            linearLayoutManagerA = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
            aioRcView.setLayoutManager(linearLayoutManagerA);
            aioRcView.setAdapter(aioAdapter);
            aioAdapter.notifyDataSetChanged();

            desktopAdapter = new DesktopAdapter(mContext);
            linearLayoutManagerD = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
            desktopRcView.setLayoutManager(linearLayoutManagerD);
            desktopRcView.setAdapter(desktopAdapter);
            desktopAdapter.notifyDataSetChanged();

        } catch (Exception exp) {
            exp.getStackTrace();
        }
    }

    private void getAutomaticSliderImage() {
        try {
            List<SliderItems> sliderItems = new ArrayList<>();
            sliderItems.add(new SliderItems(R.drawable.slider_first));
            sliderItems.add(new SliderItems(R.drawable.slider_second));
            viewPagerImageSlider.setAdapter(new SliderAdapter(sliderItems, viewPagerImageSlider));

            viewPagerImageSlider.setClipToPadding(false);
            viewPagerImageSlider.setClipChildren(false);
            viewPagerImageSlider.setOffscreenPageLimit(3);
            viewPagerImageSlider.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

            CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
            compositePageTransformer.addTransformer(new MarginPageTransformer(40));
            compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
                @Override
                public void transformPage(@NonNull View page, float position) {
                    float rs = 1 - Math.abs(position);
                    page.setScaleY(0.85f + rs * 0.85f);
                }
            });

            viewPagerImageSlider.setPageTransformer(compositePageTransformer);
            viewPagerImageSlider.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                @Override
                public void onPageSelected(int position) {
                    super.onPageSelected(position);
                    sliderHandler.removeCallbacks(sliderRunnable);
                    sliderHandler.postDelayed(sliderRunnable, 5000); // slide duration 2 seconds
                }
            });
        } catch (Exception exp) {
            exp.getStackTrace();
        }
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPagerImageSlider.setCurrentItem(viewPagerImageSlider.getCurrentItem() + 1);
        }
    };

    private void getLayoutUiId() {
        try {
            drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
            dashboradNavigetion = (NavigationView) findViewById(R.id.dashboradNavigetion);
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            dashboardMenuMain = (ImageView) findViewById(R.id.dashboardMenuMain);
            dashboardCart = (ImageView) findViewById(R.id.dashboardCart);
            dashboardLogin = (ImageView) findViewById(R.id.dashboardLogin);
            viewPagerImageSlider = (ViewPager2) findViewById(R.id.viewPagerImageSlider);
            noteBookRcView = (RecyclerView) findViewById(R.id.noteBookRcView);
            monitorRcView = (RecyclerView) findViewById(R.id.monitorRcView);
            aioRcView = (RecyclerView) findViewById(R.id.aioRcView);
            desktopRcView = (RecyclerView) findViewById(R.id.desktopRcView);
        } catch (Exception exp) {
            exp.getStackTrace();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            Toast.makeText(mContext, "Home page is in working progress!", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_categories) {
            Toast.makeText(mContext, "Categories page is in working progress!", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_brands) {
            Toast.makeText(mContext, "Brands page is in working progress!", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_contact) {
            Toast.makeText(mContext, "Contact Us page is in working progress!", Toast.LENGTH_SHORT).show();
        }
        drawer_layout.closeDrawer(GravityCompat.START);
        return false;
    }

    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()) {
                case R.id.dashboardMenuMain:
                    if (!drawer_layout.isDrawerOpen(GravityCompat.START)) {
                        drawer_layout.openDrawer(GravityCompat.START);
                    } else {
                        drawer_layout.closeDrawer(GravityCompat.END);
                    }
                    break;

                case R.id.dashboardCart:
                    getAlertDialogForAddToCard();
                    break;

                case R.id.dashboardLogin:
                    getPopUpDialogForLoginOptions();
                    break;
            }
        } catch (Exception exp) {
            exp.getStackTrace();
        }
    }

    private void getPopUpDialogForLoginOptions() {
        try {
            PopupMenu popupMenu = new PopupMenu(mContext, dashboardLogin);
            popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.admin:
                            Intent intentAdmin = new Intent(mContext, LoginActivity.class);
                            intentAdmin.putExtra("LoginType", "Admin");
                            intentAdmin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intentAdmin);
                            DashboardActivity.this.finish();
                            return true;

                        case R.id.employee:
                            Intent intentEmployee = new Intent(mContext, LoginActivity.class);
                            intentEmployee.putExtra("LoginType", "Employee");
                            intentEmployee.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intentEmployee);
                            DashboardActivity.this.finish();
                            return true;

                        case R.id.partner:
                            Intent intentPartner = new Intent(mContext, LoginActivity.class);
                            intentPartner.putExtra("LoginType", "Partner");
                            intentPartner.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intentPartner);
                            DashboardActivity.this.finish();
                            return true;

                        case R.id.user:
                            Intent intentUser = new Intent(mContext, LoginActivity.class);
                            intentUser.putExtra("LoginType", "User");
                            intentUser.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intentUser);
                            DashboardActivity.this.finish();
                            return true;
                    }
                    return true;
                }
            });

            popupMenu.show();
        } catch (Exception exp) {
            exp.getStackTrace();
        }
    }

    private void getAlertDialogForAddToCard() {
        try {
            final Dialog dialog = new Dialog(mContext);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.addto_card_option_layout);

            TextView addedWishCountNo = (TextView) dialog.findViewById(R.id.addedWishCountNo);
            Button btn_ViewWishList = (Button) dialog.findViewById(R.id.btn_ViewWishList);

            btn_ViewWishList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "Wish list page is in under process!", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            });

            dialog.show();
        } catch (Exception exp) {
            exp.getStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 2000);
    }
}