package riz.silvano.listutilsdemo.rowholder;

import android.view.View;
import android.widget.TextView;

import butterknife.InjectView;
import butterknife.Views;
import riz.silvano.listutils.RowHolder;
import riz.silvano.listutilsdemo.R;
import riz.silvano.listutilsdemo.model.Item;

/**
 * Created by mele on 11/10/2013.
 */
public class ItemRowHolder implements RowHolder<Item>
{

    @InjectView(R.id.tvDescription) TextView tvDescription;
    @InjectView(R.id.tvQuantity) TextView tvQuantity;
    @InjectView(R.id.tvDate) TextView tvDate;

    @Override
    public void init(Item item, View view)
    {

        Views.inject(this, view);

        tvDescription.setText(item.getDescription());
        tvQuantity.setText(String.format("%d",item.getQuantity()));
        tvDate.setText(item.getDate().toString());

    }

}
