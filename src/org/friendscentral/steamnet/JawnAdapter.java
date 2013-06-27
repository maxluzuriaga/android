package org.friendscentral.steamnet;

import org.friendscentral.steamnet.BaseClasses.Idea;
import org.friendscentral.steamnet.BaseClasses.Jawn;
import org.friendscentral.steamnet.BaseClasses.Spark;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class JawnAdapter extends BaseAdapter {
    private Context mContext;
<<<<<<< HEAD
=======
    private Integer[] mThumbIds;
>>>>>>> upstream/master
    private Jawn[] jawns;
    private int image_size;

    /**
     * 
     * @param Context
     * @param Jawn[]
     * @param int - image size
     */
    public JawnAdapter(Context c, Jawn[] j, int size) {
        mContext = c;
        Log.v("LENGTH", Integer.toString(j.length));
<<<<<<< HEAD
=======
        mThumbIds = new Integer[j.length];
>>>>>>> upstream/master
        image_size = size;
        //initSparks(s);
        jawns = j;
    }

	// create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
    	View v = null;
    	//									== 'S'
    	if (getJawnAt(position).getType() == "S".charAt(0)) {
	    	Spark spark = getJawnAt(position).getSelfSpark();
	    	char con = spark.getContentType();
	    	View contentView = null;
	    	LinearLayout sparkInfo = new LinearLayout(mContext);
	    	
	    	if (con == "I".charAt(0)) {
	    		
		        ImageView imageView;
<<<<<<< HEAD
		        imageView = new ImageView(mContext);
		        imageView.setLayoutParams(new GridView.LayoutParams(image_size, image_size));
		        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		        imageView.setPadding(8, 8, 8, 8);
=======
		        if (convertView == null) {  // if it's not recycled, initialize some attributes
		            imageView = new ImageView(mContext);
		            imageView.setLayoutParams(new GridView.LayoutParams(image_size, image_size));
		            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		            imageView.setPadding(8, 8, 8, 8);
		        } else {
		            imageView = (ImageView) convertView;
		        }
>>>>>>> upstream/master
		        /*
		         * This part needs to be updated with the imgur API
		         * Something like imageView.setImageResource(imgurAPI.getImage())
		         * Might run into some trouble because its not a drawable?
		         */
		        imageView.setImageResource(R.drawable.btn_blue_picture);
		        contentView = imageView;
		        
	    	} else if (con == "V".charAt(0)) {
	    		/*
	    		 * Normally within an app, embedded Youtube videos either begin playing or launch the Youtube app on click
	    		 * Within the spark grid, we don't need that functionality
	    		 * Therefore the manifestation of the video will just be a thumbnail (in the grid)
	    		 * The thumbnail will need to be received from the Youtube API, however
	    		 * In the Detail View, it will be a normal, dynamic video
	    		 */
	    		
		        ImageView imageView;
<<<<<<< HEAD
		        imageView = new ImageView(mContext);
		        imageView.setLayoutParams(new GridView.LayoutParams(image_size, image_size));
		        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		        imageView.setPadding(8, 8, 8, 8);
=======
		        if (convertView == null) {  // if it's not recycled, initialize some attributes
		            imageView = new ImageView(mContext);
		            imageView.setLayoutParams(new GridView.LayoutParams(image_size, image_size));
		            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		            imageView.setPadding(8, 8, 8, 8);
		        } else {
		            imageView = (ImageView) convertView;
		        }
>>>>>>> upstream/master
		        /*
		         * This part needs to be updated with the youtube API
		         * Something like setImageResource(youtubeAPI.getThumbnail())
		         */
		        imageView.setImageResource(R.drawable.btn_blue_picture);
		        contentView = imageView;
		        
	    	} else if (con == "A".charAt(0)) {
	    		/*
	    		 * Audio is pretty much the same deal as the Video.
	    		 * It's a little different in that most of the soundcloud generated thumbnails are gonna be pretty similar.
	    		 * For that reason, this view is actually a layout, housing the Title of the spark and the thumbnail
	    		 */
	    		
	    		LinearLayout layout = new LinearLayout(mContext);
	    		
	    		/*
	    		 * First make the title:
	    		 */
	    		TextView title;
<<<<<<< HEAD
		        title = new TextView(mContext);
		        title.setLayoutParams(new GridView.LayoutParams(50, image_size));
		        title.setPadding(8, 8, 8, 8);
	    		
	    		/*
	    		 * Uncomment this and clean it up once it's working:
	    		 * String audioTitle = soundcloudAPI.getTrackTitle();
	    		 * title.setText(audioTitle, 0, Math.min(audioTitle.length(), 100);
	    		 */
	    		
=======
	    		if (convertView == null) {  // if it's not recycled, initialize some attributes
		            title = new TextView(mContext);
		            title.setLayoutParams(new GridView.LayoutParams(50, image_size));
		            title.setPadding(8, 8, 8, 8);
		        } else {
		            title = (TextView) convertView;
		        }
	    		
	    		/*
	    		 * Uncomment this once it's working:
	    		 */
	    		//title.setText(soundcloudAPI.getTrackTitle, 0, 200);
>>>>>>> upstream/master
	    		layout.addView(title);
	    		
	    		/*
	    		 * Then add the thumbnail:
	    		 */
	    		ImageView imageView;
<<<<<<< HEAD
		        imageView = new ImageView(mContext);
		        imageView.setLayoutParams(new GridView.LayoutParams(image_size - 50, image_size - 50));
		        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		        imageView.setPadding(8, 8, 8, 8);
=======
		        if (convertView == null) {
		            imageView = new ImageView(mContext);
		            imageView.setLayoutParams(new GridView.LayoutParams(image_size - 50, image_size - 50));
		            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		            imageView.setPadding(8, 8, 8, 8);
		        } else {
		            imageView = (ImageView) convertView;
		        }
>>>>>>> upstream/master
		        /*
	    		 * Placeholder until Soundcloud API is working
	    		 */
		        imageView.setImageResource(R.drawable.btn_blue_audio);
		        layout.addView(imageView);
		        
	    		contentView = layout;
	    		
<<<<<<< HEAD
	    	} else if (con == "T".charAt(0) /* DIRTY FIX!!!! */ || con == "Q".charAt(0) || con == "P".charAt(0)) {
	    		
	    		TextView textview;
		        textview = new TextView(mContext);
		        textview.setLayoutParams(new GridView.LayoutParams(image_size, image_size));
		        textview.setPadding(8, 8, 8, 8);
	    		
	    		String content = spark.getContent();
	    		textview.setText(content.toCharArray(), 0, Math.min(200, (content.length() - 1)));
=======
	    	} else if (con == "T".charAt(0)) {
	    		
	    		TextView textview;
	    		if (convertView == null) {  // if it's not recycled, initialize some attributes
		            textview = new TextView(mContext);
		            textview.setLayoutParams(new GridView.LayoutParams(image_size, image_size));
		            textview.setPadding(8, 8, 8, 8);
		        } else {
		            textview = (TextView) convertView;
		        }
	    		
	    		textview.setText(spark.getContent().toCharArray(), 0, 200);
>>>>>>> upstream/master
	    		contentView = textview;
	    		
	    	} else if (con == "C".charAt(0)) {
	    		
	    		/*
	    		 * At the moment, code snippets are handled just like text. Eventually they will make use of Github 
	    		 */
	    		TextView textview;
<<<<<<< HEAD
		        textview = new TextView(mContext);
		        textview.setLayoutParams(new GridView.LayoutParams(image_size, image_size));
		        textview.setPadding(8, 8, 8, 8);
	    		
	    		String content = spark.getContent();
	    		textview.setText(content.toCharArray(), 0, Math.min(200, (content.length() - 1)));
=======
	    		if (convertView == null) {  // if it's not recycled, initialize some attributes
		            textview = new TextView(mContext);
		            textview.setLayoutParams(new GridView.LayoutParams(image_size, image_size));
		            textview.setPadding(8, 8, 8, 8);
		        } else {
		            textview = (TextView) convertView;
		        }
	    		
	    		textview.setText(spark.getContent().toCharArray(), 0, 200);
>>>>>>> upstream/master
	    		contentView = textview;
	    		
	    	} else if (con == "L".charAt(0)) {
	    		/*
	    		 * Not sure how to handle this one
	    		 * In the mockup, Colin had it as a screenshot of the page.
	    		 * IF that proves too difficult to generate, we can also use the fav_icon with the website
	    		 * Either way, it looks like it'll turn out similar to the soundcloud implementation
	    		 */
	    		
	    		LinearLayout layout = new LinearLayout(mContext);
	    		
	    		/*
	    		 * First make the title:
	    		 */
	    		TextView title;
<<<<<<< HEAD
		        title = new TextView(mContext);
		        title.setLayoutParams(new GridView.LayoutParams(50, image_size));
		        title.setPadding(8, 8, 8, 8);
=======
	    		if (convertView == null) {  // if it's not recycled, initialize some attributes
		            title = new TextView(mContext);
		            title.setLayoutParams(new GridView.LayoutParams(50, image_size));
		            title.setPadding(8, 8, 8, 8);
		        } else {
		            title = (TextView) convertView;
		        }
>>>>>>> upstream/master
	    		
	    		/*
	    		 * Get the page title
	    		 * something like "Wikipedia - Kittens"
	    		 */
	    		//title.setText(soundcloudAPI.getTrackTitle, 0, 200);
	    		layout.addView(title);
	    		
	    		/*
	    		 * Then add the thumbnail:
	    		 */
	    		ImageView imageView;
<<<<<<< HEAD
		        imageView = new ImageView(mContext);
		        imageView.setLayoutParams(new GridView.LayoutParams(image_size - 50, image_size - 50));
		        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		        imageView.setPadding(8, 8, 8, 8);
=======
		        if (convertView == null) {
		            imageView = new ImageView(mContext);
		            imageView.setLayoutParams(new GridView.LayoutParams(image_size - 50, image_size - 50));
		            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		            imageView.setPadding(8, 8, 8, 8);
		        } else {
		            imageView = (ImageView) convertView;
		        }
>>>>>>> upstream/master
		        /*
	    		 * This is what will be set to the favicon or the screenshot:
	    		 */
		        imageView.setImageResource(R.drawable.btn_blue_audio);
		        layout.addView(imageView);
		        
	    		contentView = layout;
	    		
	    	}
	    	
<<<<<<< HEAD
	    	if (contentView != null) {
		    	sparkInfo.addView(contentView);
		    	
		    	String user = "by "+spark.getUser();
		    	TextView userInfo = new TextView(mContext);
		    	userInfo.setText(user.toCharArray(), 0, user.length() - 1);
		    	
		    	sparkInfo.addView(userInfo);
		    	
		    	String date = spark.getDate();
		    	TextView dateInfo = new TextView(mContext);
		    	dateInfo.setText(date);
		    	
		    	sparkInfo.addView(dateInfo);
		    	v = sparkInfo;
	    	} else {
	    		TextView t = new TextView(mContext);
	    		t.setText("Error with this one");
	    		Log.v("Content Type", String.valueOf(spark.getContentType()));
	    		v = t;
	    	}
=======
	    	sparkInfo.addView(contentView);
	    	
	    	String user = "by "+spark.getUser();
	    	TextView userInfo = new TextView(mContext);
	    	userInfo.setText(user.toCharArray(), 0, 50);
	    	
	    	sparkInfo.addView(userInfo);
	    	
	    	String date = spark.getDate();
	    	TextView dateInfo = new TextView(mContext);
	    	dateInfo.setText(date);
	    	
	    	sparkInfo.addView(dateInfo);
	    	
	    	v = sparkInfo;
>>>>>>> upstream/master
	    	
    	} else if (getJawns()[position].getType() == "I".charAt(0)) {
    		Idea idea = getJawnAt(position).getSelfIdea();
	    	@SuppressWarnings("unused")
			View contentView = null;
	    	LinearLayout ideaInfo = new LinearLayout(mContext);
	    	
	    	int numSparks = idea.getSparkIds().length;
	    	String num = ""+numSparks;
	    	TextView numInfo = new TextView(mContext);
<<<<<<< HEAD
	    	numInfo.setText(num.toCharArray(), 0, num.length() - 1);
=======
	    	numInfo.setText(num.toCharArray(), 0, 3);
>>>>>>> upstream/master
	    	ideaInfo.addView(numInfo);
    		
    		String user = "by "+idea.getUser();
	    	TextView userInfo = new TextView(mContext);
<<<<<<< HEAD
	    	userInfo.setText(user.toCharArray(), 0, user.length() - 1);
=======
	    	userInfo.setText(user.toCharArray(), 0, 50);
>>>>>>> upstream/master
	    	ideaInfo.addView(userInfo);
	    	
	    	String date = idea.getCreatedAt();
	    	TextView dateInfo = new TextView(mContext);
	    	dateInfo.setText(date);
	    	ideaInfo.addView(dateInfo);
    		
	    	v = ideaInfo;
    	}
    	
    	return v;
    }
