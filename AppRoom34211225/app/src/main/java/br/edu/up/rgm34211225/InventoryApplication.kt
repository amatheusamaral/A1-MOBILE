package br.edu.up.rgm34211225

import android.app.Application
import br.edu.up.rgm34211225.data.AppContainer
import br.edu.up.rgm34211225.data.AppDataContainer

class InventoryApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}