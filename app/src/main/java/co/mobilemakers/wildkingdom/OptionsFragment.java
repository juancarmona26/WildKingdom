package co.mobilemakers.wildkingdom;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class OptionsFragment extends Fragment {

    public static final String LOG_TAG = OptionsFragment.class.getName();
    private Button buttonBrownBear;
    private Button buttonGrizzlyBear;
    private Button buttonWombat;
    private Button buttonGecko;
    private Button buttonCoralSnake;
    private Button buttonTortoise;

    public interface OnFragmentInteractionListener {
        public void onClickButtonEvent(int animalPosition);
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
        buttonGrizzlyBear = (Button) rootView.findViewById(R.id.button_grizzly_bear);
        buttonWombat = (Button) rootView.findViewById(R.id.button_wombat);
        buttonGecko = (Button) rootView.findViewById(R.id.button_gecko);
        buttonCoralSnake = (Button) rootView.findViewById(R.id.button_coral_snake);
        buttonTortoise = (Button) rootView.findViewById(R.id.button_tortoise);
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
            Log.d(LOG_TAG,"Entra onclick");
            switch(v.getId()){

                case R.id.button_brown_bear:
                    mListener.onClickButtonEvent(0);
                break;

                case R.id.button_grizzly_bear:
                    mListener.onClickButtonEvent(1);
                break;

                case R.id.button_wombat:
                    mListener.onClickButtonEvent(2);
                    break;

                case R.id.button_gecko:
                    mListener.onClickButtonEvent(3);
                break;

                case R.id.button_coral_snake:
                    mListener.onClickButtonEvent(4);
                break;

                case R.id.button_tortoise:
                    mListener.onClickButtonEvent(5);;
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
