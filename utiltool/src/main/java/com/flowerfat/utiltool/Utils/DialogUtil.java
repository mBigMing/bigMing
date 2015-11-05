package com.flowerfat.utiltool.Utils;


import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

public class DialogUtil {

    private OnDialogListener mInterface;

    private static DialogUtil mInstance;

    public static DialogUtil getInstance() {
        if (mInstance == null) {
            synchronized (DialogUtil.class) {
                if (mInstance == null) {
                    mInstance = new DialogUtil();
                }
            }
        }
        return mInstance;
    }

    public void One(Context context, String title, String message, String btName) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title).setMessage(message);
        builder.setPositiveButton(btName,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mInterface.OnDialog(1);
                    }
                });
        builder.show();
    }

    public void two(Context context, String title, String message, String posBtName, String negBtName) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title).setMessage(message);
        builder.setPositiveButton(posBtName,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mInterface.OnDialog(1);
                    }
                });
        builder.setNegativeButton(negBtName,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mInterface.OnDialog(-1);
                    }
                }).show();
        builder.show();
    }

    public void three(Context context, String title, String message, String posBtName, String neuBtName, String negBtName) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title).setMessage(message);
        builder.setPositiveButton(posBtName,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mInterface.OnDialog(1);
                    }
                });
        builder.setNeutralButton(neuBtName, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mInterface.OnDialog(0);
            }
        });
        builder.setNegativeButton(negBtName,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mInterface.OnDialog(-1);
                    }
                }).show();
        builder.show();
    }

    public void OnDialogListener(OnDialogListener listener) {
        if (mInterface != null)
            mInterface = listener;
    }

    public abstract interface OnDialogListener {
        public abstract void OnDialog(int action);
    }
}
