package com.example.chleh.test2;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_Main_First.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_Main_First#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Main_First extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;
    private ListView listview;
    private Adapter_Main_Item_List adapter;
    private OnFragmentInteractionListener mListener;

    public Fragment_Main_First() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Main_First.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Main_First newInstance(String param1, String param2) {
        Fragment_Main_First fragment = new Fragment_Main_First();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fragment__main__first, container, false);
        listview = view.findViewById(R.id.listview_Main_Item_List);
        String [] texts = getResources().getStringArray(R.array.testing_spinner); // UI 변수설정
        /* adapter = new MyBaseAdapter();*/
        Resources res = getResources();
        adapter= new Adapter_Main_Item_List(this.getActivity());
        /// 파일 데이터 추가
        //adapter.func_Add_Item(new Java_Main_List_Item(res.getDrawable(R.drawable.bee,null),texts[0],false));//수정필요
        adapter.func_Add_Item(new Java_Main_List_Item("car.jpg",texts[1],false));//수정필요
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Intent myIntent = new Intent(getActivity(), item_detail.class);//구체적 뷰
                //startActivity(myIntent);
            }
        });
        return view;





    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}