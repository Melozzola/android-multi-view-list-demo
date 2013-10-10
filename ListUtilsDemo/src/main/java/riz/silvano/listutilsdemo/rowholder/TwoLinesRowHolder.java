package riz.silvano.listutilsdemo.rowholder;

import android.view.View;
import android.widget.TextView;

import butterknife.InjectView;
import butterknife.Views;
import riz.silvano.listutils.RowHolder;
import riz.silvano.listutilsdemo.R;
import riz.silvano.listutilsdemo.model.TwoValues;

/**
 * Implementation of {@link riz.silvano.listutils.RowHolder} for the {@link riz.silvano.listutilsdemo.model.TwoValues}
 *
 * Created by mele on 08/09/2013.
 */
public class TwoLinesRowHolder implements RowHolder<TwoValues>
{

    @InjectView(R.id.tvValue1)
    TextView tvValue1;

    @InjectView(R.id.tvValue2)
    TextView tvValue2;

    @Override
    public void init(TwoValues twoValues, View view)
    {
        Views.inject(this, view);

        tvValue1.setText(twoValues.getValue1());
        tvValue2.setText(String.valueOf(twoValues.getValue2()));

    }
}
