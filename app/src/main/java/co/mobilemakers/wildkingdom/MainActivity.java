package co.mobilemakers.wildkingdom;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity implements OptionsFragment.OnFragmentInteractionListener{

    public static final String LOG_TAG = MainActivity.class.getName();
    public static final String [] animalsName = {"Brown Bear" , "Grizzly Bear", "Wombat", "Gecko", "Coral Snake", "Tortoise"};
    public static final int imageVeiwsAnimalIds[]= {R.drawable.brown_bear, R.drawable.grizzly_bear, R.drawable.wombat, R.drawable.gecko, R.drawable.coral_snake,R.drawable.tortoise};
    public static final String [] habitat = {"Temperate and coniferous forest, open fields, mountain highlands, semi-desert, desert, and tundra.",
                                              "Grizzly bears are found many different habitats, from dense forests to subalpine meadows, open plains and arctic tundra.",
                                            "Forests, mountains, and grasslands",
                                            "Forest, Desert, Mountain",
                                            "They prefer wooded areas, marshes, or places with loose soil",
                                            "Deserts, forests, and grasslands."};
    public static  final String [] descriptions = {"Bears found in parts of coastal Alaska are called Kodiak or Alaskan brown bears and tend to be the largest of the species. This is from eating salmon rich in fat every summer. The Alaskan Peninsular brown bear has a much smaller range, just the western tip of the Alaskan peninsula.",
                                                    "Grizzly bears (Ursus arctos horribilis) have concave faces, a distinctive hump on their shoulders, and long claws about two to four inches long. Both the hump and the claws are traits associated with a grizzly bear’s exceptional digging ability. Grizzlies are often dark brown, but can vary from very light cream to black. ",
                                                    "Wombats are one of the oddest-looking animals you'll ever see! Native to Australia, the comical animals look like short, stocky bears. But wombats are really marsupials, related to koalas and kangaroos. They are either sandy brown or grayish black to blend in with the landscape and avoid predators. The sturdy wombat is most active in the early evening and at night.",
                                                    "Geckos are reptiles and are found on all the continents except Antarctica. These colorful lizards have adapted to habitats from rain forests, to deserts, to cold mountain slopes. ",
                                                    "There are many varieties of coral snakes throughout the Americas, but we will address the USA snakes. The most common species in the United States have a universal red-yellow-black-yellow pattern. Not all coral snakes have the same color scheme, so it is important to be familiar with the snakes specific to your region. At its longest, an adult can measure around thirty inches.",
                                                     "A land-dweller that eats low-growing shrubs, grasses, and even cactus. Tortoises do not have webbed feet; their feet are round and stumpy for walking on land. Tortoises that live in hot, dry habitats use their strong forelimbs to dig burrows. Then, when it’s too hot in the sun, they slip underground."   } ;

    OptionsFragment optionsFragment;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startOptionsFrament();


    }

    private void startOptionsFrament() {
        optionsFragment = new OptionsFragment();
        getFragmentManager().beginTransaction().add(R.id.fragment_container,optionsFragment).commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClickButtonEvent(int animalPosition) {
        Log.d(LOG_TAG, "ButtonEvent");
        DescriptionFragment descriptionFragment = new DescriptionFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("animalPosition", animalPosition);
        descriptionFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, descriptionFragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
