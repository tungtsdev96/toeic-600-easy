package tungts.hust.edu.toeic600.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class Utils {

    public static int convertNameToResId(Context context,String name, String folder){
        Resources res = context.getResources();
        return res.getIdentifier(name,folder,context.getPackageName());
    }

    public static int convertdpTopx(int dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        int px = (int) (dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }

}
