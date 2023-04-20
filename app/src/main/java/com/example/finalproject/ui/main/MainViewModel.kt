package com.example.finalproject.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.finalproject.Email
import org.json.JSONArray
import org.json.JSONObject


class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val url = "https://generateemailresponse.azurewebsites.net/api/httptrigger1"
    private var email = Email("","","","") // initialize an email object with empty components
    private var buttonPhase = 0
    private var _EmailMsgResponse = MutableLiveData("Response:")
    var EmailMsgResponse : LiveData<String> = _EmailMsgResponse

    fun getEmailResponse() : String{
        return email.Response
    }

    fun getEmailFrom(): String {
        return email.From
    }
    fun setEmailFrom(From : String){
        email.From=From
    }

    fun getEmailMsg(): String {
        return email.Message
    }
    fun setEmailMsg(Msg : String){
        email.Message=Msg
    }

    fun getEmailTo(): String {
        return email.To
    }
    fun setEmailTo(To : String){
        email.To=To
    }

    fun getEmailTone(): String {
        return email.Tone
    }
    fun setEmailTone(Tone : String){
        email.Tone=Tone
    }


    fun incrementButtonChoice(){
        buttonPhase = (buttonPhase+1)%2
    }
    fun getButtonChoice(): Int {
        return buttonPhase
    }

    //make sure that all entries are correctly entered
    fun Allset(): Boolean {
        return(email.From!="" && email.To!="" && email.Message!="" && email.Tone!="")
    }

    fun GenerateResponse(){

        if(Allset()) {
            val queue = Volley.newRequestQueue(getApplication<Application>().applicationContext)
            var SpecificUrl =
                url + "?message=" + email.Message + "&from=" + email.From + "&to=" + email.To + "&tone=" + email.Tone
            val stringRequest = StringRequest(
                Request.Method.GET, SpecificUrl,
                { response ->
                    var EmailResponse: JSONObject = JSONObject(response)
                    _EmailMsgResponse.value= EmailResponse.getString("response")
                    Log.i("MainViewModel",email.Response)

                }, {
                    Log.i("MainViewModel", "That didn't work!")
                }
            )
            stringRequest.setRetryPolicy(DefaultRetryPolicy(20000, 3, 1.0f));
            queue.add(stringRequest)
        }
        else{
            Log.i("MainViewModel","Email has not been initialized")
        }



    }



}

