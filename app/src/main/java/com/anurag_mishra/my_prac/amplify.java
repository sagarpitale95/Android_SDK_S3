package com.anurag_mishra.my_prac;


import android.content.Context;
import android.os.Environment;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.anurag_mishra.my_prac.cred;

import java.io.File;
import java.io.IOException;

import java.io.File;

import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;

public class amplify{
    cred Cred = new cred();
    String[] credentials = Cred.getCred();


    Regions clientRegion = Regions.DEFAULT_REGION;
    String bucketName = "demomoto";
    String stringObjKeyName = credentials[0];
    String fileObjKeyName = credentials[1];
    String fileName = new String();
    String path = new String();
    public amplify(String fileName, String path){

        this.fileName = fileName;
        this.path = path;

    }

    public String upload(Context context){
        try {
            AWSCredentials credentials = new BasicAWSCredentials(stringObjKeyName, fileObjKeyName);
            AmazonS3 s3 = new AmazonS3Client(credentials);
            TransferUtility transferUtility = new TransferUtility(s3,context);
            TransferObserver observer = transferUtility.upload(bucketName,this.fileName, new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/document/addresses.csv"));
//            observer.setTransferListener(new TransferListener() {
//                @Override
//                public void onStateChanged(int id, TransferState state) {
//                    // do something
//                    progress.hide();
//                    path.setText("ID "+id+"\nState "+state.name()+"\nImage ID "+OBJECT_KEY);
//
//                }
//
//                @Override
//                public void onProgressChanged(int id, long bytesCurrent, long bytesTotal) {
//                    int percentage = (int) (bytesCurrent / bytesTotal * 100);
//                    progress.setProgress(percentage);
//                    //Display percentage transfered to user
//                }
//
//                @Override
//                public void onError(int id, Exception ex) {
//                    // do something
//                    Log.e("Error  ",""+ex );
//                }
            return "Successfull";
        }
        catch (Exception e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
            return e.toString();
        }
    }

}

