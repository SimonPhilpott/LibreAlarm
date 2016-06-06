package com.pimpimmobile.librealarm.shareddata.settings;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.pimpimmobile.librealarm.shareddata.R;

public class PostponeSettings extends Settings {

    private EditText mMinutesView;
    public long time = -1;

    @Override
    public String getSettingsValue() {
        if (!TextUtils.isEmpty(mMinutesView.getText().toString())) {
            setSettingsValue("" + Float.valueOf(mMinutesView.getText().toString()) * 60000);
        }
        return String.valueOf(time);
    }

    @Override
    public void setSettingsValue(String data) {
        if (!TextUtils.isEmpty(data)) {
            time = (long) ((float) Float.valueOf(data));
        } else {
            time = -1;
        }
        if (mMinutesView != null && data != null) mMinutesView.setText(data);
    }

    @Override
    public boolean isObligatory() {
        return true;
    }

    @Override
    public View getView(LayoutInflater inflater, ViewGroup parent) {
        View v = inflater.inflate(R.layout.settings_edit_text, parent, false);
        ((TextView)v.findViewById(R.id.title)).setText("Next check in");
        mMinutesView = (EditText) v.findViewById(R.id.value);
        mMinutesView.setHint("Minutes");
        mMinutesView.setInputType(EditorInfo.TYPE_NUMBER_FLAG_SIGNED);
        return v;
    }

}
