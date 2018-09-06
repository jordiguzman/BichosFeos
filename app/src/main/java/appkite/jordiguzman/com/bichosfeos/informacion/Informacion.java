package appkite.jordiguzman.com.bichosfeos.informacion;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.robohorse.pagerbullet.PagerBullet;

import java.util.Locale;

import appkite.jordiguzman.com.bichosfeos.Idioma;
import appkite.jordiguzman.com.bichosfeos.R;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.mantis.MantisPager;


public class Informacion extends AppCompatActivity {

    PagerBullet pagerBullet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
        cambiarIdioma();


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        /*
      The {@link android.support.v4.view.PagerAdapter} that will provide
      fragments for each of the sections. We use a
      {@link FragmentPagerAdapter} derivative, which will keep every
      loaded fragment in memory. If this becomes too memory intensive, it
      may be best to switch to a
      {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        /*
      The {@link ViewPager} that will host the section contents.
     */

        pagerBullet = (PagerBullet) findViewById(R.id.container);

        assert pagerBullet != null;
        pagerBullet.invalidateBullets();
        mSectionsPagerAdapter.notifyDataSetChanged();
        pagerBullet.setAdapter(mSectionsPagerAdapter);

        pagerBullet.setIndicatorTintColorScheme(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.colorPrimary));


    }
    public void cambiarIdioma(){
        int ori=getResources().getConfiguration().orientation;

        if (ori==1 && Idioma.currentIdioma ==1 || ori==2 && Idioma.currentIdioma==1){
            String languageToLoad  = "es"; // your language
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());

        }

        if (ori==2 && Idioma.currentIdioma ==2 || ori==1 && Idioma.currentIdioma==2){
            String languageToLoad  = "en"; // your language
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {

        MantisPager.posImagen=-1;
        cambiarIdioma();
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        MantisPager.posImagen=-1;
        cambiarIdioma();

    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_informacion, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);


            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1:
                    textView.setText(R.string.teoria1);
                    break;
                case 2:
                    textView.setText(R.string.teoria2);
                    break;
                case 3:
                    textView.setText(R.string.teoria3);
                    break;
            }

            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
