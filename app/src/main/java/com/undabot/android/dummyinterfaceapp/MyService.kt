package com.undabot.android.dummyinterfaceapp


class MyService {

    private var listener = addListener()

    fun connect() {
        mockAllActions()
    }

    private fun mockAllActions() {
        listener.onServiceError("This is my error to you")
        listener.onServiceActionResult("This is my action result")
        listener.onServiceDisconnected()
        listener.onServiceConnected()
        listener.onServiceReinitialized()
    }

    fun addListener(
            serviceError: ((msg: String) -> Unit)? = null,
            serviceConnected: (() -> Unit)? = null,
            serviceDisconnected: (() -> Unit)? = null,
            serviceReinitialized: (() -> Unit)? = null,
            serviceActionResult: ((result: String) -> Unit)? = null): MyServiceCallback {

        val listener = object : MyServiceCallback {
            override fun onServiceError(msg: String) {
                serviceError?.invoke(msg)
            }

            override fun onServiceConnected() {
                serviceConnected?.invoke()
            }

            override fun onServiceDisconnected() {
                serviceDisconnected?.invoke()
            }

            override fun onServiceReinitialized() {
                serviceReinitialized?.invoke()
            }

            override fun onServiceActionResult(result: String) {
                serviceActionResult?.invoke(result)
            }
        }
        addListener (listener)
        return listener
    }

    fun addListener(listener: MyServiceCallback){
        this.listener = listener
    }

    interface MyServiceCallback {
        fun onServiceError(msg: String)
        fun onServiceConnected()
        fun onServiceDisconnected()
        fun onServiceReinitialized()
        fun onServiceActionResult(result: String)
    }
}