package com.splanes.apps.dutyfruty.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.FragmentActivity
import com.splanes.apps.dutyfruty.ui.theme.DutyFrutyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DutyFrutyActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            DutyFrutyTheme {
                DutyFrutyApp()
            }
        }
    }
}
