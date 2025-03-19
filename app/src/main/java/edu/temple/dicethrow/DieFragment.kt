package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

val DIESIDE = "sidenumber"
val DIENUM = "dienum"

class DieFragment : Fragment() {


    lateinit var dieTextView: TextView

    var dieSides: Int = 6
    var dieVal: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(savedInstanceState == null) {
            throwDie()
        }
        else {
            dieVal = savedInstanceState.getInt(DIENUM)
            dieTextView.setText(dieVal.toString())
        }
    }

    fun throwDie() {
        dieVal = (Random.nextInt(dieSides) + 1)
        dieTextView.text = dieVal.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(DIENUM, dieVal)
    }

    companion object {
        fun newInstance(sides : Int) : DieFragment{
            val fragment = DieFragment()
            val bundle = Bundle()
            bundle.putInt(DIESIDE, sides)
            fragment.arguments = bundle

            return fragment
        }
    }
}