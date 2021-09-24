import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.hiltdagger2tutorial.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var someClass: SomeClass
//    lateinit var someClassImpalementInt: SomeInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(someClass.doAThing())
//        someClassImpalementInt.doAThing()
    }

}

class SomeClass
@Inject
constructor(
    private val someInterface: SomeInterface
) {
    fun doAThing(): String {
        return "Look I got: ${someInterface.getAThing()}"
    }
}

class SomeDependency
@Inject
constructor() {
    fun getAThing(): String {
        return "A Thing"
    }
}


//class SomeInterfaceImp() : SomeInterface {
//    override fun doAThing(): String {
//        return "do A thing"
//    }
//
//}

interface SomeInterface {
    fun getAThing(): String
}