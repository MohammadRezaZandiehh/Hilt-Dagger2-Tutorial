import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.hiltdagger2tutorial.R
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(someClass.doAThing())
    }
}

class SomeClass
@Inject
constructor(
    private val someInterfaceImpl: SomeInterface,
    private val gson: Gson
){
    fun doAThing(): String{
        return "Look I got: ${someInterfaceImpl.getAThing()}"
    }
}

class SomeInterfaceImpl
@Inject
constructor(): SomeInterface {
    override fun getAThing() : String{
        return "A Thing"
    }
}

interface SomeInterface{
    fun getAThing(): String
}

// ***REMEMBER***
// Notice this doesn't compile because dagger doesn't know how to build the Gson object, even though we added it to the module.
@InstallIn(ApplicationComponent::class)
@Module
abstract class MyModule{

    @Singleton
    @Binds
    abstract fun bindSomeDependency(
        someImpl: SomeInterfaceImpl
    ): SomeInterface

    // note this is from the dependency: "com.squareup.retrofit2:converter-gson:2.6.0"
    @Singleton
    @Binds
    abstract fun bindGson(
        gson: Gson
    ): Gson
}