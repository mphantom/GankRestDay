package com.mphantom.forrest.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.mphantom.forrest.R
import org.jetbrains.anko.find

class MainActivity : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        //        service = GankService.create()
        //        service.getDataByDate("2016", "03", "08")
        //                .subscribeOn(Schedulers.io())
        //                .observeOn(AndroidSchedulers.mainThread())
        //                .subscribe({ u -> Log.i("testfortheapi", "${u.results.android.get(0).createdAt}") })
        //                .subscribe(object : Subscriber<Model.GankDay>() {
        //                    override fun onCompleted() {
        //                    }
        //
        //                    override fun onError(p0: Throwable?) {
        //                    }
        //
        //                    override fun onNext(p0: Model.GankDay?) {
        //                        Log.i("Log", "${p0?.category?.get(0)}")
        //                    }
        //
        //                });
    }

    fun initView() {
        toolbar = find<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
    }
}
