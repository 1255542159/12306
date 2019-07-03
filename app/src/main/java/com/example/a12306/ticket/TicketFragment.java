package com.example.a12306.ticket;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.a12306.R;
//订票
public class TicketFragment extends Fragment implements View.OnClickListener{
    private View view;
    private TextView tvTicketStationFrom,tvTicketStationTo,tvTicketDateFrom;
    private ImageView imgTicketExchange;
    public TicketFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_ticket_fragment, container, false);
        initView();
        return view;
    }

    private void initView() {
        tvTicketStationFrom = (TextView)view.findViewById(R.id.tvTicketStationFrom);
        tvTicketStationFrom.setOnClickListener(this);
        tvTicketStationTo = (TextView)view.findViewById(R.id.tvTicketStationTo);
        tvTicketStationTo.setOnClickListener(this);
        imgTicketExchange = (ImageView)view.findViewById(R.id.imgTicketExchange);
        imgTicketExchange.setOnClickListener(this);
        tvTicketDateFrom = (TextView)view.findViewById(R.id.tvTicketDateFrom);
        tvTicketDateFrom.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.tvTicketStationFrom:
                Intent intent = new Intent(getActivity(),CityActivity.class);
                startActivity(intent);
                break;
            case R.id.tvTicketStationTo:
                Intent intent1 = new Intent(getActivity(),CityActivity.class);
                startActivity(intent1);
                break;
            case R.id.imgTicketExchange:
                /*animation = AnimationUtils.loadAnimation(getActivity(),
                        R.anim.anim_set);
                tvTicketStationTo.startAnimation(animation);
                tvTicketStationFrom.startAnimation(animation);*/
                TranslateAnimation animation = new TranslateAnimation(0,150,0,0);
                animation.setInterpolator(new LinearInterpolator());
                animation.setDuration(500);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        tvTicketStationFrom.clearAnimation();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                tvTicketStationFrom.startAnimation(animation);

                break;
            case R.id.tvTicketDateFrom:


        }

    }
}
