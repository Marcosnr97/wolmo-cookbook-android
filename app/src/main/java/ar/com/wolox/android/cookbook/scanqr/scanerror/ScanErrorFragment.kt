package ar.com.wolox.android.cookbook.scanqr.scanerror

import ar.com.wolox.android.cookbook.R
import ar.com.wolox.android.cookbook.scanqr.ScanQrActivity
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_scan_error.*
import javax.inject.Inject

class ScanErrorFragment @Inject constructor() : WolmoFragment<ScanErrorPresenter>() {
    override fun init() {
        setListeners()
    }

    override fun layout(): Int = R.layout.fragment_scan_error

    override fun setListeners() {
        super.setListeners()
        bGoToScanMenu.setOnClickListener {
            (activity as ScanQrActivity).showScanMenuFragment()
        }
    }
}