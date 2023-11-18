package nsda.com.sharedprefarences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import nsda.com.sharedprefarences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        val sh = getSharedPreferences("Mydata", MODE_PRIVATE)
        val s1 = sh.getString("Name",null)
        val s2 = sh.getString("Email", null)

        binding.editTextText.setText(s1)
        binding.editTextText2.setText(s2)
    }

    override fun onPause() {
        super.onPause()
        // Creating a shared pref object with a file name "MySharedPref" in private mode
        val sharedPreferences = getSharedPreferences("Mydata", MODE_PRIVATE)
        val myEdit = sharedPreferences.edit()

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putString("Name",  binding.editTextText.text.toString())
        myEdit.putString("Email",  binding.editTextText2.text.toString())
        myEdit.apply()
    }
}