package com.example.bistterm;
import android.app.Dialog;
import android.content.Context;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.View;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.example.bistterm.MainActivity;

public class SetupDialog extends Dialog {

    private MainActivity.DIFFICULTY difficulty;
    private MainActivity.CELL_SIZE size;
    private SetupDialog mDlg;

    public SetupDialog(Context ctx, MainActivity.DIFFICULTY df, MainActivity.CELL_SIZE sz) {
        super(ctx);
        setContentView(R.layout.setup);
        mDlg = this;

        findViewById(R.id.dlgOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                MainActivity a = (MainActivity)mDlg.getOwnerActivity();
                a.setup(difficulty, size);
                mDlg.dismiss();
            }
        });

        findViewById(R.id.dlgCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mDlg.dismiss();
            }
        });

        RadioGroup rg = (RadioGroup)findViewById(R.id.difficulty);
        rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                switch(arg1) {
                    case R.id.df_easy:
                        difficulty = MainActivity.DIFFICULTY.EASY;
                        break;
                    case R.id.df_medium:
                        difficulty = MainActivity.DIFFICULTY.MEDIUM;
                        break;
                    case R.id.df_hard:
                        difficulty = MainActivity.DIFFICULTY.HARD;
                        break;
                }
            }
        });

        rg = (RadioGroup)findViewById(R.id.cellsize);
        rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                switch(arg1) {
                    case R.id.size_small:
                        size = MainActivity.CELL_SIZE.SMALL;
                        break;
                    case R.id.size_medium:
                        size = MainActivity.CELL_SIZE.MEDIUM;
                        break;
                    case R.id.size_large:
                        size = MainActivity.CELL_SIZE.LARGE;
                        break;
                }
            }
        });

        switch(df) {
            case EASY:
                ((RadioButton)findViewById(R.id.df_easy)).setChecked(true);
                break;
            case MEDIUM:
                ((RadioButton)findViewById(R.id.df_medium)).setChecked(true);
                break;
            case HARD:
                ((RadioButton)findViewById(R.id.df_hard)).setChecked(true);
                break;
        }

        switch(sz) {
            case SMALL:
                ((RadioButton)findViewById(R.id.size_small)).setChecked(true);
                break;
            case MEDIUM:
                ((RadioButton)findViewById(R.id.size_medium)).setChecked(true);
                break;
            case LARGE:
                ((RadioButton)findViewById(R.id.size_large)).setChecked(true);
                break;
        }

    }

}