<<<<<<< HEAD

    public int getCount() {
        return jawns.length;
=======
    
    /* public void initSparks(Spark[] s) {
	    for (int i = 0; i < s.length; i++) {
	    	mThumbIds[i] = s[i].getId();
	    }
    } */

    public int getCount() {
        return mThumbIds.length;
>>>>>>> upstream/master
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }
<<<<<<< HEAD
=======
  
    public Integer[] getIds() {
    	return mThumbIds;
    }
    
    public void setIds(Integer[] n) {
    	mThumbIds = n;
    }
>>>>>>> upstream/master
    
    public Jawn[] getJawns() {
    	return jawns;
    }
    
    public Jawn getJawnAt(int pos) {
    	return jawns[pos];
    }
    
    public void setJawns(Jawn[] j) {
    	jawns = j;
    }
    
    public void removeAtPosition(int pos) {
    	if (getJawns().length >= 1) {
	    	Jawn[] newSet = new Jawn[getJawns().length - 1];
	    	for (int i = 0; i < pos; i++) {
	    		newSet[i] = getJawns()[i];
	    	}
	    	for (int i = pos; i < getJawns().length - 1; i++) {
	    		newSet[i] = getJawns()[i + 1];
	    	}
	    	setJawns(newSet);
    	}
    }
    
    public void addAtPosition(Jawn j, int pos) {
    	Jawn[] newSet = new Jawn[getJawns().length - 1];
    	for (int i = 0; i < pos; i++) {
    		newSet[i] = getJawns()[i];
    	}
    	newSet[pos] = j;
    	for (int i = pos + 1; i < getJawns().length; i++) {
    		newSet[i] = getJawns()[i - 1];
    	}
    	setJawns(newSet);
    }
}