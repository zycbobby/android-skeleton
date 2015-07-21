package worksap.co.jp.discount.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;

import butterknife.Bind;
import butterknife.ButterKnife;
import worksap.co.jp.discount.R;
import worksap.co.jp.discount.dto.Crime;
import worksap.co.jp.discount.dto.CrimeLab;

public class CrimeDetailFragment extends Fragment {

    public static final String EXTRA_CRIME = "EXTRA_CRIME";

    @Bind(R.id.crime_title)
    EditText crimeTitle;
    @Bind(R.id.crime_date)
    Button crimeDate;
    @Bind(R.id.crime_solved)
    CheckBox crimeSolved;

    private Crime crime;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Crime Detail");
        crime = CrimeLab.INSTANCE.getCrime((UUID) getActivity().getIntent().getSerializableExtra(EXTRA_CRIME));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_crime, container, false);
        ButterKnife.bind(this, v);
        crimeTitle.setText(this.crime.getTitle());
        crimeDate.setText(this.crime.getDate().toString());
        crimeSolved.setChecked(this.crime.isSolved());
        crimeTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                crime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        crimeDate.setText(crime.getDate().toString());
        crimeDate.setEnabled(false);

        crimeSolved.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                crime.setSolved(isChecked);
            }
        });

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
