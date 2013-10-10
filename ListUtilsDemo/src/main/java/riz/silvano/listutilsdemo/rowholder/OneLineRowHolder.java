package riz.silvano.listutilsdemo.rowholder;

import android.view.View;
import android.widget.TextView;

import butterknife.InjectView;
import butterknife.Views;
import riz.silvano.listutils.RowHolder;
import riz.silvano.listutilsdemo.R;
import riz.silvano.listutilsdemo.model.OneValue;

/**
 * Implementation of {@link riz.silvano.listutils.RowHolder} for the {@link riz.silvano.listutilsdemo.model.OneValue}
 *
 * Created by mele on 08/09/2013.
 */
public class OneLineRowHolder implements RowHolder<OneValue>
{

    @InjectView(R.id.tvValue)
    TextView tvValue;

    @Override
    public void init(OneValue oneValue, View view)
    {
        Views.inject(this, view);
        this.tvValue.setText(oneValue.getValue());
    }
}
