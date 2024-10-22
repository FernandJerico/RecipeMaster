package com.ferico.recipemaster.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ferico.recipemaster.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Notification.newInstance] factory method to
 * create an instance of this fragment.
 */
class Notification : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notification, container, false)

        val btnNotificationAll = view.findViewById<Button>(R.id.btn_notification_all)
        val btnNotificationRead = view.findViewById<Button>(R.id.btn_notification_read)
        val btnNotificationUnread = view.findViewById<Button>(R.id.btn_notification_unread)

        // Set initial selection for buttons
        btnNotificationAll.isSelected = true
        btnNotificationRead.isSelected = false
        btnNotificationUnread.isSelected = false

        // Show VideoFragment initially
        loadFragment(NotificationAll())

        // Set click listeners for the buttons
        btnNotificationAll.setOnClickListener {
            btnNotificationAll.isSelected = true
            btnNotificationRead.isSelected = false
            btnNotificationUnread.isSelected = false
            loadFragment(NotificationAll())
        }

        btnNotificationRead.setOnClickListener {
            btnNotificationAll.isSelected = false
            btnNotificationRead.isSelected = true
            btnNotificationUnread.isSelected = false
            loadFragment(NotificationRead())
        }

        btnNotificationUnread.setOnClickListener {
            btnNotificationAll.isSelected = false
            btnNotificationRead.isSelected = false
            btnNotificationUnread.isSelected = true
            loadFragment(NotificationUnread())
        }

        return view
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container_notification, fragment)
        transaction.commit()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Notification.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Notification().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}