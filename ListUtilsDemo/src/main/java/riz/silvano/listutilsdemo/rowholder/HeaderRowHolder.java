package riz.silvano.listutilsdemo.rowholder;

import android.view.View;
import android.widget.TextView;

import butterknife.InjectView;
import butterknife.Views;
import riz.silvano.listutils.RowHolder;
import riz.silvano.listutilsdemo.R;
import riz.silvano.listutilsdemo.model.Header;

/**
 * Implementation of {@link riz.silvano.listutils.RowHolder} for the {@link Header}
 *
 * Created by mele on 08/09/2013.
 */
public class HeaderRowHolder implements RowHolder<Header>
{

    @InjectView(R.id.tvHeader)
    TextView tvHeader;

    @Override
    public void init(Header h, View view)
    {
        Views.inject(this, view);
        this.tvHeader.setText(h.getTitle());
    }
}
