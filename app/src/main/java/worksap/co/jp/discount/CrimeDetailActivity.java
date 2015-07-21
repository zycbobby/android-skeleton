package worksap.co.jp.discount;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import worksap.co.jp.discount.fragment.CrimeDetailFragment;

public class CrimeDetailActivity extends SingleFragmentActivity {

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected Fragment createFragment() {
        CrimeDetailFragment crimeDetailFragment = new CrimeDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(CrimeDetailFragment.EXTRA_CRIME, getIntent().getSerializableExtra(CrimeDetailFragment.EXTRA_CRIME));
        crimeDetailFragment.setArguments(args);
        return crimeDetailFragment;
    }
}
