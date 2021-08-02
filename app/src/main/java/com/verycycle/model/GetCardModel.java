package com.verycycle.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetCardModel {

    @SerializedName("result")
    @Expose
    public List<Result> result = null;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("status")
    @Expose
    public String status;


    public class Result {

        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("user_id")
        @Expose
        public String userId;
        @SerializedName("date_time")
        @Expose
        public String dateTime;
        @SerializedName("card_number")
        @Expose
        public String cardNumber;
        @SerializedName("expiry_date")
        @Expose
        public String expiryDate;
        @SerializedName("expiry_month")
        @Expose
        public String expiryMonth;
        @SerializedName("cvc_code")
        @Expose
        public String cvcCode;

        @SerializedName("card_holder_name")
        @Expose
        public String cardHolderName;



        @SerializedName("Chk")
        @Expose
        public boolean chk;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getDateTime() {
            return dateTime;
        }

        public void setDateTime(String dateTime) {
            this.dateTime = dateTime;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        public String getExpiryDate() {
            return expiryDate;
        }

        public void setExpiryDate(String expiryDate) {
            this.expiryDate = expiryDate;
        }

        public String getExpiryMonth() {
            return expiryMonth;
        }

        public void setExpiryMonth(String expiryMonth) {
            this.expiryMonth = expiryMonth;
        }

        public String getCvcCode() {
            return cvcCode;
        }

        public void setCvcCode(String cvcCode) {
            this.cvcCode = cvcCode;
        }

        public boolean isChk() {
            return chk;
        }

        public void setChk(boolean chk) {
            this.chk = chk;
        }
    }
}


