package com.dengzii.plugin.adb.ui

import com.dengzii.plugin.adb.Device
import com.intellij.ui.components.JBLabel
import java.awt.BorderLayout
import java.awt.Component
import javax.swing.JPanel
import javax.swing.JTable
import javax.swing.table.TableCellRenderer

/**
 * <pre>
 * author : dengzi
 * e-mail : denua@foxmail.com
 * github : https://github.com/MrDenua
 * time   : 2019/10/9
 * desc   :
 * </pre>
 */
class TableOperateCellRenderer : TableCellRenderer {

    override fun getTableCellRendererComponent(table: JTable?, device: Any?,
                                               isSelected: Boolean, hasFocus: Boolean,
                                               row: Int, column: Int): Component {
        if (device !is Device) {
            return JBLabel("-")
        }
        val status = device.status
        val panel = JPanel()
        panel.layout = BorderLayout()

        val button = Button(status.name.toLowerCase())
        button.isEnabled = false
        when (status) {
            Device.STATUS.CONNECTED -> {
                button.isEnabled = true
                button.text = "disconnect"
                button.redText()
            }
            Device.STATUS.ONLINE, Device.STATUS.DISCONNECT -> {
                button.isEnabled = true
                button.text = "connect"
                button.greenText()
            }
        }

        panel.add(button, BorderLayout.CENTER)
        return panel
    }
}