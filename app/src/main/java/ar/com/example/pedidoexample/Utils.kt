package ar.com.example.pedidoexample

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.toast(context: Context, message:String, long:Boolean = false){
    if (long){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }else{
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}