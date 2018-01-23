package com.owen.blogapp;

import java.lang.ref.WeakReference;
import java.util.Locale;

/**
 * Created by owen on 2017/11/19.
 */

public class Phone {

    private enum TYPE {IOS, ANDROID, WINDOW_PHONE, OTHER}

    private TYPE mType;
    private boolean mWifi;
    private boolean mBluetooth;
    private int mMemorySize;
    private int mDiskSize;
    private int mPowerSize;
    private Locale mLocale;
    private String mDefaultInput;
    private String[] mOther;

    public Phone(){}

    public Phone(TYPE mType, boolean mWifi, boolean mBluetooth,
                 int mMemorySize, int mDiskSize, int mPowerSize,
                 Locale mLocale, String mDefaultInput, String[] mOther, String... other) {
        this.mType = mType;
        this.mWifi = mWifi;
        this.mBluetooth = mBluetooth;
        this.mMemorySize = mMemorySize;
        this.mDiskSize = mDiskSize;
        this.mPowerSize = mPowerSize;
        this.mLocale = mLocale;
        this.mDefaultInput = mDefaultInput;
        this.mOther = mOther;
    }

    public TYPE getType() {
        return mType;
    }

    public void setType(TYPE mType) {
        this.mType = mType;
    }

    public boolean ismWifi() {
        return mWifi;
    }

    public void setWifi(boolean mWifi) {
        this.mWifi = mWifi;
    }

    public boolean ismBluetooth() {
        return mBluetooth;
    }

    public void setBluetooth(boolean mBluetooth) {
        this.mBluetooth = mBluetooth;
    }

    public int getMemorySize() {
        return mMemorySize;
    }

    public void setMemorySize(int mMemorySize) {
        this.mMemorySize = mMemorySize;
    }

    public int getDiskSize() {
        return mDiskSize;
    }

    public void setDiskSize(int mDiskSize) {
        this.mDiskSize = mDiskSize;
    }

    public int getPowerSize() {
        return mPowerSize;
    }

    public void setPowerSize(int mPowerSize) {
        this.mPowerSize = mPowerSize;
    }

    public Locale getLocale() {
        return mLocale;
    }

    public void setLocale(Locale mLocale) {
        this.mLocale = mLocale;
    }

    public String getDefaultInput() {
        return mDefaultInput;
    }

    public void setDefaultInput(String mDefaultInput) {
        this.mDefaultInput = mDefaultInput;
    }

    public String[] getOther() {
        return mOther;
    }

    public void setOther(String[] mOther) {
        this.mOther = mOther;
    }

    public static class Builder {

        private WeakReference<TYPE> mWType;
        private WeakReference<Boolean> mWWifi;
        private WeakReference<Boolean> mWBluetooth;
        private WeakReference<Integer> mWMemorySize;
        private WeakReference<Integer> mWDiskSize;
        private WeakReference<Integer> mWPowerSize;
        private WeakReference<Locale> mWLocale;
        private WeakReference<String> mWDefaultInput;
        private WeakReference<String[]> mWOther;

        public Builder setType(TYPE type) {
            mWType = new WeakReference<>(type);
            return this;
        }

        public Builder setWifiEnable(boolean wifiEnable) {
            mWWifi = new WeakReference<>(wifiEnable);
            return this;
        }

        public Builder setBTEnable(boolean setBTEnable) {
            mWBluetooth = new WeakReference<>(setBTEnable);
            return this;
        }

        public Builder setemorySize(int size) {
            mWMemorySize = new WeakReference<>(size);
            return this;
        }

        public Builder setDiskSize(int diskSize) {
            mWDiskSize = new WeakReference<>(diskSize);
            return this;
        }

        public Builder setPowerSize(int powerSize) {
            mWPowerSize = new WeakReference<>(powerSize);
            return this;
        }

        public Builder setLocale(Locale locale) {
            mWLocale = new WeakReference<>(locale);
            return this;
        }

        public Builder setDefaultInput(String defaultInput) {
            mWDefaultInput = new WeakReference<>(defaultInput);
            return this;
        }

        public Builder setOther(String... other) {
            mWOther = new WeakReference<>(other);
            return this;
        }

        public Phone build() {
            Phone phone = new Phone();
            if (mWType != null && mWType.get()!= null){
                phone.setType(mWType.get());
            }

            if (mWBluetooth != null && mWBluetooth.get()!= null){
                phone.setBluetooth(mWBluetooth.get());
            }

            if (mWMemorySize != null && mWMemorySize.get()!= null){
                phone.setMemorySize(mWMemorySize.get());
            }

            if (mWDiskSize != null && mWDiskSize.get()!= null){
                phone.setDiskSize(mWDiskSize.get());
            }

            if (mWPowerSize != null && mWPowerSize.get()!= null){
                phone.setPowerSize(mWPowerSize.get());
            }

            if (mWLocale != null && mWLocale.get()!= null){
                phone.setLocale(mWLocale.get());
            }

            if (mWDefaultInput != null && mWDefaultInput.get()!= null){
                phone.setDefaultInput(mWDefaultInput.get());
            }

            if (mWOther != null && mWOther.get()!= null){
                phone.setOther(mWOther.get());
            }

            return phone;
        }
    }
}
