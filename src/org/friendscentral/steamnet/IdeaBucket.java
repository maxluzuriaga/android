package org.friendscentral.steamnet;

import java.util.ArrayList;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class IdeaBucket {
	LinearLayout layout;
	Context context;
	ArrayList<SimpleSpark> sparks;
	ImageView[] imageViews;
	
	public void initIdeaGrid(LinearLayout l, Context c) {
		layout = l;
		context = c;
		sparks = new ArrayList<SimpleSpark>(4);
		
		imageViews = new ImageView[4];
		imageViews[0] =	(ImageView) layout.findViewById(R.id.first_image);
		imageViews[1] = (ImageView) layout.findViewById(R.id.second_image);
		imageViews[2] = (ImageView) layout.findViewById(R.id.third_image);
		imageViews[3] = (ImageView) layout.findViewById(R.id.fourth_image);
	}
	
	public void addSpark(SimpleSpark ss) {
		if (sparks.size() < 4) {
			sparks.add(ss);
			imageViews[sparks.size() - 1].setImageResource(ss.getId());
		}
	}
	
	public void removeSpark(int pos) {
		if (sparks.size() > 0) {
			sparks.remove(pos);
			for (int i = pos; i < imageViews.length - 1; i++) {
				imageViews[i].setImageDrawable(imageViews[i + 1].getDrawable());
			}
			imageViews[3].setImageResource(0);
		}
	}
	
	public ImageView[] getImageViews() {
		return imageViews;
	}
}