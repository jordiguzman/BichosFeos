package appkite.jordiguzman.com.bichosfeos.informacion;

import android.content.Context;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Locale;

import appkite.jordiguzman.com.bichosfeos.R;
import appkite.jordiguzman.com.bichosfeos.touchImageView.provider.Microscopios;

/**
 * Created by Jordi Guzman on 11/01/2017.
 */

class CustomSwipeAdapter extends PagerAdapter {

    private Context context;



    CustomSwipeAdapter(Context context){

        this.context=context;
    }

    @Override
    public int getCount() {
        return Microscopios.microscopiosUrl.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view== object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout, container,false);
        ImageView imageView= (ImageView)item_view.findViewById(R.id.image_view);
        TextView textView= (TextView)item_view.findViewById(R.id.image_count);


        Glide.with(context)
                .load(Microscopios.microscopiosUrl[position])
                .asBitmap()
                .placeholder(R.drawable.foto_vacia)
                .into(imageView);
        String id= Locale.getDefault().getDisplayLanguage();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (!id.equals("English")){
                textView.setText(Microscopios.microscopiosNombre[position]);
            }else{
                textView.setText(Microscopios.microscopiosNombreEn[position]);
            }

        }
        container.addView(item_view);
        return item_view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
