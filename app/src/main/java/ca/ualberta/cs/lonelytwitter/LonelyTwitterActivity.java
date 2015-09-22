package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>(); // instead of loading from file
    private ArrayAdapter<Tweet> adapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				tweets.add(new NormalTweet(text)); // put tweets into ArrayList
                saveInFile();
                adapter.notifyDataSetChanged();
				//saveInFile(text, new Date(System.currentTimeMillis()));
				//finish(); // closing the activity

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		//String[] tweets = loadFromFile(); // load all tweets stored in file into array
        loadFromFile(); // before making adapter
        adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets); // put array inside array adapter
		oldTweetsList.setAdapter(adapter); // put adapter into list view
	}

	private void loadFromFile() {
		//ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			/*String line = in.readLine();
			while (line != null) {
				tweets.add(line);
				line = in.readLine();
			} */
            Gson gson = new Gson();
            //Following line based on http://google-gson.googlecode.com/svn/tags/gson-1.7.2/docs/javadocs/com/google/gson/Gson.html retrieved Sep 21, 2015
            Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
            tweets = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
            //throw new RuntimeException(e);
            tweets = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
            throw new RuntimeException(e);
		}
		//return tweets.toArray(new String[tweets.size()]);
	}
	
	private void saveInFile() {
		try {
            /* open file for output, creates it if it doesn't exist
             * second argument is the file opening mode
             * append -> add stuff to end of file
             * o -> delete everything in file
             */
			FileOutputStream fos = openFileOutput(FILENAME, 0);
			//fos.write(new String(date.toString() + " | " + text)
					//.getBytes());
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(tweets, writer);
            writer.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
            throw new RuntimeException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
            throw new RuntimeException(e);
		}
	}
}