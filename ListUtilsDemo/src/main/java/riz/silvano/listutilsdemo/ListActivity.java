package riz.silvano.listutilsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.Views;
import riz.silvano.listutils.ItemWrapper;
import riz.silvano.listutils.MultiItemListAdapter;
import riz.silvano.listutilsdemo.model.Header;
import riz.silvano.listutilsdemo.model.OneValue;
import riz.silvano.listutilsdemo.model.ThreeValues;
import riz.silvano.listutilsdemo.model.TwoValues;

/**
 * Example of activity having a multi view list.
 * <p/>
 * Created by mele on 08/09/2013.
 */
public class ListActivity extends Activity implements AdapterView.OnItemLongClickListener
{

    @InjectView(R.id.lvMultiItem)
    ListView lvMultiItem;

    MultiItemListAdapter adapter;
    ListViewHelper listViewHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        Views.inject(this);

        listViewHelper = new ListViewHelper();
        adapter = new MultiItemListAdapter(listViewHelper, getLayoutInflater(), listViewHelper);
        lvMultiItem.setAdapter(adapter);
        lvMultiItem.setOnItemLongClickListener(this);
        adapter.addItems(fetchData());
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

        data.add(new ItemWrapper(new Header("Header 1")));

        OneValue oneValue;
        TwoValues twoValues;
        ThreeValues threeValues;
        Header header;
        for (int i = 0; i < 40; i++)
        {
            if (i == 20)
            {
                header = new Header("Header 2");
                data.add(new ItemWrapper(header));
            }
            else if (i % 5 == 0)
            {
                threeValues = new ThreeValues("val " + i, i, i == 5 ? true : false);
                data.add(new ItemWrapper(threeValues));
            } else if (i % 2 == 0)
            {
                twoValues = new TwoValues("val " + i, i);
                data.add(new ItemWrapper(twoValues));
            } else
            {
                oneValue = new OneValue("val " + i);
                data.add(new ItemWrapper(oneValue));
            }

        }

        return data;

    }

}
