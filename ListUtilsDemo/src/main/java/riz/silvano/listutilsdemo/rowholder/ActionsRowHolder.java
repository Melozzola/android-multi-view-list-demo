package riz.silvano.listutilsdemo.rowholder;

import android.view.View;
import android.widget.Button;

import butterknife.InjectView;
import butterknife.Views;
import riz.silvano.listutils.RowHolder;
import riz.silvano.listutilsdemo.R;
import riz.silvano.listutilsdemo.model.Actions;

/**
 * Created by mele on 11/10/2013.
 */
public class ActionsRowHolder implements RowHolder<Actions>
{

    @InjectView(R.id.btnActionOne) Button btnActionOne;
    @InjectView(R.id.btnActionTwo) Button btnActionTwo;

    @Override
    public void init(Actions actions, View view)
    {

        Views.inject(this, view);

        btnActionOne.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        btnActionTwo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

    }
}
