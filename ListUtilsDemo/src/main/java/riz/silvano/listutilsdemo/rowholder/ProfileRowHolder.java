package riz.silvano.listutilsdemo.rowholder;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import butterknife.InjectView;
import butterknife.Views;
import riz.silvano.listutils.RowHolder;
import riz.silvano.listutilsdemo.R;
import riz.silvano.listutilsdemo.model.Profile;

/**
 * Created by mele on 11/10/2013.
 */
public class ProfileRowHolder implements RowHolder<Profile>
{

    @InjectView(R.id.imgCover) ImageView imgCover;
    @InjectView(R.id.imgProfile) ImageView imgProfile;
    @InjectView(R.id.tvName) TextView tvName;
    @InjectView(R.id.tvLocation) TextView tvLocation;

    @Override
    public void init(Profile profile, View view)
    {

        Views.inject(this, view);

        Picasso.with(view.getContext()).
                load(profile.getCoverImgUrl()).
                fit().
                //placeholder(R.drawable.ic_launcher).
                into(imgCover);

        Picasso.with(view.getContext()).
                load(profile.getProfileImgUrl()).
                transform(new RoundedTransformation(25,3)).
                //placeholder(R.drawable.ic_launcher).
                into(imgProfile);

        tvName.setText(profile.getName());
        tvLocation.setText(profile.getLocation());

    }
}

class RoundedTransformation implements Transformation
{
    private final int radius;
    private final int margin;  // dp

    // radius is corner radii in dp
    // margin is the board in dp
    public RoundedTransformation(final int radius, final int margin) {
        this.radius = radius;
        this.margin = margin;
    }

    @Override
    public Bitmap transform(final Bitmap source) {
        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));

        Bitmap output = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        canvas.drawRoundRect(new RectF(margin, margin, source.getWidth() - margin, source.getHeight() - margin), radius, radius, paint);

        if (source != output) {
            source.recycle();
        }

        return output;
    }

    @Override
    public String key() {
        return "rounded";
    }
}
