package com.calculator.ahomeproject.main.profileFragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.calculator.ahomeproject.R;
import com.calculator.ahomeproject.main.MainActivity;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;
import org.jetbrains.annotations.NotNull;


public class DialogFragment extends androidx.fragment.app.DialogFragment {

    EditText edtTextName_dialog_profile, edtTextUsername_dialog_profile, edtTextLocation_dialog_profile, edtTextBio_dialog_profile;
    TextView txtSave_dialog_profile, txtCancel_dialog_profile;
    public interface OnInputListener {
        void updateName(String input);
        void updateLocation(String input);
        void updateBio(String input);
    }

    public OnInputListener onInputListener;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_editprofile_dialog, container, false);

        edtTextName_dialog_profile = view.findViewById(R.id.edtTextName_dialog_profile);
        edtTextLocation_dialog_profile = view.findViewById(R.id.edtTextLocation_dialog_profile);
        edtTextBio_dialog_profile = view.findViewById(R.id.edtTextBio_dialog_profile);

        txtSave_dialog_profile = view.findViewById(R.id.txtSave_dialog_profile);
        txtCancel_dialog_profile = view.findViewById(R.id.txtCancel_dialog_profile);

        txtSave_dialog_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updateName = edtTextName_dialog_profile.getText().toString();
                String updateLocation = edtTextLocation_dialog_profile.getText().toString();
                String updateBio = edtTextBio_dialog_profile.getText().toString();

                if(!updateName.equals("") && !updateLocation.equals("") && !updateBio.equals("")) {
                    //tasks
                    // 1. update database
                    // 2. reflect back to the page

                    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Profile");
                    query.whereEqualTo("user_name", ParseUser.getCurrentUser().getUsername());
                    query.setLimit(1);
                    query.findInBackground((objects, e) -> {
                        String objectID = "";
                        for (ParseObject object : objects) {
                            objectID = object.getObjectId();
                        }
                        ParseQuery<ParseObject> query1 = new ParseQuery<ParseObject>("Profile");
                        query1.getInBackground(objectID, (object, e12) -> {
                            if (e12 == null) {
                                // 1. update database
                                object.put("full_name", updateName);
                                object.put("location", updateLocation);
                                object.put("bio", updateBio);
                                object.saveInBackground(e1 -> {
                                    if(e1 ==null) {
                                        FancyToast.makeText(getContext(),"Profile updated", FancyToast.LENGTH_LONG,
                                                FancyToast.SUCCESS,false).show();
                                        dismiss();
                                    }else {
                                    }
                                });
//
                            } else {
                                Log.d("Tag", e12.getMessage());

                            }
                        });
                    });

                    //passing new value
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("prof_name", updateName);
                    editor.putString("prof_bio", updateBio);
                    editor.putString("prof_loc", updateLocation);
                    editor.apply();

                }else {
                    FancyToast.makeText(getContext(), "Fields cannot be left blank", FancyToast.LENGTH_LONG,
                            FancyToast.ERROR,false).show();
                }

            }

        });

        txtCancel_dialog_profile.setOnClickListener(v -> {
            dismiss();
        });

        return view;
    }


    private void refreshActivity() {
        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onInputListener = (OnInputListener) getActivity();
        }catch(ClassCastException e) {
            Log.e("TAG", "onAttach: ClassCastException: " + e.getMessage());
        }
    }


}
