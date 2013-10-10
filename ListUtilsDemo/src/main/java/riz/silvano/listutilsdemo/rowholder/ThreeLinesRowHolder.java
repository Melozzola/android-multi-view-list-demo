package riz.silvano.listutilsdemo.rowholder;

import android.view.View;
import android.widget.TextView;

import butterknife.InjectView;
import butterknife.Views;
import riz.silvano.listutils.RowHolder;
import riz.silvano.listutilsdemo.R;
import riz.silvano.listutilsdemo.model.ThreeValues;

/**
 * Implementation of {@link riz.silvano.listutils.RowHolder} for the {@link riz.silvano.listutilsdemo.model.ThreeValues}
 *
 * Created by mele on 08/09/2013.
 */
public class ThreeLinesRowHolder implements RowHolder<ThreeValues>
{

    @InjectView(R.id.tvValue1)
    TextView tvValue1;

    @InjectView(R.id.tvValue2)
    TextView tvValue2;

    @InjectView(R.id.tvValue3)
    TextView tvValue3;

    @Override
    public void init(ThreeValues threeValues, View view)
    {
        Views.inject(this, view);

        tvValue1.setText(threeValues.getValue1());
        tvValue2.setText(String.valueOf(threeValues.getValue2()));
        tvValue3.setText(threeValues.getValue3() ? "Yes" : "No");
    }
}
