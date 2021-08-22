package com.e.myzipcoe.modelclass;

import android.content.Context;

import com.e.myzipcoe.adapterclass.AdapterClass;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ModelClassZIp  {
        @SerializedName("error")
        private Integer error;
        @SerializedName("data")
        private Data data;
        @SerializedName("msg")
        private String msg;


    public Integer getError() {
            return error;
        }

        public void setError(Integer error) {
            this.error = error;
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

    public class Data {


        private java.util.List<List> list = null;

        private Integer count;

        public java.util.List<List> getList() {
            return list;
        }

        public void setList(java.util.List<List> list) {
            this.list = list;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }
    }

//    public class Example {
//
//
//        private Integer error;
//
//        private Data data;
//
//        private String msg;
//
//        public Integer getError() {
//            return error;
//        }
//
//        public void setError(Integer error) {
//            this.error = error;
//        }
//
//        public Data getData() {
//            return data;
//        }
//
//        public void setData(Data data) {
//            this.data = data;
//        }
//
//        public String getMsg() {
//            return msg;
//        }
//
//        public void setMsg(String msg) {
//            this.msg = msg;
//        }
//    }
    public static class List {


        private Integer id;

        private Integer zipcode;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getZipcode() {
            return zipcode;
        }

        public void setZipcode(Integer zipcode) {
            this.zipcode = zipcode;
        }

    }
}
