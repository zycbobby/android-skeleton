package worksap.co.jp.discount.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import worksap.co.jp.discount.CrimeDetailActivity;
import worksap.co.jp.discount.R;
import worksap.co.jp.discount.dto.Crime;
import worksap.co.jp.discount.dto.CrimeLab;


/**
 * A simple {@link Fragment} subclass.
 */
public class CrimeListFragment extends ListFragment {

    private static final String TAG = "CrimeListFragment";

    private CrimeLab crimes = CrimeLab.INSTANCE;

    public CrimeListFragment() {
        super();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Crime List");
        ArrayAdapter<Crime> crimeArrayAdapter = new CrimeListAdapter(crimes.getCrimes());
        setListAdapter(crimeArrayAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Crime c = (Crime) getListAdapter().getItem(position);
        Intent intent = new Intent(getActivity(), CrimeDetailActivity.class);
        intent.putExtra(CrimeDetailFragment.EXTRA_CRIME, c.getUuid());
        startActivity(intent);
    }

    public class CrimeListAdapter extends ArrayAdapter<Crime> {

        CheckBox solvedCheckbox;
        TextView crimeTitle;
        TextView crimeDate;

        public CrimeListAdapter(List<Crime> crimes) {
            super(getActivity(), 0, crimes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.crime_item, null);
            }

            crimeTitle = (TextView) convertView.findViewById(R.id.crime_title);
            crimeDate = (TextView) convertView.findViewById(R.id.crime_date);
            solvedCheckbox = (CheckBox) convertView.findViewById(R.id.solved_checkbox);

            Crime c = (Crime) getListAdapter().getItem(position);
            crimeTitle.setText(c.getTitle());
            crimeDate.setText(c.getDate().toString());
            solvedCheckbox.setChecked(c.isSolved());
            return convertView;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // this one is important for update the data after come back from the intent
        ((CrimeListAdapter)getListAdapter()).notifyDataSetChanged();
    }
}
