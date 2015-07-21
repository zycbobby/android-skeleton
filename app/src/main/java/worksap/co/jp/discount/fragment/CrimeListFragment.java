package worksap.co.jp.discount.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import worksap.co.jp.discount.R;
import worksap.co.jp.discount.dto.Crime;


/**
 * A simple {@link Fragment} subclass.
 */
public class CrimeListFragment extends ListFragment {

    private static final String TAG = "CrimeListFragment";

    private List<Crime> crimes = new ArrayList<>();

    public CrimeListFragment() {
        super();
        for (int i = 0; i < 100; i++) {
            Crime c = new Crime();
            c.setTitle("Crime #" + i);
            c.setSolved( i%3 == 0);
            crimes.add(c);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Crime List");
        ArrayAdapter<Crime> crimeArrayAdapter = new CrimeListAdapter(crimes);
        setListAdapter(crimeArrayAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Crime c = (Crime) getListAdapter().getItem(position);
        Log.d("test", c.toString());
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
}
