/*
 * Copyright (C) 2013 Andreas Stuetz <andreas.stuetz@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package agronet.mpayer.zegetech.com.mpayercashbox.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

import agronet.mpayer.zegetech.com.mpayercashbox.AccountsActivity;
import agronet.mpayer.zegetech.com.mpayercashbox.MembersActivity;
import agronet.mpayer.zegetech.com.mpayercashbox.OrdersActivity;
import agronet.mpayer.zegetech.com.mpayercashbox.R;
import agronet.mpayer.zegetech.com.mpayercashbox.ReportsActivity;
import agronet.mpayer.zegetech.com.mpayercashbox.SettingsActivity;
import agronet.mpayer.zegetech.com.mpayercashbox.TransactionsActivity;
import agronet.mpayer.zegetech.com.mpayercashbox.utils.Constants;


public class HomeMenuFragment extends Fragment {

    private static final String ARG_POSITION = "position";

    private int position;

    public static HomeMenuFragment newInstance(int position) {
        HomeMenuFragment f = new HomeMenuFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(ARG_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        switch (position) {
            case 0:
                View view = inflater.inflate(R.layout.fragment_home, container, false);

                TextView tv = (TextView) view.findViewById(R.id.orders);
                tv.setTypeface(Constants.getCustomFace(getActivity(), "Open"));

                ImageView btnOrders = (ImageView) view.findViewById(R.id.ordersBtn);
                btnOrders.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getActivity(), OrdersActivity.class);
                        startActivity(i);
                    }
                });
                tv = (TextView) view.findViewById(R.id.transactions);
                tv.setTypeface(Constants.getCustomFace(getActivity(), "Open"));

                ImageView btnTransactions = (ImageView) view.findViewById(R.id.transactionsBtn);
                btnTransactions.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getActivity(), TransactionsActivity.class);
                        startActivity(i);
                    }
                });

                tv = (TextView) view.findViewById(R.id.accounts);
                tv.setTypeface(Constants.getCustomFace(getActivity(), "Open"));

                ImageView btnAccounts = (ImageView) view.findViewById(R.id.accountsBtn);
                btnAccounts.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getActivity(), AccountsActivity.class);
                        startActivity(i);
                    }
                });

                tv = (TextView) view.findViewById(R.id.members);
                tv.setTypeface(Constants.getCustomFace(getActivity(), "Open"));

                ImageView btnMembers = (ImageView) view.findViewById(R.id.membersBtn);
                btnMembers.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getActivity(), MembersActivity.class);
                        startActivity(i);
                    }
                });

                tv = (TextView) view.findViewById(R.id.reports);
                tv.setTypeface(Constants.getCustomFace(getActivity(), "Open"));

                ImageView btnReports = (ImageView) view.findViewById(R.id.reportsBtn);
                btnReports.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getActivity(), ReportsActivity.class);
                        startActivity(i);
                    }
                });

                tv = (TextView) view.findViewById(R.id.settings);
                tv.setTypeface(Constants.getCustomFace(getActivity(), "Open"));

                ImageView btnSettings = (ImageView) view.findViewById(R.id.settingsBtn);
                btnSettings.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getActivity(), SettingsActivity.class);
                        startActivity(i);
                    }
                });
                return view;
            case 1:
                LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
                FrameLayout fl = new FrameLayout(getActivity());

                fl.setLayoutParams(params);

                final int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8,
                        getResources().getDisplayMetrics());
                TextView v = new TextView(getActivity());
                params.setMargins(margin, margin, margin, margin);
                v.setLayoutParams(params);
                v.setLayoutParams(params);
                v.setGravity(Gravity.CENTER);
                v.setText("LOG");

                fl.addView(v);
                return fl;
        }
        return null;
    }
}