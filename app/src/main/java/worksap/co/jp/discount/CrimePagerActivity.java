package worksap.co.jp.discount;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.UUID;

import worksap.co.jp.discount.dto.Crime;
import worksap.co.jp.discount.dto.CrimeLab;
import worksap.co.jp.discount.fragment.CrimeDetailFragment;
import worksap.co.jp.discount.fragment.CrimeListFragment;


public class CrimePagerActivity extends FragmentActivity {

    public static final String EXTRA_CRIME_POSITION = "EXTRA_CRIME_POSITION";
    private ViewPager viewPager;
    private CrimeLab crimes = CrimeLab.INSTANCE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewPager = new ViewPager(this);
        viewPager.setId(R.id.viewPager);
        setContentView(viewPager);

        FragmentManager fm = getSupportFragmentManager();
        viewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                CrimeDetailFragment crimeDetailFragment = new CrimeDetailFragment();
                Bundle args = new Bundle();
                args.putSerializable(CrimeDetailFragment.EXTRA_CRIME, CrimeLab.INSTANCE.getCrimes().get(position).getUuid());
                crimeDetailFragment.setArguments(args);
                return crimeDetailFragment;
            }

            @Override
            public int getCount() {
                return crimes.getCrimes().size();
            }
        });

        viewPager.setCurrentItem(getIntent().getIntExtra(CrimePagerActivity.EXTRA_CRIME_POSITION, 0));
    }
}
