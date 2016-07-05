package android.app.tempapplication.utils;

import android.app.AlertDialog;
import android.app.tempapplication.interfaces.DialogButton1PressInterface;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;

/**
 * Created by Windows 7 on 1/4/2016.
 */
public class DialogUtil {
    /**
     * show dialog with only 1 button
     *
     * @param context                     the context
     * @param title                       title of dialog
     * @param message                     message want to show
     * @param positiveButtonText          button text
     * @param dialogButton1PressInterface interface to handle button press
     */
    public static void showOneButtonDialog(Context context, String title, String message, String positiveButtonText, final DialogButton1PressInterface dialogButton1PressInterface) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        if (!TextUtils.isEmpty(positiveButtonText)) {
            builder.setPositiveButton(positiveButtonText, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialogButton1PressInterface.onButton1Press();
                }
            });
        }
    }
}
