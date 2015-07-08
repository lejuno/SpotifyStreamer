package com.lejuno.spotifystreamer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nomoto on 7/2/15.
 */
public class SearchFragment extends Fragment {
    ArrayAdapter<String> mSearchAdapter;


    public SearchFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        // Create some dummy data for the ListView.  Here's a sample weekly forecast
        String[] data = {
                "Xuxa",
                "Kelly Key",
                "Raimundos",
                "Los Hermanos",
                "Kate Perry",
                "2NE1",
                "Girls Generation"
        };

        List<String> searchResult = new ArrayList<String>(Arrays.asList(data));

        mSearchAdapter =
                new ArrayAdapter<String>(
                        getActivity(), // The current context (this activity)
                        R.layout.list_item_search, // The name of the layout ID.
                        R.id.list_item_search_textview, // The ID of the textview to populate.
                        searchResult);

        View rootView = inflater.inflate(R.layout.searchfragment_main, container, false);

        // Get a reference to the ListView, and attach this adapter to it.
        ListView listView = (ListView) rootView.findViewById(R.id.listview_search);
        listView.setAdapter(mSearchAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String searchItem = mSearchAdapter.getItem(position);
                //Intent intent = new Intent(getActivity(), DetailActivity.class)
                //        .putExtra(Intent.EXTRA_TEXT, searchItem);
                //startActivity(intent);
                Toast.makeText(getActivity(), searchItem, Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }
}
