package com.eclite.map

import com.amap.api.maps.model.Marker

/**
 * Created by zhangshengli on 2017/11/1.
 */
interface ClusterPresenter<T> {
    fun addPoint(t:T)
    fun addPoint(list:ArrayList<T>)
    fun deletePoint(t:T)
    fun deletePoint(list:ArrayList<T>)
    fun onResume()
    fun onPause()
    fun onDestroy()
    fun setOnMarkerClickListener(markClickListener: MarkClickListener<T>)
}

interface MarkClickListener<P>{
    fun onClick(marker: Marker,list: List<P>)
}