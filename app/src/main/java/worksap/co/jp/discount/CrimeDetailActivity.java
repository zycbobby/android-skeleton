package worksap.co.jp.discount;

import android.support.v4.app.Fragment;

import worksap.co.jp.discount.fragment.CrimeDetailFragment;
import worksap.co.jp.discount.fragment.CrimeListFragment;

public class CrimeDetailActivity extends SingleFragmentActivity {

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public int getFragmentMountPoint()  {
        return R.id.fragmentContainer;
    }

    @Override
    protected Fragment createFragment() {
        return new CrimeDetailFragment();
    }
}
