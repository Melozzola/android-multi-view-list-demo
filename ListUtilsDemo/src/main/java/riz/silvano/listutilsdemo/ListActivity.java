package riz.silvano.listutilsdemo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.hb.views.PinnedSectionListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.InjectView;
import butterknife.Views;
import riz.silvano.listutils.ItemWrapper;
import riz.silvano.listutils.MultiItemListAdapter;
import riz.silvano.listutils.RowHolderFacade;
import riz.silvano.listutils.ViewTypes;
import riz.silvano.listutilsdemo.model.Actions;
import riz.silvano.listutilsdemo.model.Header;
import riz.silvano.listutilsdemo.model.Item;
import riz.silvano.listutilsdemo.model.OneValue;
import riz.silvano.listutilsdemo.model.Profile;
import riz.silvano.listutilsdemo.model.ThreeValues;
import riz.silvano.listutilsdemo.model.TwoValues;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshAttacher;

/**
 * Example of activity having a multi view list.
 * <p/>
 * Created by mele on 08/09/2013.
 */
public class ListActivity extends Activity implements AdapterView.OnItemLongClickListener,
                                                      PullToRefreshAttacher.OnRefreshListener
{

    @InjectView(R.id.lvMultiItem)
    ListView lvMultiItem;

    MultiItemListAdapter adapter;
    ListViewHelper listViewHelper;

    private PullToRefreshAttacher mPullToRefreshAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        Views.inject(this);

        /**
         * Here we create a PullToRefreshAttacher manually without an Options instance.
         * PullToRefreshAttacher will manually create one using default values.
         */
        mPullToRefreshAttacher = PullToRefreshAttacher.get(this);

        listViewHelper = new ListViewHelper();
        //adapter = new MultiItemListAdapter(listViewHelper, getLayoutInflater(), listViewHelper);
        //adapter = new ListViewAdapter(listViewHelper, getLayoutInflater(), listViewHelper);
        adapter = new StickyListHeadersListViewAdapter(listViewHelper, getLayoutInflater(), listViewHelper);
        lvMultiItem.setAdapter(adapter);
        lvMultiItem.setOnItemLongClickListener(this);
        adapter.addItems(fetchData());

        // Set the Refreshable View to be the ListView and the refresh listener to be this.
        mPullToRefreshAttacher.addRefreshableView(lvMultiItem, this);

    }

    @Override
    public void onRefreshStarted(View view)
    {
        if( BuildConfig.DEBUG )
        {
            Log.d(Constants.LOG_TAG, "Refresh");
        }

        /**
         * Simulate Refresh with 4 seconds sleep
         */
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(Constants.SIMULATED_REFRESH_LENGTH);
                } catch (InterruptedException e) {
                    Log.e(Constants.LOG_TAG,"Task interrupted",e);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                super.onPostExecute(result);

                // Notify PullToRefreshAttacher that the refresh has finished
                mPullToRefreshAttacher.setRefreshComplete();
            }
        }.execute();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
    {
        adapter.deleteItem(position);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId())
        {
            case R.id.add_header:
                adapter.addItem(new ItemWrapper(new Header("Header")));
                return true;
            case R.id.add_one:
                adapter.addItem(new ItemWrapper(new OneValue("value")));
                return true;
            case R.id.add_two:
                adapter.addItem(new ItemWrapper(new TwoValues("value",1)));
                return true;
            case R.id.add_three:
                adapter.addItem(new ItemWrapper(new ThreeValues("value", 1, true)));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    private List<ItemWrapper> fetchData()
    {
        List<ItemWrapper> data = new ArrayList<ItemWrapper>();


        Profile profile = new Profile();
        profile.setCoverImgUrl("http://cdn.architectism.com/wp-content/uploads/2011/10/Fashion-Bar-BerlinRodeo-1-200x100.jpg");
        profile.setProfileImgUrl("http://www.taaz.com/images/R50H50W/8BD5A4BEAC9388BEDC75CCACAAB13552.jpg");
        profile.setName("Adriana Lima");
        profile.setLocation("Los Angeles");
        data.add(new ItemWrapper(profile));

        Actions actions = new Actions();
        data.add(new ItemWrapper(actions));

        Item item;
        for (int i = 0; i < 40; i++)
        {
            item = new Item();
            item.setDate(new Date());
            item.setDescription("Item " + i);
            item.setQuantity(i);

            data.add(new ItemWrapper(item));
        }

        return data;

    }

    public class PinnedSectionListViewAdapter extends MultiItemListAdapter implements PinnedSectionListView.PinnedSectionListAdapter
    {

        PinnedSectionListViewAdapter(ViewTypes viewTypes, LayoutInflater inflater, RowHolderFacade rowHolderFacade)
        {
            super(viewTypes, inflater, rowHolderFacade);
        }

        @Override
        public boolean isItemViewTypePinned(int i)
        {
            return i == listViewHelper.getType(Actions.class);
        }
    }


    public class StickyListHeadersListViewAdapter extends MultiItemListAdapter implements StickyListHeadersAdapter
    {
        StickyListHeadersListViewAdapter(ViewTypes viewTypes, LayoutInflater inflater, RowHolderFacade rowHolderFacade)
        {
            super(viewTypes, inflater, rowHolderFacade);
        }


        @Override
        public View getHeaderView(int i, View view, ViewGroup viewGroup)
        {
            return null;
        }

        @Override
        public long getHeaderId(int i)
        {
            return 0;
        }
    }

}
