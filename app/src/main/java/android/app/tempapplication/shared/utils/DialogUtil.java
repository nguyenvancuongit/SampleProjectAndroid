package android.app.tempapplication.shared.utils;

import android.app.AlertDialog;
import android.app.tempapplication.shared.interfaces.DialogButtonOkPressInterface;
import android.content.Context;
import android.text.TextUtils;

/**
 * Created by Windows 7 on 1/4/2016.
 */
public class DialogUtil {
    /**
     * show dialog with only 1 button
     *
     * @param context                      the context
     * @param title                        title of dialog
     * @param message                      message want to show
     * @param positiveButtonText           button text
     * @param dialogButtonOkPressInterface interface to handle button press
     */
    public static void showOneButtonDialog(Context context, String title, String message, String positiveButtonText, final DialogButtonOkPressInterface dialogButtonOkPressInterface) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        if (!TextUtils.isEmpty(positiveButtonText)) {
            builder.setPositiveButton(positiveButtonText, (dialog, which) -> {
                dialogButtonOkPressInterface.onButtonOkPress();
            });
        }
    }
}
