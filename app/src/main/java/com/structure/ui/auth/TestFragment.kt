package com.structure.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.structure.R
import kotlinx.android.synthetic.main.test_fragment.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class TestFragment : Fragment() {

    companion object {
        fun newInstance() = TestFragment()
    }

    val viewModel by inject<TestViewModel>()
    val sharedViewModel : SharedViewModel by sharedViewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.test_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel = ViewModelProvider(this, viewModelFactory)
//            .get(TestViewModel::class.java)

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {  }

//        sharedViewModel = ViewModelProvider(activity!!,viewModelFactory)
//            .get(SharedViewModel::class.java)

        viewModel.name.value="testing for observer"

        viewModel.name.observe(viewLifecycleOwner, object : Observer<String> {
            override fun onChanged(t: String?) {
                tv.text = t!!
            }

        })

        sharedViewModel!!.data.observe(this, object : Observer<String> {
            override fun onChanged(t: String?) {
                tv.text = t!!
            }

        })
    }
}
