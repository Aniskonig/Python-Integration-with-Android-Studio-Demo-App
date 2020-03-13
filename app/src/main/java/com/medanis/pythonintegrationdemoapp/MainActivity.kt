package com.medanis.pythonintegrationdemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chaquo.python.PyObject
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (! Python.isStarted()) {
            Python.start(AndroidPlatform(this))
        }
        val py : Python = Python.getInstance()
        val pyF : PyObject = py.getModule("testfile")
        val pyO : PyObject = pyF.callAttr("test")
        textView.text = pyO.toString()

    }
}
