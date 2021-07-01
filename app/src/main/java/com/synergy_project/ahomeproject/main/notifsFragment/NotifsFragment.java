package com.synergy_project.ahomeproject.main.notifsFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.synergy_project.ahomeproject.R;
import org.jetbrains.annotations.NotNull;

public class NotifsFragment extends Fragment {

    String[] notif, time;
    int[] image = {R.drawable.emma, R.drawable.emma, R.drawable.emma, R.drawable.a_home_logo};
    SwipeRefreshLayout swipe_refresh;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_notifs, container, false);

        notif = getResources().getStringArray(R.array.notif_desc);
        time = getResources().getStringArray(R.array.Notif_time);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_fragment_notif);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(new NotifListAdapter(notif, time, image));
        swipe_refresh = view.findViewById(R.id.swipe_refresh);
        swipe_refresh.setOnRefreshListener(() -> swipe_refresh.setRefreshing(false));

        return view;
    }
}