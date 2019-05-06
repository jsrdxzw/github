package com.jsrdxzw.github.util

import com.jsrdxzw.github.AppContext
import com.jsrdxzw.github.common.PreferenceDelegate

object Settings{
    var email:String by PreferenceDelegate(AppContext,"email","")
    var password:String by PreferenceDelegate(AppContext,"password","")
}