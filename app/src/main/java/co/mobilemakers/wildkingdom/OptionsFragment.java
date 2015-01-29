package co.mobilemakers.wildkingdom;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class OptionsFragment extends Fragment {

    private Button buttonBrownBear;
    private Button buttonGrizzlyBear;
    private Button buttonWombat;
    private Button buttonGecko;
    private Button buttonCoralSnake;
    private Button buttonTortoise;

    public interface OnFragmentInteractionListener {
        public void onButtonBrownBearClicked();
        public void onButtonGrizzlyBear();
        public void onButtonWombat();
        public void onButtonGecko();
        public void onButtonCoralSnake();
        public void onButtonTortoise();

    }



    private OnFragmentInteractionListener mListener;

    public OptionsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_options, container, false);
        prepareViews(rootView);

        setButtonEvents();

        return rootView;
    }

    private void prepareViews(View rootView) {
        buttonBrownBear = (Button) rootView.findViewById(R.id.button_brown_bear);
        buttonGrizzlyBear = (Button) rootView.findViewById(R.id.button_brown_bear);
        buttonWombat = (Button) rootView.findViewById(R.id.button_brown_bear);
        buttonGecko = (Button) rootView.findViewById(R.id.button_brown_bear);
        buttonCoralSnake = (Button) rootView.findViewById(R.id.button_brown_bear);
        buttonTortoise = (Button) rootView.findViewById(R.id.button_brown_bear);
    }


    private void setButtonEvents() {
        buttonBrownBear.setOnClickListener(onClickListener);
        buttonGrizzlyBear.setOnClickListener(onClickListener);
        buttonWombat.setOnClickListener(onClickListener);
        buttonGecko.setOnClickListener(onClickListener);
        buttonCoralSnake.setOnClickListener(onClickListener);
        buttonTortoise.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){

                case R.id.button_brown_bear:
                    mListener.onButtonBrownBearClicked();
                break;

                case R.id.button_grizzly_bear:
                    mListener.onButtonGrizzlyBear();
                break;

                case R.id.button_gecko:
                    mListener.onButtonGecko();
                break;

                case R.id.button_wombat:
                    mListener.onButtonWombat();
                break;

                case R.id.button_coral_snake:
                    mListener.onButtonCoralSnake();
                break;

                case R.id.button_tortoise:
                    mListener.onButtonTortoise();
                break;
            }
        }
    };

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


}
