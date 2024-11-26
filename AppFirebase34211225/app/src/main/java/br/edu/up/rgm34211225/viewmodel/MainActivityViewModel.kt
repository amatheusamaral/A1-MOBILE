package br.edu.up.rgm34211225.viewmodel

import androidx.lifecycle.ViewModel
import br.edu.up.rgm34211225.Filters

/**
 * ViewModel for [com.google.firebase.example.fireeats.MainActivity].
 */

class MainActivityViewModel : ViewModel() {

    var isSigningIn: Boolean = false
    var filters: Filters = Filters.default
}
