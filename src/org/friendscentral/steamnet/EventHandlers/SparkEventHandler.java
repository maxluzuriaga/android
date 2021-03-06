package org.friendscentral.steamnet.EventHandlers;

import org.friendscentral.steamnet.IdeaBucket;
import org.friendscentral.steamnet.IndexGrid;
import org.friendscentral.steamnet.R;
import org.friendscentral.steamnet.Activities.IdeaDetailActivity;
import org.friendscentral.steamnet.Activities.MainActivity;
import org.friendscentral.steamnet.Activities.SparkDetailActivity;
import org.friendscentral.steamnet.BaseClasses.Idea;
import org.friendscentral.steamnet.BaseClasses.Jawn;
import org.friendscentral.steamnet.BaseClasses.Spark;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.DragEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class SparkEventHandler {
	static final String EXTRA_MESSAGE = null;
	final static int DETAIL_VIEW_RETURN = 5;
	MainActivity mainActivity;
	Context context;
	LinearLayout mainLayout;
	IdeaBucket ideaBucket;
	GridView gridview;
	IndexGrid indexGrid;
	
	public SparkEventHandler(MainActivity main, LinearLayout m, IdeaBucket b, GridView g, IndexGrid i) {
		mainActivity = main;
		context = (Context) main;
		mainLayout = m;
		ideaBucket = b;
		gridview = g;
		indexGrid = i;
		
		initializeIndexGridLayout();
	}
	
	public void openDetailView(Jawn j) {
		mainActivity.getSparkWizard().revertWizard(new View(context));
		if(j.getType() == 'S'){
	    	Intent intent = new Intent(context, SparkDetailActivity.class);
	    	//intent.putExtra(EXTRA_MESSAGE, b);
	    	Spark s = j.getSelfSpark();
	    	intent.putExtra("id", s.getId());
	    	mainActivity.startActivityForResult(intent, DETAIL_VIEW_RETURN);
		} else if(j.getType() == 'I'){
	    	Intent intent = new Intent(context, IdeaDetailActivity.class);
	    	//intent.putExtra(EXTRA_MESSAGE, b);
	    	Idea i = j.getSelfIdea();
	    	intent.putExtra("id", i.getId());
	    	mainActivity.startActivityForResult(intent, DETAIL_VIEW_RETURN);
		}
    }
    
    public void initializeIndexGridLayout() {
    	gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                openDetailView(indexGrid.getJawnAt(position)); //NEED POLYMORPHIC openDetailView
            }
        });
    	
    	gridview.setOnItemLongClickListener(new OnItemLongClickListener() {
			public boolean onItemLongClick(AdapterView<?> adapterView, View view,
					int pos, long id) {
				if (indexGrid.getAdapter().getJawnAt(pos).getType() == 'S') {
					final int SPARK_INFO_ID = 4;
					ClipData data = ClipData.newPlainText("", "");
					RelativeLayout holder = (RelativeLayout) view;
					LinearLayout spark = (LinearLayout) holder.findViewById(SPARK_INFO_ID);
					View sparkContent = ((FrameLayout) spark.getChildAt(0)).getChildAt(0);
					if (sparkContent.getClass().getName().equals("android.widget.TextView")) {
						sparkContent.setBackgroundColor(Color.WHITE);
					}
			        DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(sparkContent);
			        view.startDrag(data, shadowBuilder, sparkContent, 0);
			        
			        SparkDragListener sdl = new SparkDragListener();
			        sdl.setPos(pos);
			        sdl.setIndexGridContext(indexGrid);
			        
			        mainLayout.findViewById(R.id.Sidebar).setOnDragListener(sdl);
			        
					return true;
				}
				return false;
			}
    	});

    }
    
    public void clearEventHandlers() {
    	gridview.setOnItemClickListener(null);
    	gridview.setOnItemLongClickListener(null);
    }
    
    private class SparkDragListener implements OnDragListener {
    	int pos;
    	IndexGrid indexGridContext;
    	
		@Override
		public boolean onDrag(View view, DragEvent dragEvent) {
			LinearLayout ib = (LinearLayout) mainLayout.findViewById(R.id.IdeaBucket);
			
			switch (dragEvent.getAction()) {
		      	case DragEvent.ACTION_DRAG_STARTED:
		      		ib.setBackgroundResource(R.drawable.idea_bucket_drop_background);
		      		break;
		      	case DragEvent.ACTION_DRAG_ENTERED:
		      		ib.setBackgroundResource(R.drawable.idea_bucket_drop_background);
		      		break;
		      	case DragEvent.ACTION_DRAG_EXITED:
		      		ib.setBackgroundResource(0);
		      		break;
		      	case DragEvent.ACTION_DROP:
		      		ib.setBackgroundResource(0);
		      		
		      		/*
		      		 * Need to clear the other listeners so it can't be re-added to the bucket
		      		 * (currently fixed by making the dropzone of the bucket the entire sidebar)
		      		 */
		      		
		      		ideaBucket.addSpark(indexGridContext.getJawnAt(pos).getSelfSpark());
		    		break;
		      	case DragEvent.ACTION_DRAG_ENDED:
		      		//nothing
		      	default:
		      		break;
		      }
			return false;
		}
		
		public void setPos(int n) {
			pos = n;
		}
		
		public void setIndexGridContext(IndexGrid i) {
			indexGridContext = i;
		}
 
    }
}
