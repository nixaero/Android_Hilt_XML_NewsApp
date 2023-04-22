package mob.nereek.hiltapp.common.utils.ui

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar

object MessageUtils {
    fun showSnackbar(view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
    }

    fun showSnackbar(view: View, @StringRes messageId: Int) {
        Snackbar.make(view, messageId, Snackbar.LENGTH_LONG).show()
    }

    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    fun showToast(context: Context, @StringRes messageId: Int) {
        Toast.makeText(context, messageId, Toast.LENGTH_LONG).show()
    }
}