package android.app.tempapplication.views;

import android.app.tempapplication.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by PC on 7/9/2016.
 */
public class ToolbarView extends LinearLayout {

    /**
     * UI
     */
    ImageView imgMenu;

    /**
     * store
     */
    boolean isShowMenu;

    public ToolbarView(Context context) {
        super(context);
    }

    public ToolbarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(context, attrs, 0);
    }

    public ToolbarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(context, attrs, defStyleAttr);
    }

    private void initViews(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.ToolbarView, defStyleAttr, 0);

        try {
            isShowMenu = a.getBoolean(R.styleable.ToolbarView_show_button_back, true);
        } finally {
            a.recycle();
        }

        LayoutInflater.from(context).inflate(R.layout.toolbar_layout, this);

        imgMenu = (ImageButton) this.findViewById(R.id.img_menu);
        if (isShowMenu) {
            imgMenu.setVisibility(VISIBLE);
        } else {
            imgMenu.setVisibility(GONE);
        }
    }

    public ImageView getImgMenu() {
        return imgMenu;
    }

    public void setImgMenu(ImageView imgMenu) {
        this.imgMenu = imgMenu;
    }
}
