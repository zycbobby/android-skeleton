package worksap.co.jp.discount;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;

import worksap.co.jp.discount.fragment.CrimeListFragment;


public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    public int getLayout() {
        return R.layout.activity_crime_list;
    }

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
