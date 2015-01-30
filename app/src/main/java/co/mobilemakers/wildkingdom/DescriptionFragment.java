package co.mobilemakers.wildkingdom;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DescriptionFragment extends Fragment {

    public static final String LOG_TAG = DescriptionFragment.class.getName();
    private Button buttonNextAnimal;
    private TextView textViewAnimalName;
    private TextView textViewHabitat;
    private TextView textViewDescription;
    private ImageView imageViewAnimal;
    private int animalPosition= -1;

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

    private OnFragmentInteractionListener mListener;

    public DescriptionFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_description, container, false);
        if(getArguments() != null) {
            animalPosition = getArguments().getInt("animalPosition");
        }

        Log.d(LOG_TAG, "Position: " + animalPosition);

        prepareViews(rootView);
        positioningAnimal();

        setButtonEvents();
        return rootView;
    }

    private void setButtonEvents() {
        buttonNextAnimal.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG, "Aqui proceso");
                animalPosition += 1;
                showNextAnimal();

            }
        });
    }

    private void showNextAnimal() {
        if(animalPosition < MainActivity.imageVeiwsAnimalIds.length) {
            positioningAnimal();
        } else {
            animalPosition = 0;
            positioningAnimal();
        }
    }

    private void positioningAnimal() {
        imageViewAnimal.setImageResource(MainActivity.imageVeiwsAnimalIds[animalPosition]);
        textViewAnimalName.setText(MainActivity.animalsName[animalPosition]);
        textViewHabitat.setText(MainActivity.habitat[animalPosition]);
        textViewDescription.setText(MainActivity.descriptions[animalPosition]);

    }

    private void prepareViews(View rootView) {
        buttonNextAnimal = (Button) rootView.findViewById(R.id.button_next_animal);
        textViewAnimalName = (TextView) rootView.findViewById(R.id.text_view_animal_name);
        textViewHabitat = (TextView) rootView.findViewById(R.id.text_view_habitat);
        textViewDescription = (TextView) rootView.findViewById(R.id.text_view_description);
        imageViewAnimal = (ImageView) rootView.findViewById(R.id.image_view_animal);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        try {
//            mListener = (OnFragmentInteractionListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
