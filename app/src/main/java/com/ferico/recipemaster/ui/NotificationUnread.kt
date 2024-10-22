package com.ferico.recipemaster.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ferico.recipemaster.R
import com.ferico.recipemaster.adapter.NotificationAdapter
import com.ferico.recipemaster.data.Notification

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NotificationUnread.newInstance] factory method to
 * create an instance of this fragment.
 */
class NotificationUnread : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var notificationAdapter: NotificationAdapter

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification_unread, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Initialising RecyclerView
        val rvNotificationUnread = view.findViewById<RecyclerView>(R.id.rv_notification_unread)
        val rvNotificationUnreadLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rvNotificationUnread.layoutManager = rvNotificationUnreadLayoutManager

        val notificationList = listOf(
            Notification(
                "New recipe!",
                "Far far away, behind the word mountains, far from the countries.",
                clicked = true
            ),
            Notification(
                "Don’t forget to try your saved recipe",
                "Far far away, behind the word mountains, far from the countries.",
                clicked = true
            ),
            Notification(
                "Don’t forget to try your saved recipe",
                "Far far away, behind the word mountains, far from the countries.",
                clicked = true
            ),
        )

        notificationAdapter = NotificationAdapter(notificationList){

        }
        rvNotificationUnread.adapter = notificationAdapter

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NotificationUnread.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NotificationUnread().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}